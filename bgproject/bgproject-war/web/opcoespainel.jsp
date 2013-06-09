<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>    
        <div id="menupainel">
            <ul>                                  
                <li><a href="PedidosServlet?evento=listar">Meus Pedidos</a></li>
                <li><a href="CadastroEnderecoServlet?evento=listarenderecos">Meus Endereços</a></li>                                
                <li><a href="ListaDesejosServlet?listar=show2">Lista de Desejos</a></li>
                <li><a href="endereco.jsp">Cadastrar Endereço</a></li>
                <li><a href="AlterarClienteServlet?opcao=1">Alterar Cadastro</a></li>                        
                <li><a href="encerrar.jsp">Encerrar Conta</a></li>
            </ul>
        </div>         
    </body>
</html>
