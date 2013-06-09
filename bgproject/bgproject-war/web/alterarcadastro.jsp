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
            <h1 id="titulocadastro">Painel de Controle - Alteração de Cadastro</h1>
            <div id="painelopcoes"> 
                <c:import url='opcoespainel.jsp' />
                <div id="painelconteudo">
                    <form method="post" action="AlterarClienteServlet" id="cadastro">                                                                                             
                        <div id="posformnewend">                                    
                            <h1 id="titulodadoscad">Dados Cadastrais</h1>                    
                            <b>                             
                                <div class="linha">
                                <span class='item'>Nome:</span> 
                                <span class='caixa'><input type="text" name="nome" value="${cliente.getNome()}" maxlength="40" required /></span>
                                <br/>
                                <div class="linha">
                                <span class='item'>CPF:</span>                      
                                <span class='caixa'><input type="text" name="cpf" value="${cliente.getCpf()}" style="width: 100px" readonly /></span>
                                <br/>
                            </div>
                            <div class="linha">
                                <span class='item'  style="padding-top: 3px;">Sexo:</span>
                                <span class="item" style="text-align: right; padding:3px;margin-left: 15px">
                                    <input type="radio" name="sexo" value ="masculino" required/>Masculino                  
                                    <input type="radio" name="sexo" value ="feminino" required/>Feminino</span>
                                <br/>
                            </div>                                                            
                            <div class="linha">
                                <span class='item'>Email:</span>                      
                                <span class='caixa'><input type="email" name="email" value="${cliente.getEmail()}" readonly/></span>                       
                                <br/>
                            </div> 
                            <div class="linha">
                                <span class='item'>Senha:</span>                      
                                <span class='caixa'><input type="password" name="senha" value="${cliente.getSenha()}" /></span>
                                <br/>
                            </div>
                            <br>                            
                        </b>
                            </div>                            
                                <div id="btn-newend">                                
                                    <input class="btn-salvar" name="btn-alterar" type="submit" value="alterar"/>                        
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