<%@page import="java.sql.ResultSet"%>
<%@page import="src.DB"%>
<%
    HttpSession s = request.getSession();
    String un = null;
    if (s.getAttribute("us") != null) {
        un = s.getAttribute("us").toString();

    }
    if (un == null) {
        response.sendRedirect("/PROJECT_STOCK/index.jsp");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Hello Bulma!</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
        <link rel="stylesheet" href="css/w3.css">
        <script defer src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
        <!--FOR CHART-->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
        <link rel="stylesheet" href="css/common.css">
        <script src="http://www.chartjs.org/dist/2.7.2/Chart.bundle.js"></script>
        <script src="http://www.chartjs.org/samples/latest/utils.js"></script>
        <!-- FOR CHART -->

    </head>
    <body> 

        <!--MENU--> 

        <script>

            function logoutfun() {

                window.location.replace("/PROJECT_STOCK/logout?uid=<%=un%>");
            }

        </script>

        <div class="w3-bar w3-orange">
            <a href="#" class="w3-bar-item w3-button w3-padding-large w3-hover-blue">Home</a>
            <a href="#" class="w3-bar-item w3-button w3-padding-large w3-hover-blue">Link 1</a>
            <a href="#" class="w3-bar-item w3-button w3-padding-large w3-hover-blue">Link 2</a>
            <p id="compNM" class="w3-bar-item w3-padding-large" style="font-weight: 700;">Select a Company</p><input type="hidden" id="compID"/>
            <p class="w3-bar-item w3-button w3-padding-large w3-hover-blue" onclick="logoutfun();">LOGOUT</p>
        </div>
        <br/>
        <div class="w3-row">
            <div class="w3-col s2 w3-padding-large">
                <aside class="menu">

                    <p class="menu-label">
                        Listed Companies
                    </p>
                    <ul class="menu-list">

                        <input type="hidden" value="" id="compIDH"/>
                        <input type="hidden" value="" id="compPRICE"/>
                        <input type="hidden" value="" id="ussi"/>
                        <input type="hidden" value="" id="stat"/>
                        <%
                            try {

                                ResultSet rs = DB.search("SELECT * FROM comp_tr");
                                while (rs.next()) {
                        %>

                        <li><a onclick="setCompany('<%=rs.getString(2)%>', '<%=rs.getString(1)%>');"> <%=rs.getString(2)%></a></li>
                            <%
                                    }

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            %>

                    </ul>

                </aside>
                <div>
                    <br/>
                    <p class="menu-label">RECENT TRANSACTIONS</p>

                    <ul>
                        <%
                            try {

                                ResultSet rs1 = DB.search("SELECT * FROM trans WHERE uid='" + s.getAttribute("us").toString() + "'");
                                while (rs1.next()) {
                        %>

                        <li><a style="font-size: 12px;">Rs. <% out.write(rs1.getString(5)); %></a><span style="font-size: 12px; color: red"> - <% out.write(rs1.getString(7)); %></span></li>
                            <%
                                    }

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            %>


                    </ul>

                </div>
            </div>

            <!--MENU-->
            <div class="w3-col s8 w3-centered">
                <!--   <button id="randomizeData">Randomize Data</button>
                   <button id="addDataset">Add Dataset</button>
                   <button id="removeDataset">Remove Dataset</button>
                   <button id="addData">Add Data</button>
                   <button id="removeData">Remove Data</button>
                <!-- CHART-->
                <p id="stAmount">You have 20 stocks worth $<p>

                    <canvas id="canvas" width="100%" height="60" onload="setTimeout(addDT(); , 5000)"></canvas>
                    <script>


                        function setCompany(cmp, compid) {
                            document.getElementById('compNM').innerHTML = cmp;
                            document.getElementById('compIDH').value = compid;
                            config.data.datasets.splice(0, 1);
                            window.myLine.update();
                            //add a new line
                            var colorNames = Object.keys(window.chartColors);
                            var colorName = colorNames[config.data.datasets.length % colorNames.length];
                            var newColor = window.chartColors[colorName];
                            var newDataset = {
                                label: 'Dataset ' + config.data.datasets.length,
                                backgroundColor: newColor,
                                borderColor: newColor,
                                data: [],
                                fill: false
                            };
                            for (var index = 0; index < config.data.labels.length; ++index) {
                                newDataset.data.push(0);
                            }

                            config.data.datasets.push(newDataset);
                            window.myLine.update();
                            //add a new line

                        }

                        var MONTHS = ['1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'];
                        var config = {
                            type: 'line',
                            data: {
                                labels: ['1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'],
                                datasets: [{
                                        label: 'My First dataset',
                                        backgroundColor: window.chartColors.red, ////
                                        borderColor: window.chartColors.red,
                                        data: [
                                            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
                                        ],
                                        fill: false,
                                    }, ]
                            },
                            options: {
                                responsive: true,
                                title: {
                                    display: false,
                                    text: 'Chart.js Line Chart'
                                },
                                tooltips: {
                                    mode: 'index',
                                    intersect: false,
                                },
                                hover: {
                                    mode: 'nearest',
                                    intersect: true
                                },
                                scales: {
                                    xAxes: [{
                                            display: true,
                                            scaleLabel: {
                                                display: true,
                                                labelString: 'Month'
                                            }
                                        }],
                                    yAxes: [{
                                            display: true,
                                            scaleLabel: {
                                                display: true,
                                                labelString: 'Value'
                                            }
                                        }]
                                }
                            }
                        };
                        window.onload = function () {
                            var ctx = document.getElementById('canvas').getContext('2d');
                            window.myLine = new Chart(ctx, config);
                            setInterval(addDT, 1000);
                            setInterval(checkST, 1000);
                        };
                        document.getElementById('randomizeData').addEventListener('click', function () {
                            config.data.datasets.forEach(function (dataset) {
                                dataset.data = dataset.data.map(function () {
                                    return randomScalingFactor();
                                });
                            });
                            window.myLine.update();
                        });
                        var colorNames = Object.keys(window.chartColors);
                        document.getElementById('addDataset').addEventListener('click', function () {
                            var colorName = colorNames[config.data.datasets.length % colorNames.length];
                            var newColor = window.chartColors[colorName];
                            var newDataset = {
                                label: 'Dataset ' + config.data.datasets.length,
                                backgroundColor: newColor,
                                borderColor: newColor,
                                data: [],
                                fill: false
                            };
                            for (var index = 0; index < config.data.labels.length; ++index) {
                                newDataset.data.push(randomScalingFactor());
                            }

                            config.data.datasets.push(newDataset);
                            window.myLine.update();
                        });
                        document.getElementById('addData').addEventListener('click', function () {
                            if (config.data.datasets.length > 0) {
                                var month = MONTHS[config.data.labels.length % MONTHS.length];
                                config.data.labels.push(month);
                                config.data.datasets.forEach(function (dataset) {
                                    dataset.data.push(randomScalingFactor());
                                });
                                config.data.labels.shift(); // remove the label first

                                config.data.datasets.forEach(function (dataset, datasetIndex) {
                                    dataset.data.shift();
                                });
                                window.myLine.update();
                            }
                        });
                        document.getElementById('removeDataset').addEventListener('click', function () {
                            config.data.datasets.splice(0, 1);
                            window.myLine.update();
                        });
                        document.getElementById('removeData').addEventListener('click', function () {
                            config.data.labels.splice(-1, 1); // remove the label first

                            config.data.datasets.forEach(function (dataset) {
                                dataset.data.pop();
                            });
                            window.myLine.update();
                        });
                        function addDT() {
                            if (config.data.datasets.length > 0) {
                                var month = MONTHS[config.data.labels.length % MONTHS.length];
                                config.data.labels.push(month);
                                config.data.datasets.forEach(function (dataset) {

                                    // var pri = 0.00;

                                    var xhttp = new XMLHttpRequest();
                                    xhttp.onreadystatechange = function () {
                                        if (this.readyState == 4 && this.status == 200) {
                                            // pri = ;
                                            dataset.data.push(this.responseText);
                                            document.getElementById('compPRICE').value = this.responseText;
                                            document.getElementById('sharePR').innerHTML = this.responseText;
                                        }
                                    };
                                    // alert(document.getElementById('compIDH').value);
                                    xhttp.open("GET", "get_price?cid=" + document.getElementById('compIDH').value, true);
                                    xhttp.send();
                                    // onlineUSER();


                                    // dataset.data.push(pri);
                                });
                                config.data.labels.shift(); // remove the label first

                                config.data.datasets.forEach(function (dataset, datasetIndex) {
                                    dataset.data.shift();
                                });
                                window.myLine.update();
                            }
                            updateStAmount();
                        }


                        /**  function onlineUSER() {
                         var xhttp1 = new XMLHttpRequest();
                         xhttp1.onreadystatechange = function () {
                         if (this.readyState == 4 && this.status == 200) {
                         
                         
                         
                         
                         
                         }
                         };
                         xhttp1.open("GET", "http://localhost:8084/PROJECT_STOCK_ADMIN/HelloWorldServlet", true);
                         xhttp1.send();
                         
                         }*/

                        function myFunction() {

                            var nosh = prompt("Enter no of shares you wish to buy,", "");
                            if (nosh != null) {
                                var bal = document.getElementById("accBL").innerHTML;
                                var bl = nosh * document.getElementById("compPRICE").value;
                                if (bl > bal) {
                                    alert("Enough Credits to buy");
                                } else {
                                    var money = bal - bl;
                                    document.getElementById("accBL").innerHTML = money;
                                    var xhttp2 = new XMLHttpRequest();
                                    xhttp2.onreadystatechange = function () {
                                        if (this.readyState == 4 && this.status == 200) {
                                            document.getElementById('stat').value = xhttp2.responseText;
                                        }
                                    };
                                    var uid = "<% out.write(s.getAttribute("us").toString()); %>";
                                    xhttp2.open("POST", "save_trans?uid=" + uid + "&cid=" + document.getElementById('compIDH').value + "&nost=" + nosh + "&sprice=" + document.getElementById('compPRICE').value + "&total=" + bl + "&bal=" + money + "&typ=buy", true);
                                    xhttp2.send();
                                }
                            }

                        }

                        function myFunction1() {

                            var nosh = prompt("Enter no of shares you wish to sell,", "");
                            if (nosh != null) {
                                var bal = document.getElementById("accBL").innerHTML;
                                var bl = nosh * document.getElementById("compPRICE").value;
                                var money = parseInt(bal) + bl;
                                document.getElementById("accBL").innerHTML = money;
                                var xhttp2 = new XMLHttpRequest();
                                xhttp2.onreadystatechange = function () {
                                    if (this.readyState == 4 && this.status == 200) {
                                        document.getElementById('stat').value = xhttp2.responseText;
                                    }
                                };
                                var uid = "<% out.write(s.getAttribute("us").toString()); %>";
                                xhttp2.open("POST", "save_trans?uid=" + uid + "&cid=" + document.getElementById('compIDH').value + "&nost=" + nosh + "&sprice=" + document.getElementById('compPRICE').value + "&total=" + bl + "&bal=" + money + "&typ=sell", true);
                                xhttp2.send();
                            }

                        }

                        function addCR() {
                            var nosh = prompt("Enter Amount", "");
                            if (nosh != null) {
                                var bal = document.getElementById("accBL").innerHTML;
                                var money = parseInt(bal) + parseInt(nosh);
                                document.getElementById("accBL").innerHTML = money;
                                var xhttp2 = new XMLHttpRequest();
                                xhttp2.onreadystatechange = function () {
                                    if (this.readyState == 4 && this.status == 200) {

                                    }
                                };
                                var uid = "<% out.write(s.getAttribute("us").toString()); %>";
                                xhttp2.open("POST", "update_cr?uid=" + uid + "&amo=" + money, true);
                                xhttp2.send();
                            }

                        }
                        function updateStAmount() {
                            // alert("sssss");
                            var xhttp2 = new XMLHttpRequest();
                            xhttp2.onreadystatechange = function () {
                                if (this.readyState == 4 && this.status == 200) {
                                    document.getElementById("stAmount").innerHTML = xhttp2.responseText;
                                }
                            };
                            var uid = "<% out.write(s.getAttribute("us").toString());%>";
                            xhttp2.open("POST", "view_stock?uid=" + uid + "&cid=" + document.getElementById('compIDH').value, true);
                            xhttp2.send();
                        }


                        function checkST() {
                            var xhttp2 = new XMLHttpRequest();
                            xhttp2.onreadystatechange = function () {
                                if (this.readyState == 4 && this.status == 200) {
                                    document.getElementById("stAmount").innerHTML = xhttp2.responseText;
                                    if (xhttp2.responseText !== "") {
                                        alert(xhttp2.responseText);
                                        window.location.replace("/PROJECT_STOCK/logout");
                                    }
                                }
                            };
                            var uid = "<% out.write(s.getAttribute("us").toString());%>";
                            xhttp2.open("POST", "get_balance?uid=" + uid, true);
                            xhttp2.send();
                        }



                    </script>


                    <!-- CHART-->
                    <button onclick="onlineUSER();">ONLINE</button>
            </div>

            <div class="w3-col s2">

                <p style="font-size:14px; margin-right: 20px; font-family:Segoe, 'Segoe UI', 'DejaVu Sans', 'Trebuchet MS', Verdana, sans-serif;" class="w3-right-align">Balance</p>
                <h2 style="margin-top:-5px; font-weight:600;margin-right: 20px;" id="accBL" class="w3-right-align">

                    <%                        try {
                            ResultSet rs = DB.search("SELECT acc_bal FROM users WHERE username='" + s.getAttribute("us").toString() + "'");
                            while (rs.next()) {
                                out.write(rs.getString(1));
                            }
                        } catch (Exception e) {
                        }

                    %>

                </h2>

                <p style="margin-top: -10px; margin-right: 20px; font-size:10px; font-family:Segoe, 'Segoe UI', 'DejaVu Sans', 'Trebuchet MS', Verdana, sans-serif;">Share Price</p>
                <p style="margin-top:-5px; font-weight:600; margin-bottom: 10px;margin-right: 20px;" id="sharePR" class="w3-right-align">500.00</p>

                <input type="button" class="button_main" value="ADD CREDITS" onclick="addCR();" style="background-color:#F44336; margin-left:5px; width:88%;"/>

                <hr style="width:92%; border-color:#CCC;"/>

                <div class="w3-panel w3-margin-right" style="background-color:#FFF3E0; border:#FB8C00 thin solid; border-radius:5px;">
                    <h3>Suggestions</h3>
                    <p style="padding-bottom:12px; font-size:12px;">Suggestions are under development. </p>
                </div> 


                <div class="w3-row w3-centered">
                    <div class="w3-col s6 w3-left">
                        <input type="button" class="button_main" onclick="myFunction()" value="BUY" style="background-color:#F44336; margin-left:5px;"/>
                    </div>

                    <div class="w3-col s6 w3-center">
                        <input type="button" class="button_main" onclick="myFunction1()" value="SELL" style="background-color:#00C853; margin-right:25px;"/>
                    </div>
                </div>
                <div class="w3-row w3-centered">
                    <p class="menu-label" style="margin-top: 10px;">
                        Online Users
                    </p>
                    <ul class="menu-list">
                        <%                            try {
                                ResultSet rs = DB.search("SELECT sid,username FROM users WHERE sid != '' ");
                                while (rs.next()) {
                        %>

                        <li><a><%=rs.getString(2)%></a></li>
                                <%
                                        }

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                %>
                    </ul>
                </div>

            </div> 

        </div> 
    </body>
</html>