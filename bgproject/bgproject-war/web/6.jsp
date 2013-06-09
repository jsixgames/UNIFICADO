<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head> 
        <title>BOX GAMES - A SUA LOJA DE GAMES</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta name="description" content="BOX GAMES | Loja de Games | Compre Consoles, Jogos e Equipamentos para sua diversão"/>
        <link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.9.1/build/cssreset/cssreset-min.css"/>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="js/jquery-1.9.1.js">                        
        </script>        
        <link rel="shortcut icon" type="image/x-icon" href="favicon.ico"/>   
        
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
        
        <div id="conteudo">                           
            
            <h1 id="titulocadastro">Jogo Xbox 360 PES 2013</h1>
            
            <div id="imgprodutoposicao">
                <img class="imgprod" src="images/6.jpg" alt="pes xbox">
            </div>      
            
            <div id="descprod">
                <div class="infoprodtitulo">
                    <span id="titulodesc">INFORMAÇÕES DO PRODUTO</span>
                </div>
            
                <div class="infoprodconteudo">
                    <div style="width: auto;height: 270px; padding: 15px 5px 15px 10px;">
                        &bull; <span id="infoprodtopic">Nome do Produto: </span><span id="textodesc">Pro Evolution Soccer - PES 2013</span>
                        <br>&bull; <span id="infoprodtopic">Categoria: </span><span id="textodesc">Jogos de Xbox 360</span>
                        <br>&bull; <span id="infoprodtopic">Gênero: </span><span id="textodesc">Tiro</span>                                            
                         <br><br>&nbsp;&nbsp;<span id="infoprodtopic">Sobre o jogo: </span>
                         <p id="textodesc" style="padding: 10px 30px 0 30px">
                            Nessa nova edição do game PES 2013 de Xbox 360 que 
                            você encontra aqui na UZ Games, o jogador poderá
                            contar com uma novidade que estávamos aguardando
                            faz muito tempo, 20 times brasileiros licenciados
                            em um mesmo jogo, além de muitos outros.
                            O jogo Pro Evolution Soccer 2013, mais conhecido como
                            PES 2013, está chegando e reafirmando seu posicionamento
                            com possibilidades incríveis de jogabilidade e tecnologia,
                            em busca de tornar-se o melhor jogo de videogame na
                            categoria de esportes. Foi através da ajuda de jogadores e apaixonados
                            pela série que a Konami, produtora oficial do game,
                            se baseou para acrescentar diferenciais fundamentais 
                            comparados ao PES 12.
                        </p>                        
                    </div>      
                </div>                
                <div class="infoprodcomprar">                    
                    <div style="padding: 20px 0px 0px 25px;float: left;width: 200px;"> 
                    <span id="valor-por" style="color: #1A5A9C">Por: <strong>R$ 99,90</strong></span>                   
                     </div>
                     <span><a href="CarrinhoServlet?prod-id=6&btn-comprar=comprar2">
                         <img id="btn-comprar2">
                     </a>  </span>                   
                </div>                
                 </div>
        </div>

        <c:import url="footer.jsp" />
    </body>
</html>


