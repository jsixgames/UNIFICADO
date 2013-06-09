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
            
            <h1 id="titulocadastro">Jogo PS3 Bioshock Infinite</h1>
            
            <div id="imgprodutoposicao">
                <img class="imgprod" src="images/3.jpg" alt="biochock ps3">
            </div>      
            
            <div id="descprod">
                <div class="infoprodtitulo">
                    <span id="titulodesc">INFORMAÇÕES DO PRODUTO</span>
                </div>
            
                <div class="infoprodconteudo">
                    <div style="width: auto;height: 270px; padding: 15px 5px 15px 10px;">
                        &bull; <span id="infoprodtopic">Nome do Produto: </span><span id="textodesc">Bioshock Infinite</span>
                        <br>&bull; <span id="infoprodtopic">Categoria: </span><span id="textodesc">Jogos de PS3</span>
                        <br>&bull; <span id="infoprodtopic">Gênero: </span><span id="textodesc">Tiro</span>                                            
                         <br><br>&nbsp;&nbsp;<span id="infoprodtopic">Sobre o jogo: </span>
                         <p id="textodesc" style="padding: 10px 30px 0 30px">
                            BioShock Infinite é uma aventura Bioshock totalmente nova situada no cenário de 
                            Columbia, uma enorme cidade que fica no céu. Os jogadores assumem o papel de um 
                            azarado ex-agente Pinkerton, Booker DeWitt, enviado para Columbia no ano de 1912
                            para regatar Elizabeth, uma jovem garota aprisionada ali desde a infância. 
                            DeWitt irá cultivar uma relação com Elizabeth, aperfeiçoando suas habilidades 
                            com as dela, possibilitando que eles escapem de uma cidade que está literalmente
                            caindo do céu. Você aprenderá a lutar contra inimigos em batalhas aéreas 
                            ultra-velozes, duelar em ambientes tanto abertos quanto fechados, e dominar o 
                            poder de dezenas de novas armas e habilidades.
                        </p>                        
                    </div>      
                </div>                
                <div class="infoprodcomprar">                    
                    <div style="padding: 20px 0px 0px 25px;float: left;width: 200px;"> 
                    <span id="valor-por" style="color: #1A5A9C">Por: <strong>R$ 199,90</strong></span>                   
                     </div>
                     <span><a href="CarrinhoServlet?prod-id=3&btn-comprar=comprar2">
                         <img id="btn-comprar2">
                     </a>  </span>                   
                </div>                
                 </div>
        </div>

        <c:import url="footer.jsp" />
    </body>
</html>


