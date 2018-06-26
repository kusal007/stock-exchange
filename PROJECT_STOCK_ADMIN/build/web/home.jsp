
<%@page import="java.util.Date"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Array"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="src.DB"%>
<%
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
                        //  rs.beforeFirst();
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

                             System.out.println(rs.getString(1) + " : " + rs.getString(2) + " + " + flux + " : " + sellprice + " : " + timecode);
                             String query = "INSERT INTO stock.comp_stock(`comp_id`,`stock_price`,`time`,`status`)VALUES('" + rs.getString(1) + "','" + dec.format(sellprice) + "','" + timecode + "','')";
                             DB.Execute("UPDATE comp_tr SET stock_price='" + dec.format(sellprice) + "' WHERE comp_id='" + rs.getString(1) + "'");
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
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Hello Bulma!</title>

        
        <link href="css/w3.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="css/common.css">

    </head>
    
    <style>
        body{
            background:url(images/The-Stock-Market.jpg);
            background-repeat:no-repeat;
            background-size:cover;
        }
    </style>
    <body > 
        
        <script>
            function createGroups() {
                var xhttp2 = new XMLHttpRequest();
                xhttp2.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        //  document.getElementById("stAmount").innerHTML = xhttp2.responseText;
                    }
                };
                xhttp2.open("POST", "create_groups", true);
                xhttp2.send();
            }
        </script>

        <div class="w3-row">
            <div class="w3-col s6 w3-center"><p>s6</p></div>
            <div class="w3-col s6" style="padding-right:180px;">
                <div class="w3-panel w3-white" style="margin-top:50px;padding-left:60px; padding-right:60px; padding-bottom:50px; opacity:0.95; border-radius:10px;">
                    <h3  style="margin-top:25px;">Company Create</h3>

                    <form action="InsertCompany" method="POST">
                        <h5>Company ID</h5>
                        <input type="text" name="comp_id" class="w3-input w3-border"/>
                        <h5>Company Name</h5>
                        <input type="text" name="comp_name" class="w3-input w3-border"/>
                        <h5>Stock Price</h5>
                        
                        <input type="text" name="stock_price" class="w3-input w3-border"/>
                        <h5>Stock Qty</h5>
                        <input type="text" name="stocks" class="w3-input w3-border"/>
                        <h5>Sell Price</h5>
                        <input type="text" name="sell_price" class="w3-input w3-border"/>
                        <br/>
                        <input type="submit" value="Save" class="w3-button w3-orange" /> <a/><button class="w3-button w3-orange" onclick="createGroups()">GROUP CREATE</button>
                        
                        
                    </form>
                    
                    

                </div>
            </div>
        </div>
    </body>
</html>