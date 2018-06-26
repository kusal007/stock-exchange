package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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

    HttpSession s = request.getSession();
    String un = null;
    if (s.getAttribute("us") != null) {
        un = s.getAttribute("us").toString();

    }
    if (un == null) {
        response.sendRedirect("/PROJECT_STOCK/index.jsp");
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
      out.write("        <!--MENU--> \r\n");
      out.write("\r\n");
      out.write("        <script>\r\n");
      out.write("\r\n");
      out.write("            function logoutfun() {\r\n");
      out.write("\r\n");
      out.write("                window.location.replace(\"/PROJECT_STOCK/logout?uid=");
      out.print(un);
      out.write("\");\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"w3-bar w3-orange\">\r\n");
      out.write("            <a href=\"#\" class=\"w3-bar-item w3-button w3-padding-large w3-hover-blue\">Home</a>\r\n");
      out.write("            <a href=\"#\" class=\"w3-bar-item w3-button w3-padding-large w3-hover-blue\">Link 1</a>\r\n");
      out.write("            <a href=\"#\" class=\"w3-bar-item w3-button w3-padding-large w3-hover-blue\">Link 2</a>\r\n");
      out.write("            <p id=\"compNM\" class=\"w3-bar-item w3-padding-large\" style=\"font-weight: 700;\">Select a Company</p><input type=\"hidden\" id=\"compID\"/>\r\n");
      out.write("            <p class=\"w3-bar-item w3-button w3-padding-large w3-hover-blue\" onclick=\"logoutfun();\">LOGOUT</p>\r\n");
      out.write("        </div>\r\n");
      out.write("        <br/>\r\n");
      out.write("        <div class=\"w3-row\">\r\n");
      out.write("            <div class=\"w3-col s2 w3-padding-large\">\r\n");
      out.write("                <aside class=\"menu\">\r\n");
      out.write("\r\n");
      out.write("                    <p class=\"menu-label\">\r\n");
      out.write("                        Listed Companies\r\n");
      out.write("                    </p>\r\n");
      out.write("                    <ul class=\"menu-list\">\r\n");
      out.write("\r\n");
      out.write("                        <input type=\"hidden\" value=\"\" id=\"compIDH\"/>\r\n");
      out.write("                        <input type=\"hidden\" value=\"\" id=\"compPRICE\"/>\r\n");
      out.write("                        <input type=\"hidden\" value=\"\" id=\"ussi\"/>\r\n");
      out.write("                        <input type=\"hidden\" value=\"\" id=\"stat\"/>\r\n");
      out.write("                        ");

                            try {

                                ResultSet rs = DB.search("SELECT * FROM comp_tr");
                                while (rs.next()) {
                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <li><a onclick=\"setCompany('");
      out.print(rs.getString(2));
      out.write("', '");
      out.print(rs.getString(1));
      out.write("');\"> ");
      out.print(rs.getString(2));
      out.write("</a></li>\r\n");
      out.write("                            ");

                                    }

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    </ul>\r\n");
      out.write("\r\n");
      out.write("                </aside>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <br/>\r\n");
      out.write("                    <p class=\"menu-label\">RECENT TRANSACTIONS</p>\r\n");
      out.write("\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        ");

                            try {

                                ResultSet rs1 = DB.search("SELECT * FROM trans WHERE uid='" + s.getAttribute("us").toString() + "'");
                                while (rs1.next()) {
                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <li><a style=\"font-size: 12px;\">Rs. ");
 out.write(rs1.getString(5)); 
      out.write("</a><span style=\"font-size: 12px; color: red\"> - ");
 out.write(rs1.getString(7)); 
      out.write("</span></li>\r\n");
      out.write("                            ");

                                    }

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    </ul>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!--MENU-->\r\n");
      out.write("            <div class=\"w3-col s8 w3-centered\">\r\n");
      out.write("                <!--   <button id=\"randomizeData\">Randomize Data</button>\r\n");
      out.write("                   <button id=\"addDataset\">Add Dataset</button>\r\n");
      out.write("                   <button id=\"removeDataset\">Remove Dataset</button>\r\n");
      out.write("                   <button id=\"addData\">Add Data</button>\r\n");
      out.write("                   <button id=\"removeData\">Remove Data</button>\r\n");
      out.write("                <!-- CHART-->\r\n");
      out.write("                <p id=\"stAmount\">You have 20 stocks worth $<p>\r\n");
      out.write("\r\n");
      out.write("                    <canvas id=\"canvas\" width=\"100%\" height=\"60\" onload=\"setTimeout(addDT(); , 5000)\"></canvas>\r\n");
      out.write("                    <script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        function setCompany(cmp, compid) {\r\n");
      out.write("                            document.getElementById('compNM').innerHTML = cmp;\r\n");
      out.write("                            document.getElementById('compIDH').value = compid;\r\n");
      out.write("                            config.data.datasets.splice(0, 1);\r\n");
      out.write("                            window.myLine.update();\r\n");
      out.write("                            //add a new line\r\n");
      out.write("                            var colorNames = Object.keys(window.chartColors);\r\n");
      out.write("                            var colorName = colorNames[config.data.datasets.length % colorNames.length];\r\n");
      out.write("                            var newColor = window.chartColors[colorName];\r\n");
      out.write("                            var newDataset = {\r\n");
      out.write("                                label: 'Dataset ' + config.data.datasets.length,\r\n");
      out.write("                                backgroundColor: newColor,\r\n");
      out.write("                                borderColor: newColor,\r\n");
      out.write("                                data: [],\r\n");
      out.write("                                fill: false\r\n");
      out.write("                            };\r\n");
      out.write("                            for (var index = 0; index < config.data.labels.length; ++index) {\r\n");
      out.write("                                newDataset.data.push(0);\r\n");
      out.write("                            }\r\n");
      out.write("\r\n");
      out.write("                            config.data.datasets.push(newDataset);\r\n");
      out.write("                            window.myLine.update();\r\n");
      out.write("                            //add a new line\r\n");
      out.write("\r\n");
      out.write("                        }\r\n");
      out.write("\r\n");
      out.write("                        var MONTHS = ['1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'];\r\n");
      out.write("                        var config = {\r\n");
      out.write("                            type: 'line',\r\n");
      out.write("                            data: {\r\n");
      out.write("                                labels: ['1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'],\r\n");
      out.write("                                datasets: [{\r\n");
      out.write("                                        label: 'My First dataset',\r\n");
      out.write("                                        backgroundColor: window.chartColors.red, ////\r\n");
      out.write("                                        borderColor: window.chartColors.red,\r\n");
      out.write("                                        data: [\r\n");
      out.write("                                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0\r\n");
      out.write("                                        ],\r\n");
      out.write("                                        fill: false,\r\n");
      out.write("                                    }, ]\r\n");
      out.write("                            },\r\n");
      out.write("                            options: {\r\n");
      out.write("                                responsive: true,\r\n");
      out.write("                                title: {\r\n");
      out.write("                                    display: false,\r\n");
      out.write("                                    text: 'Chart.js Line Chart'\r\n");
      out.write("                                },\r\n");
      out.write("                                tooltips: {\r\n");
      out.write("                                    mode: 'index',\r\n");
      out.write("                                    intersect: false,\r\n");
      out.write("                                },\r\n");
      out.write("                                hover: {\r\n");
      out.write("                                    mode: 'nearest',\r\n");
      out.write("                                    intersect: true\r\n");
      out.write("                                },\r\n");
      out.write("                                scales: {\r\n");
      out.write("                                    xAxes: [{\r\n");
      out.write("                                            display: true,\r\n");
      out.write("                                            scaleLabel: {\r\n");
      out.write("                                                display: true,\r\n");
      out.write("                                                labelString: 'Month'\r\n");
      out.write("                                            }\r\n");
      out.write("                                        }],\r\n");
      out.write("                                    yAxes: [{\r\n");
      out.write("                                            display: true,\r\n");
      out.write("                                            scaleLabel: {\r\n");
      out.write("                                                display: true,\r\n");
      out.write("                                                labelString: 'Value'\r\n");
      out.write("                                            }\r\n");
      out.write("                                        }]\r\n");
      out.write("                                }\r\n");
      out.write("                            }\r\n");
      out.write("                        };\r\n");
      out.write("                        window.onload = function () {\r\n");
      out.write("                            var ctx = document.getElementById('canvas').getContext('2d');\r\n");
      out.write("                            window.myLine = new Chart(ctx, config);\r\n");
      out.write("                            setInterval(addDT, 1000);\r\n");
      out.write("                            setInterval(checkST, 1000);\r\n");
      out.write("                        };\r\n");
      out.write("                        document.getElementById('randomizeData').addEventListener('click', function () {\r\n");
      out.write("                            config.data.datasets.forEach(function (dataset) {\r\n");
      out.write("                                dataset.data = dataset.data.map(function () {\r\n");
      out.write("                                    return randomScalingFactor();\r\n");
      out.write("                                });\r\n");
      out.write("                            });\r\n");
      out.write("                            window.myLine.update();\r\n");
      out.write("                        });\r\n");
      out.write("                        var colorNames = Object.keys(window.chartColors);\r\n");
      out.write("                        document.getElementById('addDataset').addEventListener('click', function () {\r\n");
      out.write("                            var colorName = colorNames[config.data.datasets.length % colorNames.length];\r\n");
      out.write("                            var newColor = window.chartColors[colorName];\r\n");
      out.write("                            var newDataset = {\r\n");
      out.write("                                label: 'Dataset ' + config.data.datasets.length,\r\n");
      out.write("                                backgroundColor: newColor,\r\n");
      out.write("                                borderColor: newColor,\r\n");
      out.write("                                data: [],\r\n");
      out.write("                                fill: false\r\n");
      out.write("                            };\r\n");
      out.write("                            for (var index = 0; index < config.data.labels.length; ++index) {\r\n");
      out.write("                                newDataset.data.push(randomScalingFactor());\r\n");
      out.write("                            }\r\n");
      out.write("\r\n");
      out.write("                            config.data.datasets.push(newDataset);\r\n");
      out.write("                            window.myLine.update();\r\n");
      out.write("                        });\r\n");
      out.write("                        document.getElementById('addData').addEventListener('click', function () {\r\n");
      out.write("                            if (config.data.datasets.length > 0) {\r\n");
      out.write("                                var month = MONTHS[config.data.labels.length % MONTHS.length];\r\n");
      out.write("                                config.data.labels.push(month);\r\n");
      out.write("                                config.data.datasets.forEach(function (dataset) {\r\n");
      out.write("                                    dataset.data.push(randomScalingFactor());\r\n");
      out.write("                                });\r\n");
      out.write("                                config.data.labels.shift(); // remove the label first\r\n");
      out.write("\r\n");
      out.write("                                config.data.datasets.forEach(function (dataset, datasetIndex) {\r\n");
      out.write("                                    dataset.data.shift();\r\n");
      out.write("                                });\r\n");
      out.write("                                window.myLine.update();\r\n");
      out.write("                            }\r\n");
      out.write("                        });\r\n");
      out.write("                        document.getElementById('removeDataset').addEventListener('click', function () {\r\n");
      out.write("                            config.data.datasets.splice(0, 1);\r\n");
      out.write("                            window.myLine.update();\r\n");
      out.write("                        });\r\n");
      out.write("                        document.getElementById('removeData').addEventListener('click', function () {\r\n");
      out.write("                            config.data.labels.splice(-1, 1); // remove the label first\r\n");
      out.write("\r\n");
      out.write("                            config.data.datasets.forEach(function (dataset) {\r\n");
      out.write("                                dataset.data.pop();\r\n");
      out.write("                            });\r\n");
      out.write("                            window.myLine.update();\r\n");
      out.write("                        });\r\n");
      out.write("                        function addDT() {\r\n");
      out.write("                            if (config.data.datasets.length > 0) {\r\n");
      out.write("                                var month = MONTHS[config.data.labels.length % MONTHS.length];\r\n");
      out.write("                                config.data.labels.push(month);\r\n");
      out.write("                                config.data.datasets.forEach(function (dataset) {\r\n");
      out.write("\r\n");
      out.write("                                    // var pri = 0.00;\r\n");
      out.write("\r\n");
      out.write("                                    var xhttp = new XMLHttpRequest();\r\n");
      out.write("                                    xhttp.onreadystatechange = function () {\r\n");
      out.write("                                        if (this.readyState == 4 && this.status == 200) {\r\n");
      out.write("                                            // pri = ;\r\n");
      out.write("                                            dataset.data.push(this.responseText);\r\n");
      out.write("                                            document.getElementById('compPRICE').value = this.responseText;\r\n");
      out.write("                                            document.getElementById('sharePR').innerHTML = this.responseText;\r\n");
      out.write("                                        }\r\n");
      out.write("                                    };\r\n");
      out.write("                                    // alert(document.getElementById('compIDH').value);\r\n");
      out.write("                                    xhttp.open(\"GET\", \"get_price?cid=\" + document.getElementById('compIDH').value, true);\r\n");
      out.write("                                    xhttp.send();\r\n");
      out.write("                                    // onlineUSER();\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                                    // dataset.data.push(pri);\r\n");
      out.write("                                });\r\n");
      out.write("                                config.data.labels.shift(); // remove the label first\r\n");
      out.write("\r\n");
      out.write("                                config.data.datasets.forEach(function (dataset, datasetIndex) {\r\n");
      out.write("                                    dataset.data.shift();\r\n");
      out.write("                                });\r\n");
      out.write("                                window.myLine.update();\r\n");
      out.write("                            }\r\n");
      out.write("                            updateStAmount();\r\n");
      out.write("                        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        /**  function onlineUSER() {\r\n");
      out.write("                         var xhttp1 = new XMLHttpRequest();\r\n");
      out.write("                         xhttp1.onreadystatechange = function () {\r\n");
      out.write("                         if (this.readyState == 4 && this.status == 200) {\r\n");
      out.write("                         \r\n");
      out.write("                         \r\n");
      out.write("                         \r\n");
      out.write("                         \r\n");
      out.write("                         \r\n");
      out.write("                         }\r\n");
      out.write("                         };\r\n");
      out.write("                         xhttp1.open(\"GET\", \"http://localhost:8084/PROJECT_STOCK_ADMIN/HelloWorldServlet\", true);\r\n");
      out.write("                         xhttp1.send();\r\n");
      out.write("                         \r\n");
      out.write("                         }*/\r\n");
      out.write("\r\n");
      out.write("                        function myFunction() {\r\n");
      out.write("\r\n");
      out.write("                            var nosh = prompt(\"Enter no of shares you wish to buy,\", \"\");\r\n");
      out.write("                            if (nosh != null) {\r\n");
      out.write("                                var bal = document.getElementById(\"accBL\").innerHTML;\r\n");
      out.write("                                var bl = nosh * document.getElementById(\"compPRICE\").value;\r\n");
      out.write("                                if (bl > bal) {\r\n");
      out.write("                                    alert(\"Enough Credits to buy\");\r\n");
      out.write("                                } else {\r\n");
      out.write("                                    var money = bal - bl;\r\n");
      out.write("                                    document.getElementById(\"accBL\").innerHTML = money;\r\n");
      out.write("                                    var xhttp2 = new XMLHttpRequest();\r\n");
      out.write("                                    xhttp2.onreadystatechange = function () {\r\n");
      out.write("                                        if (this.readyState == 4 && this.status == 200) {\r\n");
      out.write("                                            document.getElementById('stat').value = xhttp2.responseText;\r\n");
      out.write("                                        }\r\n");
      out.write("                                    };\r\n");
      out.write("                                    var uid = \"");
 out.write(s.getAttribute("us").toString()); 
      out.write("\";\r\n");
      out.write("                                    xhttp2.open(\"POST\", \"save_trans?uid=\" + uid + \"&cid=\" + document.getElementById('compIDH').value + \"&nost=\" + nosh + \"&sprice=\" + document.getElementById('compPRICE').value + \"&total=\" + bl + \"&bal=\" + money + \"&typ=buy\", true);\r\n");
      out.write("                                    xhttp2.send();\r\n");
      out.write("                                }\r\n");
      out.write("                            }\r\n");
      out.write("\r\n");
      out.write("                        }\r\n");
      out.write("\r\n");
      out.write("                        function myFunction1() {\r\n");
      out.write("\r\n");
      out.write("                            var nosh = prompt(\"Enter no of shares you wish to sell,\", \"\");\r\n");
      out.write("                            if (nosh != null) {\r\n");
      out.write("                                var bal = document.getElementById(\"accBL\").innerHTML;\r\n");
      out.write("                                var bl = nosh * document.getElementById(\"compPRICE\").value;\r\n");
      out.write("                                var money = parseInt(bal) + bl;\r\n");
      out.write("                                document.getElementById(\"accBL\").innerHTML = money;\r\n");
      out.write("                                var xhttp2 = new XMLHttpRequest();\r\n");
      out.write("                                xhttp2.onreadystatechange = function () {\r\n");
      out.write("                                    if (this.readyState == 4 && this.status == 200) {\r\n");
      out.write("                                        document.getElementById('stat').value = xhttp2.responseText;\r\n");
      out.write("                                    }\r\n");
      out.write("                                };\r\n");
      out.write("                                var uid = \"");
 out.write(s.getAttribute("us").toString()); 
      out.write("\";\r\n");
      out.write("                                xhttp2.open(\"POST\", \"save_trans?uid=\" + uid + \"&cid=\" + document.getElementById('compIDH').value + \"&nost=\" + nosh + \"&sprice=\" + document.getElementById('compPRICE').value + \"&total=\" + bl + \"&bal=\" + money + \"&typ=sell\", true);\r\n");
      out.write("                                xhttp2.send();\r\n");
      out.write("                            }\r\n");
      out.write("\r\n");
      out.write("                        }\r\n");
      out.write("\r\n");
      out.write("                        function addCR() {\r\n");
      out.write("                            var nosh = prompt(\"Enter Amount\", \"\");\r\n");
      out.write("                            if (nosh != null) {\r\n");
      out.write("                                var bal = document.getElementById(\"accBL\").innerHTML;\r\n");
      out.write("                                var money = parseInt(bal) + parseInt(nosh);\r\n");
      out.write("                                document.getElementById(\"accBL\").innerHTML = money;\r\n");
      out.write("                                var xhttp2 = new XMLHttpRequest();\r\n");
      out.write("                                xhttp2.onreadystatechange = function () {\r\n");
      out.write("                                    if (this.readyState == 4 && this.status == 200) {\r\n");
      out.write("\r\n");
      out.write("                                    }\r\n");
      out.write("                                };\r\n");
      out.write("                                var uid = \"");
 out.write(s.getAttribute("us").toString()); 
      out.write("\";\r\n");
      out.write("                                xhttp2.open(\"POST\", \"update_cr?uid=\" + uid + \"&amo=\" + money, true);\r\n");
      out.write("                                xhttp2.send();\r\n");
      out.write("                            }\r\n");
      out.write("\r\n");
      out.write("                        }\r\n");
      out.write("                        function updateStAmount() {\r\n");
      out.write("                            // alert(\"sssss\");\r\n");
      out.write("                            var xhttp2 = new XMLHttpRequest();\r\n");
      out.write("                            xhttp2.onreadystatechange = function () {\r\n");
      out.write("                                if (this.readyState == 4 && this.status == 200) {\r\n");
      out.write("                                    document.getElementById(\"stAmount\").innerHTML = xhttp2.responseText;\r\n");
      out.write("                                }\r\n");
      out.write("                            };\r\n");
      out.write("                            var uid = \"");
 out.write(s.getAttribute("us").toString());
      out.write("\";\r\n");
      out.write("                            xhttp2.open(\"POST\", \"view_stock?uid=\" + uid + \"&cid=\" + document.getElementById('compIDH').value, true);\r\n");
      out.write("                            xhttp2.send();\r\n");
      out.write("                        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        function checkST() {\r\n");
      out.write("                            window.location.href(\"/PROJECT_STOCK/get_balance?uid=");
      out.print(un);
      out.write("\");\r\n");
      out.write("                        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    <!-- CHART-->\r\n");
      out.write("                    <button onclick=\"onlineUSER();\">ONLINE</button>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"w3-col s2\">\r\n");
      out.write("\r\n");
      out.write("                <p style=\"font-size:14px; margin-right: 20px; font-family:Segoe, 'Segoe UI', 'DejaVu Sans', 'Trebuchet MS', Verdana, sans-serif;\" class=\"w3-right-align\">Balance</p>\r\n");
      out.write("                <h2 style=\"margin-top:-5px; font-weight:600;margin-right: 20px;\" id=\"accBL\" class=\"w3-right-align\">\r\n");
      out.write("\r\n");
      out.write("                    ");
                        try {
                            ResultSet rs = DB.search("SELECT acc_bal FROM users WHERE username='" + s.getAttribute("us").toString() + "'");
                            while (rs.next()) {
                                out.write(rs.getString(1));
                            }
                        } catch (Exception e) {
                        }

                    
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </h2>\r\n");
      out.write("\r\n");
      out.write("                <p style=\"margin-top: -10px; margin-right: 20px; font-size:10px; font-family:Segoe, 'Segoe UI', 'DejaVu Sans', 'Trebuchet MS', Verdana, sans-serif;\">Share Price</p>\r\n");
      out.write("                <p style=\"margin-top:-5px; font-weight:600; margin-bottom: 10px;margin-right: 20px;\" id=\"sharePR\" class=\"w3-right-align\">500.00</p>\r\n");
      out.write("\r\n");
      out.write("                <input type=\"button\" class=\"button_main\" value=\"ADD CREDITS\" onclick=\"addCR();\" style=\"background-color:#F44336; margin-left:5px; width:88%;\"/>\r\n");
      out.write("\r\n");
      out.write("                <hr style=\"width:92%; border-color:#CCC;\"/>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"w3-panel w3-margin-right\" style=\"background-color:#FFF3E0; border:#FB8C00 thin solid; border-radius:5px;\">\r\n");
      out.write("                    <h3>Suggestions</h3>\r\n");
      out.write("                    <p style=\"padding-bottom:12px; font-size:12px;\">Suggestions are under development. </p>\r\n");
      out.write("                </div> \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div class=\"w3-row w3-centered\">\r\n");
      out.write("                    <div class=\"w3-col s6 w3-left\">\r\n");
      out.write("                        <input type=\"button\" class=\"button_main\" onclick=\"myFunction()\" value=\"BUY\" style=\"background-color:#F44336; margin-left:5px;\"/>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"w3-col s6 w3-center\">\r\n");
      out.write("                        <input type=\"button\" class=\"button_main\" onclick=\"myFunction1()\" value=\"SELL\" style=\"background-color:#00C853; margin-right:25px;\"/>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"w3-row w3-centered\">\r\n");
      out.write("                    <p class=\"menu-label\" style=\"margin-top: 10px;\">\r\n");
      out.write("                        Online Users\r\n");
      out.write("                    </p>\r\n");
      out.write("                    <ul class=\"menu-list\">\r\n");
      out.write("                        ");
                            try {
                                ResultSet rs = DB.search("SELECT sid,username FROM users WHERE sid != '' ");
                                while (rs.next()) {
                        
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <li><a>");
      out.print(rs.getString(2));
      out.write("</a></li>\r\n");
      out.write("                                ");

                                        }

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                
      out.write("\r\n");
      out.write("                    </ul>\r\n");
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
