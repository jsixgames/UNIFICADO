<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<h1 id="titulocadastro">Produtos em destaque</h1>
            <div id="tabelahome">
                <table id="tabelaprodutos">
                    <tbody>
                        <tr>
                            <td class="proditem">
                                <a href="1.jsp"><img src="images/1.jpg" alt="SUPER_MARIO_GALAXY"/></a>
                                <p id="nomejogo">Jogo Wii Super Mario Galaxy 2</p>
                                <p id="valor-por">Por: <strong>R$ 149,90</strong></p>                                
                                <a id="btn-comprar" href="CarrinhoServlet?btn-comprar=comprar1&prod-id=1"></a>                                
                                <c:choose>         
                                <c:when test="${verificalog == true}">                                 
                                <a id="botaologout" href="ListaDesejosServlet?btn-desejo=add&prod-id=1">                                    
                                    <p>Adicionar a lista de desejos</p>
                                </a>
                                </c:when>                                 
                                </c:choose>
                            </td>
                            <td class="proditem">
                                <a href="2.jsp"><img src="images/2.jpg" alt="LEGO_PIRATAS_DO_CARIBE"/></a>
                                <p id="nomejogo">Jogo 3DS Lego Piratas do Caribe</p>
                                <p id="valor-por">Por: <strong>R$ 69,90</strong></p>
                                <a id="btn-comprar" href="CarrinhoServlet?btn-comprar=comprar1&prod-id=2"></a>
                                <c:choose>         
                                <c:when test="${verificalog == true}">                                 
                                <a id="botaologout" href="ListaDesejosServlet?btn-desejo=add&prod-id=2">
                                    <p>Adicionar a lista de desejos</p>
                                </a>
                                </c:when>                                 
                                </c:choose>
                            </td>
                            <td class="proditem">
                                <a href="3.jsp"><img src="images/3.jpg" alt="BIOSHOCK_INFINITE"/></a>
                                <p id="nomejogo">Jogo PS3 Bioshock Infinite</p>
                                <p id="valor-por">Por: <strong>R$ 199,90</strong></p>
                                <a id="btn-comprar" href="CarrinhoServlet?btn-comprar=comprar1&prod-id=3"></a>
                                <c:choose>         
                                <c:when test="${verificalog == true}">                                                                 
                                <a id="botaologout" href="ListaDesejosServlet?btn-desejo=add&prod-id=3">
                                    <p>Adicionar a lista de desejos</p>
                                </a>
                                </c:when>                                 
                                </c:choose>
                            </td>
                            <td class="proditem">
                                <a href="4.jsp"><img src="images/4.jpg" alt="PS3_160"/></a>
                                <p id="nomejogo">Console PlayStation 3 Slim 160gb </p>
                                <p id="valor-por">Por: <strong>R$ 1199,90</strong></p>
                                <a id="btn-comprar" href="CarrinhoServlet?btn-comprar=comprar1&prod-id=4"></a>
                                <c:choose>         
                                <c:when test="${verificalog == true}">                                 
                                <a id="botaologout" href="ListaDesejosServlet?btn-desejo=add&prod-id=4">
                                    <p>Adicionar a lista de desejos</p>
                                </a>
                                </c:when>                                 
                                </c:choose>
                            </td>
                        </tr> 
                        <tr>
                            <td class="proditem">
                                <a href="5.jsp"><img src="images/5.jpg" alt="DIRT_3"/></a>
                                <p id="nomejogo">Jogo PC/DVD para Windows Dirt 3</p>
                                <p id="valor-por">Por: <strong>R$ 69,90</strong></p>
                                <a id="btn-comprar" href="CarrinhoServlet?btn-comprar=comprar1&prod-id=5"></a>
                                <c:choose>         
                                <c:when test="${verificalog == true}">                                 
                                <a id="botaologout" href="ListaDesejosServlet?btn-desejo=add&prod-id=5">
                                    <p>Adicionar a lista de desejos</p>
                                </a>
                                </c:when>                                 
                                </c:choose>
                            </td>
                            <td class="proditem">
                                <a href="6.jsp"><img src="images/6.jpg" alt="PES_2013"/></a>
                                <p id="nomejogo">Jogo Xbox 360 Pro Evolution Soccer 2013</p>
                                <p id="valor-por">Por: <strong>R$ 99,90</strong></p>
                                <a id="btn-comprar" href="CarrinhoServlet?btn-comprar=comprar1&prod-id=6"></a>
                                <c:choose>         
                                <c:when test="${verificalog == true}">                                 
                                <a id="botaologout" href="ListaDesejosServlet?btn-desejo=add&prod-id=6">
                                    <p>Adicionar a lista de desejos</p>
                                </a>
                                </c:when>                                 
                                </c:choose>
                            </td>
                            <td class="proditem">
                                <a href="7.jsp"><img src="images/7.jpg" alt="LOGITECH_VOLANTE"/></a>
                                <p id="nomejogo">Acessório PS3 Volante Logitech</p>
                                <p id="valor-por">Por: <strong>R$ 799,90</strong></p>
                                <a id="btn-comprar" href="CarrinhoServlet?btn-comprar=comprar1&prod-id=7"></a>
                                <c:choose>         
                                <c:when test="${verificalog == true}">                                 
                                <a id="botaologout" href="ListaDesejosServlet?btn-desejo=add&prod-id=7">
                                    <p>Adicionar a lista de desejos</p>
                                </a>
                                </c:when>                                 
                                </c:choose>
                            </td>
                            <td class="proditem">
                                <a href="8.jsp"><img src="images/8.jpg" alt="MARIO_SUPER_SLUGGERS"/></a>
                                <p id="nomejogo">Jogo Wii Mario Super Sluggers</p>
                                <p id="valor-por">Por: <strong>R$ 189,90</strong></p>
                                <a id="btn-comprar" href="CarrinhoServlet?btn-comprar=comprar1&prod-id=8"></a>
                                <c:choose>         
                                <c:when test="${verificalog == true}">                                 
                                <a id="botaologout" href="ListaDesejosServlet?btn-desejo=add&prod-id=8">
                                    <p>Adicionar a lista de desejos</p>
                                </a>
                                </c:when>                                 
                                </c:choose>
                            </td>
                        </tr> 
                        <tr>
                            <td class="proditem">
                                <a href="9.jsp"><img src="images/9.jpg" alt="VITA"/></a>
                                <p id="nomejogo">Console PlayStation Vita - SONY</p>
                                <p id="valor-por">Por: <strong>R$ 989,90</strong></p>
                                <a id="btn-comprar" href="CarrinhoServlet?btn-comprar=comprar1&prod-id=9"></a>
                                <c:choose>         
                                <c:when test="${verificalog == true}">                                 
                                <a id="botaologout" href="ListaDesejosServlet?btn-desejo=add&prod-id=9">
                                    <p>Adicionar a lista de desejos</p>
                                </a>
                                </c:when>                                 
                                </c:choose>
                            </td>
                            <td class="proditem">
                                <a href="10.jsp"><img src="images/10.jpg" alt="NARUTO_ULTIMATE_NINJA_STORM_3"/></a>
                                <p id="nomejogo">Jogo PS3 Naruto Ultimate Ninja Storm 3</p>
                                <p id="valor-por">Por: <strong>R$ 199,90</strong></p>
                                <a id="btn-comprar" href="CarrinhoServlet?btn-comprar=comprar1&prod-id=10"></a>
                                <c:choose>         
                                <c:when test="${verificalog == true}">                                 
                                <a id="botaologout" href="ListaDesejosServlet?btn-desejo=add&prod-id=10">
                                    <p>Adicionar a lista de desejos</p>
                                </a>
                                </c:when>                                 
                                </c:choose>
                            </td>
                            <td class="proditem">
                                <a href="11.jsp"><img src="images/11.jpg" alt="FORZA_HORIZON"/></a>
                                <p id="nomejogo">Jogo Xbox 360 Forza Horizon</p>
                                <p id="valor-por">Por: <strong>R$ 199,90</strong></p>
                                <a id="btn-comprar" href="CarrinhoServlet?btn-comprar=comprar1&prod-id=11"></a>
                                <c:choose>         
                                <c:when test="${verificalog == true}">                                 
                                <a id="botaologout" href="ListaDesejosServlet?btn-desejo=add&prod-id=11">
                                    <p>Adicionar a lista de desejos</p>
                                </a>
                                </c:when>                                 
                                </c:choose>
                            </td>
                            <td class="proditem">
                                <a href="12.jsp"><img src="images/12.jpg" alt="KID_ICARUS"/></a>
                                <p id="nomejogo">Jogo 3DS Kid Icarus Uprising</p>
                                <p id="valor-por">Por: <strong>R$ 129,90</strong></p>
                                <a id="btn-comprar" href="CarrinhoServlet?btn-comprar=comprar1&prod-id=12"></a>
                                <c:choose>         
                                <c:when test="${verificalog == true}">                                 
                                <a id="botaologout" href="ListaDesejosServlet?btn-desejo=add&prod-id=12">
                                    <p>Adicionar a lista de desejos</p>
                                </a>
                                </c:when>                                 
                                </c:choose>
                            </td>
                        </tr> 
                    </tbody>                
                </table>
                      
            </div>
    </body>
</html>
