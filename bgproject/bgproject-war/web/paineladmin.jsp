<%@page import="br.com.modelos.Endereco"%>
<%@page import="br.com.modelos.Cliente"%>
<%@page import="java.util.ArrayList"%>
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
        <div id="conteudo">                           
            <h1 id="titulocadastro">Painel de Administração</h1>
            <div id="painelopcoes"> 
                <c:import url='opcoespaineladmin.jsp' />
                <div id="painelconteudo2" style="overflow: auto">
                    <c:choose>                        
                        
                        <c:when test="${listacliente != null}"> 
                            <h1 id="titulodadoscad">Clientes Cadastrados</h1>
                            <table id="tabelaclientes" style="margin: 0 auto">
                                <tr style="background-color: #dddddd">
                                    <td id="titulocolunalistapedido">CÓDIGO</td>
                                    <td id="titulocolunalistapedido">NOME</td>
                                    <td id="titulocolunalistapedido">CPF</td>
                                    <td id="titulocolunalistapedido">SEXO</td>
                                    <td id="titulocolunalistapedido">EMAIL</td>
                                    <td id="titulocolunalistapedido">SENHA</td>
                                </tr>
                                <%
                                    List<Cliente> listc = (List<Cliente>) session.getAttribute("listacliente");                                   
                                    for (int i = 0; i < listc.size(); i++) {
                                        Cliente p = listc.get(i);                                                                                
                                        out.println("<tr>"                                                
                                                + "<td id='linhatabelalistapedido2'>" + p.getId() + "</td>"
                                                + "<td id='linhatabelalistapedido2' style='text-transform: capitalize'>"
                                                + p.getNome().toLowerCase()+ "</td>"
                                                + "<td id='linhatabelalistapedido2'>" + p.getCpf() + "</td>"
                                                + "<td id='linhatabelalistapedido2' style='text-transform: capitalize'>"
                                                + p.getSexo().toLowerCase() + "</td>"
                                                + "<td id='linhatabelalistapedido2'>" + p.getEmail().toLowerCase() + "</td>"
                                                + "<td id='linhatabelalistapedido2'>" + p.getSenha() + "</td>"
                                                + "</tr>");
                                    }
                                %>    

                            </table>
                            <% session.removeAttribute("listacliente");%>
                        </c:when> 
                            
                            
                        <c:when test="${listaend != null}">
                            <h1 id="titulodadoscad">Endereços Cadastrados</h1>
                            <table id="tabelaclientes" style="margin: 0 auto;">                                        
                                <tr style="background-color: #dddddd">
                                    <td id="titulocolunalistapedido">CÓDIGO</td>                                    
                                    <td id="titulocolunalistapedido">DESCRIÇÃO</td>
                                    <td id="titulocolunalistapedido">CEP</td>
                                    <td id="titulocolunalistapedido">ENDERECO</td>                                    
                                    <td id="titulocolunalistapedido">CIDADE</td>                                    
                                </tr>                                
                                <%
                                    List<Endereco> listend = (List<Endereco>) session.getAttribute("listaend");
                                    for (int i = 0; i < listend.size(); i++) {
                                        Endereco p = listend.get(i);
                                        out.println("<tr>"
                                                + "<td id='linhatabelalistapedido2'>" + p.getId() + "</td>"
                                                + "<td id='linhatabelalistapedido2' style='text-transform: capitalize'>"
                                                + p.getDescricao().toLowerCase() + "</td>"
                                                + "<td id='linhatabelalistapedido2'>" + p.getCep() + "</td>"
                                                + "<td id='linhatabelalistapedido2' style='text-transform: capitalize'>"
                                                + p.getEndereco().toLowerCase() + "</td>"
                                                + "<td id='linhatabelalistapedido2'>" + p.getCidade().toLowerCase() + "</td>"                                                
                                                + "</tr>");
                                    }
                                %>    

                            </table>
                            <% session.removeAttribute("listaend");%>
                        </c:when>
                            
                            
                            <c:when test="${listapedidos2 != null}">
                            <h1 id="titulodadoscad">Lista de Pedidos</h1>
                            <table id="tabelaclientes" style="margin: 0 auto; width: 700px">                                        
                                <tr style="background-color: #dddddd">
                                    <td id="titulocolunalistapedido">STATUS</td>                                    
                                    <td id="titulocolunalistapedido">CÓDIGO</td>
                                    <td id="titulocolunalistapedido">FORMA DE PAGAMENTO</td>
                                    <td id="titulocolunalistapedido">VALOR</td>                                                                        
                                </tr>                                
                                <%
                                    List<Pedido> list = (List<Pedido>) session.getAttribute("listapedidos2");                                   
                                    String sts1,sts2 = "";       
                                    
                                    for (int i = 0; i < list.size(); i++) {
                                       Pedido p = list.get(i);
                                       if(p.getStatus_pedido().equals("AGUARDANDO PAGAMENTO")){
                                        sts1 = "AGUARDANDO PAGAMENTO";
                                        sts2 = "PAGAMENTO CONFIRMADO";
                                        }else{sts1 = "PAGAMENTO CONFIRMADO";
                                              sts2 = "AGUARDANDO PAGAMENTO"; }
                                        String preco = new MetodosGerais().doubleTostring(p.getTotal_pedido());
                                        out.println("<tr>"
                                                + "<td id='linhatabelalistapedido2'><form action='PedidosServlet'>"
                                                + "<input type='hidden' name='evento' value='atualizar'>"
                                                + "<input type='hidden' name='id-ped' value='"+i+"'>"
                                                +"<select name='status'>"
                                                +"<option value='"+sts1+"'>"+sts1+"</option>"
                                                +"<option value='"+sts2+"'>"+sts2+"</option>"
                                                +"</select>"
                                                + "</td>"                                                
                                                + "<td id='linhatabelalistapedido2'>#" + p.getId() + "</td>"                                                
                                                + "<td id='linhatabelalistapedido2'>" + p.getForma_pagamento()+ "</td>"
                                                + "<td id='linhatabelalistapedido2'>" + preco + "</td>"
                                                + "<td id='linhatabelalistapedido2' style='border:1px solid white'>"
                                                +"<input id='imgrefreshcart' type='submit' value='Atualizar'></form>"+"</td>"
                                                + "</tr>");
                                    }
                                %>    
                            </table>                            
                        </c:when>
                            
                            
                        <c:otherwise> 
                            <h1 id="titulodadoscad">Selecione ao lado o que deseja</h1>
                        </c:otherwise> 
                                                        
                    </c:choose>  
                </div>
            </div>
        </div>

    </body>
</html>


