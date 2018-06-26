<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Untitled Document</title>

        <link href="css/w3.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="css/common.css">
    </head>

    <style>
        body{
            background:url(images/back_index_ed.jpg);
            background-repeat:no-repeat;
        }
    </style>

    <body>



        <div class="w3-row">
            <div class="w3-col s6 w3-center"><p>s6</p></div>
            <div class="w3-col s6" style="padding-right:180px;">
                <div class="w3-panel w3-white" style="margin-top:100px;padding-left:60px; padding-right:60px; padding-bottom:100px; opacity:0.95; border-radius:10px;">
                    <h3  style="margin-top:100px;">Sign in</h3>

                    <form action="loginc" method="POST">
                        <input type="text" name="username" class="w3-input w3-border"/>
                        <br/>
                        <input type="password" name="password" class="w3-input w3-border"/>
                        <br/>
                        <input type="submit" value="Login" class="w3-button w3-orange" />
                    </form>
                    
                    <form action="CreateUser" method="POST">
                        
                        <br/>
                          <input type="submit" value="Sign up" class="w3-button w3-orange" />
                        
                    </form>

                </div>
            </div>
        </div>

    </body>
</html>
