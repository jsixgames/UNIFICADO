<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="contopmenu">            
            <div id="toptotal">                
                <div id="topmenu">
                    <ul>                                  
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="login.jsp">Login</a></li>
                        <li><a href="cadastro.jsp">Cadastro</a></li>                        
                        <li><a href="lojas.jsp">Nossas Lojas</a></li>
                        <li><a href="fale.jsp">Central de Atendimento</a></li>
                    </ul>
                </div> 

                <div id="cart">
                    <p class="carticone"></p>
                    <a href="CarrinhoServlet?mostrar=1" class="cartLink">
                        <span>Carrinho</span>
                        <span><%
                            if (session.getAttribute("qtde") == null) {
                                out.print("0");
                            } else {
                                out.print(session.getAttribute("qtde"));
                            };
                            %></span>
                        <span class="" style="display: block;">Produtos</span>                        
                </div>

            </div>
        </div>
        <div id="Banner">
            <a href="index.jsp">
                <img class="logo" src="images/logo-oficial1.png" alt="logo"/>
            </a>
            <%
                out.println("<span id='statuslogin'>"
                        + "Você ainda não está logado, para logar clique " + "<a href='login.jsp'>"
                        + "<span style='color:blue;font-size: 14px; text-decoration:none'>"
                        + "aqui</span></a></span>");
            %>
        </div>

        <div id="bgmenu">     
            <div id="cssmenu">
                <ul>
                    <li class='has-sub'><a href='#'><span>PlayStation 3</span></a>
                        <ul>
                            <li><a href='#'><span>Jogos</span></a></li>
                            <li><a href='#'><span>Acessórios</span></a></li>                            
                            <li class='last'><a href='#'><span>Consoles</span></a></li>
                        </ul>
                    </li>
                    <li class='has-sub'><a href='#'><span>Xbox 360</span></a>
                        <ul>
                            <li><a href='#'><span>Jogos</span></a></li>
                            <li><a href='#'><span>Acessórios</span></a></li>                            
                            <li class='last'><a href='#'><span>Consoles</span></a></li>
                        </ul>
                    </li>
                    <li class='has-sub'><a href='#'><span>Nintendo Wii</span></a>
                        <ul>
                            <li><a href='#'><span>Jogos</span></a></li>
                            <li><a href='#'><span>Acessórios</span></a></li>                            
                            <li class='last'><a href='#'><span>Consoles</span></a></li>
                        </ul>
                    </li>
                    <li class='has-sub'><a href='#'><span>Nintendo 3DS</span></a>
                        <ul>
                            <li><a href='#'><span>Jogos</span></a></li>
                            <li><a href='#'><span>Acessórios</span></a></li>                            
                            <li class='last'><a href='#'><span>Consoles</span></a></li>
                        </ul>
                    </li>
                    <li class='has-sub'><a href='#'><span>PC/MAC</span></a>
                        <ul>
                            <li><a href='#'><span>Jogos</span></a></li>
                            <li><a href='#'><span>Acessórios</span></a></li>                            
                            <li class='last'><a href='#'><span>Consoles</span></a></li>
                        </ul>
                    </li>
                    <li class='has-sub'><a href='#'><span>PS Vita</span></a>
                        <ul>
                            <li><a href='#'><span>Jogos</span></a></li>
                            <li><a href='#'><span>Acessórios</span></a></li>                            
                            <li class='last'><a href='#'><span>Consoles</span></a></li>
                        </ul>
                    </li>                                     
                </ul>
                <form action="BuscarServlet" method="get">
                    <input id="buscar" name="k" type="text" size="20"/>
                    <input type="submit" name="evento" value="Buscar"/>
                </form>
            </div>                
        </div>
    </body>
</html>
