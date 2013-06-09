<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/jquery.maskedinput.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(function() {
                $('input[name=cep]').mask('99999-999');
            });

        </script>        
    </head>
    <body>                              
        <form method="post" action="CadastroEnderecoServlet" id="cadastro">                                                                                             
            <div id="posformnewend">                                    
                <h1 id="titulodadoscad">Endereço</h1>                    
                <b>                             
                    <div class="linha">
                        <span class='item'>Descrição:</span> 
                        <span class='caixa'><input type="text" name="descricao" maxlength="50" required /></span>                           
                    </div>                                                  
                    <div class="linha">
                        <span class='item'>Endereço Completo:</span> 
                        <span class='caixa'><input type="text" name="endereco" maxlength="100" style="width: 320px" required /></span>                           
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
                    <div id="btn-newend">                                
                        <input class="btn-salvar" name="btn-newend" type="submit" value="Cadastrar"/>                        
                    </div>
                </b>
            </div> 
        </form>            
    </body>
</html>
