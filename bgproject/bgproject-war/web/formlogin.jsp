<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="divlogin" style="margin-top: 50px;">         
            <form id="login" action="LoginServlet" method="post">                       
                <span class='login-em'>Informe seu e-mail:</span><br>                     
                <span class='login-em-input'><input type="email" name="email" autofocus required/></span><br/>


                <span class='login-sn'>Informe sua senha:</span><br>
                <span class='login-sn-input'><input type="password" name="senha" required/></span><br/>
                <div>                                
                    <input class="btn-logar" name="btn_login" type="submit" value="Logar"/>                        
                </div>



            </form>


        </div>
    </body>
</html>
