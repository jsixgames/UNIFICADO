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
                <li><a href="PedidosServlet?evento=listarAdmin">Listar Pedidos</a></li>
                <li><a href="AdminPanelServlet?item=listaclientes">Listar Clientes</a></li>
                <li><a href="AdminPanelServlet?item=listaend">Listar Endereços</a></li>                
                <li><a href="AdminPanelServlet?item=logoutadm">Sair/Logout</a></li>
            </ul>
        </div>         

    </body>
</html>
