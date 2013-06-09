<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="br.com.modelos.MetodosGerais"%>
<%@page import="br.com.modelos.Pedido"%>
<%@page import="java.util.List"%>
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
        <link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.9.1/build/cssreset/cssreset-min.css"/>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="js/jquery-1.9.1.js">
        </script>        
        <link rel="shortcut icon" type="image/x-icon" href="favicon.ico"/>   

    </head>
    <body>        
        <c:import url='headerLogado.jsp' />

        <div id="conteudo">                           
            <h1 id="titulocadastro">Painel de Controle - Meus Pedidos</h1>
            <div id="painelopcoes"> 
                <c:import url='opcoespainel.jsp' />                        
                <div id="painelconteudo" style="overflow: auto">
                    <h1 id="titulodadoscad">Lista de Pedidos Realizados</h1>
                    <table style="margin: 0 auto;margin-top: 10px;position: relative">
                        <tr style="background-color: #dddddd">                                                
                            <td id="titulocolunalistapedido">STATUS</td>
                            <td id="titulocolunalistapedido">REALIZADO EM</td>
                            <td id="titulocolunalistapedido">ID</td>
                            <td id="titulocolunalistapedido">FORMA DE PAGAMENTO</td>
                            <td id="titulocolunalistapedido">PRAZO DE ENTREGA</td>                    
                            <td id="titulocolunalistapedido">VALOR</td>                    
                        </tr>                                                            
                        <%
                            List<Pedido> list = (List<Pedido>) session.getAttribute("listapedidos");
                            for (int i = 0; i < list.size(); i++) {
                                Pedido p = list.get(i);
                                String preco = new MetodosGerais().doubleTostring(p.getTotal_pedido());
                                String data =
                                        DateFormat.getDateInstance().format(p.getData_pedido());
                                out.println("<tr>"
                                        + "<td id='linhatabelalistapedido2'>" + p.getStatus_pedido() + "</td>"
                                        + "<td id='linhatabelalistapedido2'>" + data + "</td>"
                                        + "<td id='linhatabelalistapedido2'>#" + p.getId() + "</td>"
                                        + "<td id='linhatabelalistapedido2'>" + p.getForma_pagamento() + "</td>"
                                        + "<td id='linhatabelalistapedido2'>" + p.getPrazo_entrega() + " dias" + "</td>"
                                        + "<td id='linhatabelalistapedido2'>" + preco + "</td>"
                                        + "</tr>");
                            }
                        %>                                                            
                    </table>                                                     
                </div>        
            </div>    
        </div>

        <c:import url="footer.jsp" />
    </body>
</html>