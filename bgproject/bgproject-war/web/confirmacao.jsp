<%@page import="br.com.modelos.Endereco"%>
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
            <h1 id="titulocadastro">Confirmação do Pedido</h1>
            <div id="descprod" style='border:0;width: 700px;height: 100%;float:left;margin: 0 auto;margin-left: 150px;margin-top: 70px;'>
                <div class="infoprodtitulo">
                    <span id="titulodesc">DADOS CADASTRAIS</span>
                </div>            
                <div class="infoprodconteudo">
                    <div style="width: auto;height: auto; padding: 15px 5px 15px 10px;">
                        &bull; <span id="infoprodtopic">NOME: </span><span id="textodesc"><c:out value="${clientep.getNome()}"/></span>
                        <br>&bull; <span id="infoprodtopic">CPF: </span><span id="textodesc"><c:out value="${clientep.getCpf()}"/></span>
                        <br>&bull; <span id="infoprodtopic">EMAIL: </span><span id="textodesc"><c:out value="${clientep.getEmail()}"/></span>                                            
                        <div class="infoprodtitulo" style="width: 690px;margin-top:10px;margin-left:-10px">
                        <span id="titulodesc">INFORMAÇÕES DA COMPRA</span>
                        </div>
                        <table style="margin: 0 auto;margin-top: 10px;position: relative">
                            <tr style="background-color: #dddddd">                                                
                                <td id="titulocolunalistapedido">NOME</td>
                                <td id="titulocolunalistapedido">CATEGORIA</td>
                                <td id="titulocolunalistapedido">QUANTIDADE</td>
                                <td id="titulocolunalistapedido">PREÇO</td>                    
                            </tr>                
                           <% 
                            List<Item_Pedido> list = (List<Item_Pedido>) session.getAttribute("listaitem");
                            double vp = 0;
                            String vps = null;
                            for (int i = 0; i < list.size();i++){
                            Item_Pedido ip = list.get(i);                   
                            String preco = new MetodosGerais().doubleTostring(ip.getPreco_total());                   
                            out.println("<tr>" +                            
                            "<td id='linhatabelalistapedido2'>" + ip.getProduto().getNome() + "</td>" +
                            "<td id='linhatabelalistapedido2'>" + ip.getProduto().getDepto() + "</td>" +                 
                            "<td id='linhatabelalistapedido2'>" + ip.getQtd()+"</td>" +
                            "<td id='linhatabelalistapedido2'>" + preco + "</td>" +                                                                          
                            "</tr>"                                                             
                           );
                            double precototal = ip.getPreco_total();
                            vp = vp + precototal;
                            vps = new MetodosGerais().doubleTostring(vp);
                        } 
                        if(vps==null){vps="0";}                        
                     %>                                                            
                     </table>                     
                     <div class="infoprodtitulo" style="width: 690px;margin-top:10px;margin-left:-10px;position: relative">
                        <span id="titulodesc">ENDEREÇO DE ENTREGA</span>
                        </div>
                     
                     <div style="width: auto;height: auto; padding: 15px 5px 15px 10px;">
                         <c:choose>         
                             <c:when test="${enderecop!=null}"> 
                                 <%
                                     List<Endereco> le = (List<Endereco>) session.getAttribute("enderecop");
                                     for (int i = 0; i < le.size(); i++) {
                                         Endereco e = le.get(i);
                                         out.println("<form action='FinalizarCompra'>"
                                                    +"<input id='infoprodtopic' type='radio' name='endentrega' value='"+e.getDescricao()+"'>"+e.getDescricao()
                                                 + "<br>"                                                    
                                                 );
                                     }                                     
                                     out.println("<input type='submit' name='evento' value='Escolher'></form>");
                                     session.removeAttribute("enderecop");
                                 %>  
                                 
                             </c:when> 
                             <c:when test="${enderecoset!=null}"> 
                      &bull; <span id="infoprodtopic">CEP: </span><span id="textodesc"><c:out value="${enderecoset.getCep()}"/></span>
                             <br>&bull; <span id="infoprodtopic">ENDEREÇO: </span><span id="textodesc"><c:out value="${enderecoset.getEndereco()}"/></span>
                             <br>&bull; <span id="infoprodtopic">CIDADE: </span><span id="textodesc"><c:out value="${enderecoset.getCidade()}"/></span>                                   
                             <%session.removeAttribute("enderecoset");%>                                                             
                             </c:when>                              
                         </c:choose>                            
                        </div>
                        
                        
                        <div style="float: left;margin: 0 auto; margin-top:30px;
                         margin-left: 88px;width: 500px;height: auto"> 
                            <span id="valor-por" style="padding-top:30px;float: left;color: #1A5A9C">Total do Pedido: <strong style="color: #ff3f18">R$ <%=vps%></strong></span>                   
                         <span style="float: right">
                         <a href="FinalizarCompra?evento=finalizar&formpag=1&vf=<%=vp%>">
                         <img src="images/formpag1.png"><br>
                         </a>
                         <a href="FinalizarCompra?evento=finalizar&formpag=2&vf=<%=vp%>">
                         <img src="images/formpag2.png">
                         </a>
                         </span>                   
                     </div>
                         
                                                 
                         
                </div>                
                </div>                      
                </div>
                </div>        
        <c:import url="footer.jsp" />
    </body>
</html>


