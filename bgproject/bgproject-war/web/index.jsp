<%@page import="br.com.modelos.MetodosGerais"%>
<%@page import="br.com.modelos.Produto"%>
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
            <c:import url='index_produtos.jsp'/>            

            <c:choose>         
                <c:when test="${jaexiste == 0}"> 
                    <script language="JavaScript" type="text/javascript">
                        alert("Este produto já está na sua lista de desejos");
                    </script>
                    <%session.removeAttribute("jaexiste");%>
                </c:when>             
                <c:when test="${jaexiste == 1}"> 
                    <script language="JavaScript" type="text/javascript">
                        alert("Produto adicionado com sucesso a sua lista de desejos");
                    </script>
                    <%session.removeAttribute("jaexiste");%>
                </c:when>             
                <c:when test="${sitcart == 0}"> 
                    <script language="JavaScript" type="text/javascript">
                        alert("Produto adicionado ao carrinho de compras com sucesso!");
                    </script>
                    <%session.removeAttribute("sitcart");%>
                </c:when>             
                <c:when test="${sitcart == 1}"> 
                    <script language="JavaScript" type="text/javascript">
                        alert("Este produto já está no carrinho de compras, caso queira mais uma unidade deste produto, entre no carrino e coloque a quantidade desejada e atualize o carrinho.");
                    </script>
                    <%session.removeAttribute("sitcart");%>
                </c:when>             
                <c:when test="${pedidorealizado == 1}"> 
                    <script language="JavaScript" type="text/javascript">
                        alert("PEDIDO REALIZADO COM SUCESSO, ACOMPANHE A SITUAÇÃO PELO SEU PAINEL");
                    </script>
                    <%session.removeAttribute("pedidorealizado");%>
                </c:when>             
            </c:choose>                  
        </div>

        <c:import url="footer.jsp" />
    </body>
</html>


