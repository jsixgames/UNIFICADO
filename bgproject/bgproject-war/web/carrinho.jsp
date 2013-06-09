<%@page import="br.com.modelos.MetodosGerais"%>
<%@page import="br.com.modelos.Item_Pedido"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head> 
        <title> BOX GAMES - A SUA LOJA DE GAMES </title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta name="description" content="BOX GAMES | Loja de Games | Compre Consoles, Jogos e Equipamentos para sua diversão"/>
        <link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.9.1/build/cssreset/cssreset-min.css"/>
        <link href="style.css" rel="stylesheet" type="text/css"/>          

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

        <div id="conteudo2">                                            
            <h1 id="titulocadastro">Carrinho de Compras</h1>
            <div id="tabelalista2">                
            <table id="tablistadesejos2">
                <tbody>
                    <tr style="background-color: #dddddd">                    
                    <td id="titulocolunalistapedido">IMAGEM</td>
                    <td id="titulocolunalistapedido">NOME</td>
                    <td id="titulocolunalistapedido">CATEGORIA</td>
                    <td id="titulocolunalistapedido">QUANTIDADE</td>
                    <td id="titulocolunalistapedido">PREÇO</td>                    
                </tr>                                               
                 <% 
               List<Item_Pedido> list = (List<Item_Pedido>) session.getAttribute("listaitem");
               double vp = 0;
               String vps = null;
               for(int i = 0; i < list.size();i++){
                   Item_Pedido ip = list.get(i);                   
                   String preco = new MetodosGerais().doubleTostring(ip.getPreco_total());                   
                   Long idp = ip.getProduto().getId_prod();
                   out.println("<tr>" +
                    "<td id='linhatabelalistapedido'><a href='"+idp+".jsp'>" + 
                           "<img src='images/"+idp+".jpg'"
                           + "style='width:80px;height:90px;vertical-align: middle;'>" +"</a></td>" +
                    "<td id='linhatabelalistapedido'><a href='"+idp+".jsp' style='text-transform: capitalize'>" 
                           + ip.getProduto().getNome().toLowerCase() + "</a></td>" +
                    "<td id='linhatabelalistapedido'>" + ip.getProduto().getDepto() + "</td>" +                 
                    "<td id='linhatabelalistapedido'><form action='CarrinhoServlet'>"
                           +"<input type='hidden' name='evento' value='atualiza'>"
                           +"<input type='hidden' name='item-id' value='"+i+"'>"
                           + "<input type='number' value='" 
                           + ip.getQtd() +"' name='qtdenova' min='1' style='width:35px'>"+
                            "<input id='imgrefreshcart' type='submit' value='Atualizar'></form>"
                           +"</td>" +
                    "<td id='linhatabelalistapedido'>" + preco + "</td>" +                  
                    "<td id='linhatabelalistapedido' style='border:0'>" + "<a href='CarrinhoServlet?evento=remover&item-id="
                           +i+"'"+"><img id='imgremovecart' src='images/remove_cart.png'></a>" + "</td>" +                                
                            "</tr>"                                                             
                           );
                   double precototal = ip.getPreco_total();
                   vp = vp + precototal;
                   vps = new MetodosGerais().doubleTostring(vp);
                        } 
                        if(vps==null){vps="0";}
                        out.println("<tr><td colspan='5' id='titulocolunalistapedido'><p>Valor Total:  "
                                + "<b style='color:red;font-size: 16px'>"+vps+"</p></td></tr>");
                     %>
                <table style="float: left;padding-left: 400px;margin: 0 auto;margin-top: 20px">
                    <tr>
                        <td>
                            <c:choose>         
                                <c:when test="${verificalog == false || verificalog == null}"> 
                                    <h1 style="color: red;margin-left: -100px">*Você ainda não está logado, por favor faça o login para prosseguir com a compra</h1>
                                </c:when> 
                                <c:when test="${qtde == 0 || qtde == null}">                                    
                                    <img style="margin-left: -150px" src="images/cart_empty.png">
                                </c:when>    
                                <c:otherwise>                 
                                    <a href="FinalizarCompra?evento=ok"><div id="btn-carrinhocomprar"></div></a>
                                    </c:otherwise> 
                                </c:choose>      
                        </td>
                    </tr>    
                </table>
            </tbody>            
            </table>            
        </div>            
        </div>                    
        <c:import url="footer.jsp" />
    </body>
</html>