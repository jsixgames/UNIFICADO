<%@page import="br.com.modelos.Endereco"%>
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
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="js/jquery-1.9.1.js">
        </script>        
        <link rel="shortcut icon" type="image/x-icon" href="favicon.ico"/>   

    </head>
    <body>        
        <c:import url='headerLogado.jsp' />
        <div id="conteudo">                           
            <h1 id="titulocadastro">Painel de Controle - Meus Endereços</h1>
            <div id="painelopcoes"> 
                <c:import url='opcoespainel.jsp' />
                <div id="painelconteudo">                    
                                                           
                            <h1 id="titulodadoscad">Lista de Endereços Cadastrados</h1><br>                    
                            <table id="tabelaclientes" style="margin: 0 auto;">                                        
                                <tr style="background-color: #dddddd">                                                                      
                                    <td id="titulocolunalistapedido">DESCRIÇÃO</td>
                                    <td id="titulocolunalistapedido">CEP</td>
                                    <td id="titulocolunalistapedido">ENDERECO</td>                                    
                                    <td id="titulocolunalistapedido">CIDADE</td>                                    
                                </tr>                                
                                <%
                                    List<Endereco> listend = (List<Endereco>) session.getAttribute("listaenderecos");
                                    for (int i = 0; i < listend.size(); i++) {
                                        Endereco p = listend.get(i);
                                        out.println("<tr>"                                                
                                                + "<td id='linhatabelalistapedido2' style='text-transform: capitalize'>"
                                                + p.getDescricao().toLowerCase() + "</td>"
                                                + "<td id='linhatabelalistapedido2'>" + p.getCep() + "</td>"
                                                + "<td id='linhatabelalistapedido2' style='text-transform: capitalize'>"
                                                + p.getEndereco().toLowerCase() + "</td>"
                                                + "<td id='linhatabelalistapedido2'>" + p.getCidade().toLowerCase() + "</td>"
                                                + "<td id='linhatabelalistapedido' style='border:1px solid white'>"                                                 
                                                + "<a href='CadastroEnderecoServlet?evento=editar&buscar=1&end-id="+i+"'>"
                                                + "<img id='imgremovecart' src='images/edit.png'></a>"
                                                + "<a href='CadastroEnderecoServlet?evento=remover&end-id="+i+"'>"
                                                + "<img id='imgremovecart' src='images/delete_home.png'></a>"
                                                + "</td>"
                                                + "</tr>");
                                    }
                                    session.removeAttribute("listaenderecos");
                                %>    
                            </table>                                                        
                        </div>                                 
                </div>            
        </div>

        <c:import url="footer.jsp" />
    </body>
</html>