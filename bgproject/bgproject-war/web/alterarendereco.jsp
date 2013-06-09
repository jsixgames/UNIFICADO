<%@page import="br.com.modelos.Endereco"%>
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
        <script type="text/javascript">
            $(function() {
                $('input[name=cep]').mask('99999-999');
            });

        </script>        
    </head>
    <body>        
        <%
            Endereco end = (Endereco) session.getAttribute("endtoedit");            
        %>
        <c:import url='headerLogado.jsp' />

        <div id="conteudo">                           
            <h1 id="titulocadastro">Painel de Controle - Alteração de endereços</h1>
            <div id="painelopcoes"> 
                <c:import url='opcoespainel.jsp' />
                <div id="painelconteudo">
                    <form method="post" action="CadastroEnderecoServlet" id="cadastro">                                                                                             
                        <div id="posformnewend">                                    
                            <h1 id="titulodadoscad">Alteração do Endereco - <b style="color:blue">
                                    <%=end.getDescricao()%>                                    
                                </b></h1>                    
                            <b>                             
                                <div class="linha">
                                    <span class='item'>Descrição:</span> 
                                    <span class='caixa'>
                                        <input type="text" name="descricao" maxlength="50" value="${endtoedit.getDescricao()}" required />
                                    </span> 
                                </div>                                                  
                                <div class="linha">
                                    <span class='item'>Endereço Completo:</span> 
                                    <span class='caixa'><input type="text" name="endereco" value="${endtoedit.getEndereco()}" maxlength="100" style="width: 320px" required /></span>                           
                                </div>                              
                                <div class="linha">
                                    <span class='item'>CEP:</span> 
                                    <span class='caixa'><input type="text" name="cep" value="${endtoedit.getCep()}" style="width: 80px" required /></span>
                                    <br/>
                                </div>                                                
                                <div class="linha">
                                    <span class='item'>Cidade/UF:</span>                      
                                    <span class='caixa'><input type="text" name="cidade" value="${endtoedit.getCidade()}" style="width: 200px" required/></span>
                                    <br/>
                                </div>                              
                                    <input type="hidden" name="retorno" value="ok">                                                                        
                                <div id="btn-newend">                                
                                    <input class="btn-salvar" name="evento" type="submit" value="alterar"/>                        
                                </div>
                            </b>
                        </div> 
                    </form>            
                </div>
            </div>
        </div>

        <c:import url="footer.jsp" />
    </body>
</html>