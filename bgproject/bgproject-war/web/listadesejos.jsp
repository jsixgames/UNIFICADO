<%@page import="br.com.modelos.MetodosGerais"%>
<%@page import="br.com.modelos.Produto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<% if(session.getAttribute("verificalog") == (Object) false 
        || session.getAttribute("verificalog") == (Object) null){
    request.getRequestDispatcher("login.jsp").forward(request, response);    
}%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head> 
        <title>BOX GAMES - A SUA LOJA DE GAMES</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta name="description" content="BOX GAMES | Loja de Games | Compre Consoles, Jogos e Equipamentos para sua diversão"/>   
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" type="image/x-icon" href="favicon.ico"/>   
        
    </head>
    <body>        
        <c:import url='headerLogado.jsp' />
        
        <div id="conteudo">                                            
            <h1 id="titulocadastro">Lista de Desejos</h1>
            <div id="tabelalista">                                        
            <table id="tablistadesejos">
                <tbody>
                    <tr style="background-color: #dddddd">                    
                    <td id="titulocolunalistapedido">IMAGEM</td>
                    <td id="titulocolunalistapedido">NOME</td>
                    <td id="titulocolunalistapedido">CATEGORIA</td>                   
                    <td id="titulocolunalistapedido">PREÇO</td>                    
                </tr>
                 <% 
               List<Produto> list = (List<Produto>) session.getAttribute("listadesejo");
               if(list == null){
                   out.println("<tr><p style='color:red'>Sua Lista de Desejos está Vazia!</p></tr>");
               }
               for(int i = 0; i < list.size();i++){
                   Produto p = list.get(i);                   
                   String preco = new MetodosGerais().doubleTostring(p.getPreco());  
                   Long idp = p.getId_prod();
                   out.println("<tr>" +
                    "<td id='linhatabelalistapedido'>"+"<a href='"+idp+".jsp'>"
                           + "<img src='images/"+idp+".jpg'"
                           + " style='width:80px;height:90px;vertical-align: middle;'>"+ "</a></td>" +
                    "<td id='linhatabelalistapedido'><a href='"+idp+".jsp' style='text-transform: capitalize'>" 
                           + p.getNome().toLowerCase() + "</a></td>" +
                    "<td id='linhatabelalistapedido'>" + p.getDepto() + "</td>" +                 
                    "<td id='linhatabelalistapedido'>" + preco + "</td>" +                  
                    "<td id='linhatabelalistapedido' style='border:0'>" + "<a href='ListaDesejosServlet?remover=true&prod-remove="
                           +p.getId_prod()+"'"+"><img id='imgremovecart' src='images/remove_list.png'></a>" +       
                     "<a href='CarrinhoServlet?btn-comprar=comprar1&prod-id="
                           +p.getId_prod()+"'"+"><img id='imgremovecart' src='images/addcart2.png'></a>" + "</td>" +       
                            "</tr>"                                                             
                           );
               }                         
                     %>                     
            </tbody>
            </table>   
            <table style="float: left;padding-left: 400px;margin: 0 auto;margin-top: 20px">
                    <tr>
                        <td>
                            <c:choose>                                         
                                <c:when test="${listadesejo == null}">                                    
                                    <img style="margin-left: -150px" src="images/listaempty.png">
                                </c:when>    
                                </c:choose>      
                        </td>
                    </tr>    
                </table>
        </div>
        </div>
        <c:import url="footer.jsp" />
    </body>
</html>


