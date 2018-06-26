package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <title>Untitled Document</title>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"css/w3.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/common.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <style>\r\n");
      out.write("        body{\r\n");
      out.write("            background:url(images/back_index_ed.jpg);\r\n");
      out.write("            background-repeat:no-repeat;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <!-- MENU -->\r\n");
      out.write("        <div class=\"w3-bar w3-orange\">\r\n");
      out.write("            <a href=\"#\" class=\"w3-bar-item w3-button w3-padding-large w3-hover-blue\">Home</a>\r\n");
      out.write("            <a href=\"#\" class=\"w3-bar-item w3-button w3-padding-large w3-hover-blue\">Link 1</a>\r\n");
      out.write("            <a href=\"#\" class=\"w3-bar-item w3-button w3-padding-large w3-hover-blue\">Link 2</a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- MENU -->\r\n");
      out.write("\r\n");
      out.write("        <div class=\"w3-row\">\r\n");
      out.write("            <div class=\"w3-col s6 w3-center\"><p>s6</p></div>\r\n");
      out.write("            <div class=\"w3-col s6\" style=\"padding-right:180px;\">\r\n");
      out.write("                <div class=\"w3-panel w3-white\" style=\"margin-top:100px;padding-left:60px; padding-right:60px; padding-bottom:100px; opacity:0.95; border-radius:10px;\">\r\n");
      out.write("                    <h3  style=\"margin-top:100px;\">Sign in</h3>\r\n");
      out.write("\r\n");
      out.write("                    <form action=\"loginc\" method=\"POST\">\r\n");
      out.write("                        <input type=\"text\" name=\"username\" class=\"w3-input w3-border\"/>\r\n");
      out.write("                        <br/>\r\n");
      out.write("                        <input type=\"password\" name=\"password\" class=\"w3-input w3-border\"/>\r\n");
      out.write("                        <br/>\r\n");
      out.write("                        <input type=\"submit\" value=\"Login\" class=\"w3-button w3-orange\" />\r\n");
      out.write("                    </form>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
