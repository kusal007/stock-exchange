<%-- 
    Document   : CreateUser
    Created on : Jun 26, 2018, 9:37:50 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User</title>
        
        <link href="css/w3.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="css/common.css">
    </head>
    <style>
        body{
            background:url(images/wallpaperCreate.jpg);
            background-repeat:no-repeat;
            background-size:cover;
        }
    </style>
    <body>
        <div class="w3-row">
            <div class="w3-col s6 w3-center"><p>s6</p></div>
            <div class="w3-col s6" style="padding-right:180px;">
                <div class="w3-panel w3-white" style="margin-top:80px;padding-left:60px; padding-right:60px; padding-bottom:80px; opacity:0.95; border-radius:10px;">
                    <h3  style="margin-top:100px;">Sign up</h3>

                    <form action="InsertData" method="POST">
                        <h5>Name</h5>
                        <input type="text" name="name" class="w3-input w3-border"/>
                        <h5>Username</h5>
                        <input type="text" name="username" class="w3-input w3-border"/>
                        <h5>Password</h5>
                        
                        <input type="password" name="password" class="w3-input w3-border"/>
                        <br/>
                        <input type="submit" value="Sign up" class="w3-button w3-orange" /> 
                        
                        
                    </form>
                    

                </div>
            </div>
        </div>
    </body>
</html>
