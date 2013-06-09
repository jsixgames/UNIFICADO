<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>          
            <div id="conteinercadastro">       
                    <form method="post" action="CadastroClienteServlet" id="cadastro">            
                    <div id="formcadastro" style="width: 500px; float: left; margin: 0 auto;">
                        <b> 
                            <h1 id="titulodadoscad">Dados Pessoais</h1>
                            <div class="linha">
                                <span class='item'>Nome Completo:</span> 
                                <span class='caixa'><input type="text" name="nome" value="" maxlength="40" autofocus required /></span>
                                <br/>
                            </div>                            
                            <div class="linha">
                                <span class='item'>CPF:</span>                      
                                <span class='caixa'><input type="text" name="cpf" style="width: 100px" required/></span>
                                <br/>
                            </div>
                            <div class="linha">
                                <span class='item'  style="padding-top: 3px;">Sexo:</span>
                                <span class="item" style="text-align: right; padding:3px;margin-left: 15px"><input type="radio" name="sexo" value ="masculino" required/>Masculino                  
                                    <input type="radio" name="sexo" value ="feminino" required/>Feminino</span>
                                <br/>
                            </div>                                                            
                            <div class="linha">
                                <span class='item'>Email:</span>                      
                                <span class='caixa'><input type="email" name="email" value="" required style="text-transform: lowercase"/></span>                       
                                <br/>
                            </div> 
                            <div class="linha">
                                <span class='item'>Senha:</span>                      
                                <span class='caixa'><input type="password" name="senha" value="" required/></span>
                                <br/>
                            </div>
                            <br>                            
                        </b>                                            
                </div>                                     
                            
                <div id="formcadastro" style="width: 500px;float: right;margin: 0 auto;">                                    
                    <h1 id="titulodadoscad">Endereço Principal</h1>                    
                        <b>                           
                            <div class="linha">
                                <span class='item'>Endereço Completo:</span> 
                                <span class='caixa'><input type="text" name="endereco" maxlength="100" style="width: 300px" required /></span>                           
                            </div>                              
                           <div class="linha">
                                <span class='item'>CEP:</span> 
                                <span class='caixa'><input type="text" name="cep" value="" style="width: 80px" required /></span>
                                <br/>
                            </div>                                                
                            <div class="linha">
                                <span class='item'>Cidade/UF:</span>                      
                                <span class='caixa'><input type="text" name="cidade" style="width: 200px" required/></span>
                                <br/>
                            </div>                              
                            <div id="confirmar" style="width: 350px; float: left;position: relative;
                             margin-top: 30px;padding-left: 180px;">                                
                            <input class="btn-salvar" name="btn_cadastrar" type="submit" value="Cadastrar"/>                        
                        </div>
                        </b>
                </div> 
                </form>
            </div>
    </body>
</html>
