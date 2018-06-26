package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.ArrayList;
import java.sql.Array;
import java.sql.ResultSet;
import src.DB;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    HttpSession s = request.getSession();
    String un = null;
    if (s.getAttribute("us") != null) {
        un = s.getAttribute("us").toString();
    }
    if (un == null) {
        response.sendRedirect("/PROJECT_STOCK_ADMIN/index.jsp");
    }

    try {
        final ResultSet rs = DB.search("SELECT comp_id,sell_price FROM comp_tr");
        final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        final DecimalFormat dec = new DecimalFormat("0.00");
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {

                    try {
                        rs.beforeFirst();
                        while (rs.next()) {
                            int rand = (int) (Math.random() * 7) + 1;
                            int flux = 0;
                            switch (rand) {
                                case 1:
                                    flux = -3;
                                    break;
                                case 2:
                                    flux = -2;
                                    break;
                                case 3:
                                    flux = -1;
                                    break;
                                case 4:
                                    flux = 0;
                                    break;
                                case 5:
                                    flux = 1;
                                    break;
                                case 6:
                                    flux = 2;
                                    break;
                                case 7:
                                    flux = 3;
                                    break;
                            }
                            float sellprice = Float.valueOf(rs.getString(2)) + flux;
                            if (sellprice < 0) {
                                sellprice = 0;
                            }
                            String timecode = df.format(new Date());

                            // System.out.println(rs.getString(1) + " : " + rs.getString(2) + " + " + flux + " : " + sellprice + " : " + timecode);
                            String query = "INSERT INTO stock.comp_stock(`comp_id`,`stock_price`,`time`,`status`)VALUES('" + rs.getString(1) + "','" + dec.format(sellprice) + "','" + timecode + "','')";
                          //  DB.Execute("UPDATE comp_tr SET stock_price='" + dec.format(sellprice) + "' WHERE comp_id='" + rs.getString(1) + "'");
                            DB.Execute(query);

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep(10000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    } catch (Exception e) {
        e.printStackTrace();
    }

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <title>Hello Bulma!</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/w3.css\">\r\n");
      out.write("        <script defer src=\"https://use.fontawesome.com/releases/v5.0.7/js/all.js\"></script>\r\n");
      out.write("        <!--FOR CHART-->\r\n");
      out.write("        <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js\"></script>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/common.css\">\r\n");
      out.write("        <script src=\"http://www.chartjs.org/dist/2.7.2/Chart.bundle.js\"></script>\r\n");
      out.write("        <script src=\"http://www.chartjs.org/samples/latest/utils.js\"></script>\r\n");
      out.write("        <!-- FOR CHART -->\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body> \r\n");
      out.write("\r\n");
      out.write("        <script>\r\n");
      out.write("            function createGroups() {\r\n");
      out.write("                var xhttp2 = new XMLHttpRequest();\r\n");
      out.write("                xhttp2.onreadystatechange = function () {\r\n");
      out.write("                    if (this.readyState == 4 && this.status == 200) {\r\n");
      out.write("                      //  document.getElementById(\"stAmount\").innerHTML = xhttp2.responseText;\r\n");
      out.write("                    }\r\n");
      out.write("                };\r\n");
      out.write("                xhttp2.open(\"POST\", \"create_groups\", true);\r\n");
      out.write("                xhttp2.send();\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!--MENU--> \r\n");
      out.write("\r\n");
      out.write("        <div class=\"w3-bar w3-orange\">\r\n");
      out.write("            <a href=\"#\" class=\"w3-bar-item w3-button w3-padding-large w3-hover-blue\">Home</a>\r\n");
      out.write("            <a href=\"#\" class=\"w3-bar-item w3-button w3-padding-large w3-hover-blue\">Link 1</a>\r\n");
      out.write("            <a href=\"#\" class=\"w3-bar-item w3-button w3-padding-large w3-hover-blue\">Link 2</a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <br/>\r\n");
      out.write("        <div class=\"w3-row\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"w3-col s8\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"w3-col s4\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"w3-card-4\">\r\n");
      out.write("\r\n");
      out.write("                    <button onclick=\"createGroups()\"></button>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div> \r\n");
      out.write("\r\n");
      out.write("        </div> \r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
