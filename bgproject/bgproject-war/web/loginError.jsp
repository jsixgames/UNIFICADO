<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head> 
        <title>BOX GAMES - A SUA LOJA DE GAMES</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta name="description" content="BOX GAMES | Loja de Games | Compre Consoles, Jogos e Equipamentos para sua diversão"/>
        <link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.9.1/build/cssreset/cssreset-min.css"/>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" type="image/x-icon" href="favicon.ico"/>   

    </head>
    <body>
        <c:import url="header.jsp" />
        <div id="conteudo">  
            
            <h1 id="titulocadastro">Erro ao tentar logar, por favor tente novamente!</h1>            
            
            <div id="divlogin" style="margin-top: 50px;">         
                <form id="login" action="LoginServlet" method="post">                       

                    <span class='login-em'>Informe seu e-mail:</span><br>                     
                    <span class='login-em-input'><input type="email" name="email" autofocus required/></span><br/>


                    <span class='login-sn'>Informe sua senha:</span><br>
                    <span class='login-sn-input'><input type="password" name="senha" required/></span><br/>
                    <span style="font-family: Trebuchet MS;color: red;font-weight: bold">Email e/ou Senha Incorretos...Tente Novamente</span>
                    <div>                                
                        <input class="btn-logar" name="btn_login" type="submit" value="Logar"/>                        
                    </div>
                </form>
                
            </div>
        </div>        
        <c:import url="footer.jsp" />
    </body>
</html>


