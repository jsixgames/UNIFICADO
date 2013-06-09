<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<% if(session.getAttribute("verificalog") == (Object) false 
        || session.getAttribute("verificalog") == (Object) null){
    request.getRequestDispatcher("login.jsp").forward(request, response);    
}

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head> 
        <title>BOX GAMES - A SUA LOJA DE GAMES</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta name="description" content="BOX GAMES | Loja de Games | Compre Consoles, Jogos e Equipamentos para sua diversão"/>
        <link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.9.1/build/cssreset/cssreset-min.css"/>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="js/jquery-1.9.1.js">                        
        </script>        
        <link rel="shortcut icon" type="image/x-icon" href="favicon.ico"/>   
        
    </head>
    <body>        
        <c:import url='headerLogado.jsp' />
        
        <div id="conteudo">                           
            <h1 id="titulocadastro">Painel de Controle</h1>            
            <div id="painelopcoes"> 
                <c:import url='opcoespainel.jsp' />
                <div id="painelconteudo">
          
                    <c:choose>         
                        <c:when test="${respnewend == true}"> 
                            <h1 id="titulodadoscad">Cadastro de endereço realizado com sucesso!</h1>
                            <% session.removeAttribute("respnewend");%>
                        </c:when> 
                        <c:when test="${respnewend == false}">
                            <h1 id="titulodadoscad">Cadastro de endereço não realizado!</h1>
                           <% session.removeAttribute("respnewend");%>
                        </c:when>
                        <c:when test="${alterado == true}">
                            <h1 id="titulodadoscad">Alteração de cadastro realizado com sucesso!</h1>
                            <% session.removeAttribute("alterado");%>
                        </c:when>
                        <c:when test="${alterado == false}">
                            <h1 id="titulodadoscad">A Alteração de cadastro não pode ser realizada!</h1>
                            <% session.removeAttribute("alterado");%>
                        </c:when>
                        <c:otherwise> 
                            <h1 id="titulodadoscad">Selecione ao lado o que deseja</h1>
                        </c:otherwise> 
                    </c:choose> 
 
                </div>
            </div>
        </div>
        <c:import url="footer.jsp" />
    </body>
</html>


