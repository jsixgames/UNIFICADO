<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<% if (session.getAttribute("verificalog") == (Object) false
            || session.getAttribute("verificalog") == (Object) null) {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head> 
        <title>BOX GAMES - A SUA LOJA DE GAMES</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta name="description" content="BOX GAMES | Loja de Games | Compre Consoles, Jogos e Equipamentos para sua diversão"/>        
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="js/jquery-1.9.1.js">                        
        </script>        
        <link rel="shortcut icon" type="image/x-icon" href="favicon.ico"/>   

    </head>
    <body>        
        <c:import url='headerLogado.jsp' />

        <div id="conteudo">                           
            <h1 id="titulocadastro">Painel de Controle - Encerrar Conta</h1>
            <div id="painelopcoes"> 
                <c:import url='opcoespainel.jsp' />           
                <div id="painelconteudo">
                    <div id="posformnewend">                                    
                        <h1 id="titulodadoscad">Tem certeza que deseja encerrar sua conta?</h1>                                                                                                             
                            <div id="posformnewend">                                                                                        
                                <b>                                                                    
                                    <div id="btn-encerrarconta">                                
                                        <div class="btn-encerrar">
                                            <a href="RemoveClienteServlet?excluir=sim">Sim, tenho</a>
                                        </div>
                                        <div class="btn-encerrar">
                                            <a href="RemoveClienteServlet?excluir=nao">Não, não Tenho</a>
                                        </div>                                        
                                    </div>
                                </b>
                            </div>                         
                    </div>
                </div>    
            </div>
        </div>

        <c:import url="footer.jsp" />
    </body>
</html>


