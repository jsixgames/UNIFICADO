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
        <c:choose>         
            <c:when test="${verificalog == true}"> 
                <c:import url='headerLogado.jsp'/>
            </c:when> 
            <c:otherwise> 
                <c:import url='header.jsp'/>
            </c:otherwise> 
        </c:choose> 
        <div id="conteudo">                           

            <h1 id="titulocadastro">Endereços - Matriz e Filial</h1>
            <div style="width: 500px;float: left;margin: 0 auto;margin-top: 50px">
                 <h1 id="titulodadoscad">Matriz</h1>
                 <p style="margin-left: 50px;font:13px museo-sans-1,sans-serif;color: blue">
                     Rua da Consolação 890, São Paulo-SP<br style="padding-top: 2px">
                     01302-000
                 </p><br>
                 <img style="margin-left: 50px;width: 400px;height: 340px" src="images/matriz.png" alt=""/>
            </div>
            <div style="width: 500px;float: right;margin: 0 auto; margin-top: 50px">
                 <h1 id="titulodadoscad">Filial</h1>
                 <p style="margin-left: 50px;font:13px museo-sans-1,sans-serif;color: blue">
                     Avenida Paulista 149, São Paulo-SP<br style="padding-top: 2px">
                     01311-000
                 </p><br>
                 <img style="margin-left: 50px;width: 400px;height: 340px" src="images/filial.png" alt=""/>
            </div>
            
        </div>

        <c:import url="footer.jsp" />
    </body>
</html>


