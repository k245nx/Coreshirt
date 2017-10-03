<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Collection<?> productsM = (Collection<?>) request.getAttribute("productsM");
   Collection<?> productsF = (Collection<?>) request.getAttribute("productsF");
   Articolo product = (Articolo) request.getAttribute("product"); 
   Cart cart = (Cart) request.getAttribute("cart");%>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.Articolo,model.Cart"%>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" lang="it">
<head>
    <script src="Script/jquery.js"></script>
    <script src="Script/loadmore.js"></script>
    <link rel="icon" href="./Immagini/sprite0.png" />
    <link rel="stylesheet" href="./CSS/base.css" type="text/css">
    <link rel="stylesheet" href="./CSS/home.css" type="text/css">
    <link rel="stylesheet" href="./CSS/thumbnails.css" type="text/css">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="it-IT" />
    <meta name="description" content="Il miglior sito dove acquistare T-Shirt  per qualsiasi gusto e necessità, con un'ampia scelta di modelli aggiornati periodicamente con i migliori design della rete." />
    <meta name="keywords" content="T-shirt, magliette, maglietta, nerd, cinema, divertenti, geek, core, series, best" />
    <title>Core Shirt: The Best T-Shirts series</title>
    <script>
       $(document).ready(function() {
		  $(".element").mouseover(function() {
			 this.animate({
				height : "+=20px",
				width : "+=20px"
				});
			});
		   $(".btn2").click(function() {
			  $("#p1").animate({
				height : "-=20px",
				width : "-=20px"
				});
			});
		});
	</script>
</head>
<body>
<div id="wrapper">
    <article id="articolo1">
    <div id="lista">
    <a href="./"><div id="banner"> <img class="Banner" src="Immagini/prova.png"> 
          <img class="core" src="Immagini/core2.png"></a>
        </div>
    <div>
    <nav>    
        <ul id="menu">
            <li><a href="./"><img class="home" src="Immagini/home.png"></a> </li>
            <li><a href="./?action=Uomo"> Uomo </a></li>
            <li><a href="./?action=Donna"> Donna  </a>
            </li>
            <li><a href="./About">About</a></li>
            <li><a href="./Help">Help</a></li>   
            <li><a href="./Checkout">Checkout</a></li>
            <li><a href="./?action=cart">
                <img class="cart" src="Immagini/cart.png"></a></li>
        </ul>
    </nav>
    </div>
    </div>
    </article>
    <!-- </div>-->
         <article>
    <aside id="aside_bar">
        <span> <img src="Immagini/spedizione.png"> 
            <div class="promesse">
                Spedizione gratuita dopo i 3 articoli</div></span>
        <span class="48h"><img src="Immagini/48h.png">
            <div class="promesse">Spedizione in 48 ore con corriere espresso</div>
        </span>
        
            <!--<div class="spedizione1">-->
                
        <span class="48h"><img src= "Immagini/Soddisfazione.png">
            <div class="promesse">Soddisfatti al 100%</div>
        </span>
        
        
        
        </aside>
    
    </article>
        
    <article id="articolo">
    <div id="Banner2" >
        <figure>
        <img src= "Immagini/BannerImg1.png">
            <img src= "Immagini/BannerImg2.png">
            <img src= "Immagini/BannerImg3.png">
            <img src= "Immagini/BannerImg4.png">
            <img src=  "Immagini/BannerImg1.png">
           
        </figure>   
    </div>
    </article>
    <div id="corpo" align="center">
    <%  if (productsM != null && productsM.size() != 0 && productsF != null && productsF.size() != 0) {
		Iterator<?> it1 = productsM.iterator();
		Iterator<?> it2 = productsF.iterator();
		String a="";
		int i=0,k=1;
		while (it1.hasNext()&&it2.hasNext()) {
			Articolo bean = (Articolo) it1.next();
			Articolo bean2= (Articolo) it2.next();
			if(i%12==0&&i!=0){a=""+k;k++;}
			%>
		<a id="a" href="Control?action=dettagli&id=<%=bean.getidArticolo()%>&sesso=M">	
        <div class="element<%=a%>" style="display: inline-block"><img class="thumbnails" src="./Immagini/Magliette/Maglietta(<%=bean.getidArticolo()%>).jpg"></a>
            <div><%=bean.getnome()%></div>
            <div class="prezzo"><%=bean.getprezzo()%>€</div>
            <div class="hidden"><a id="a" href="Control?action=dettagli&id=<%=bean.getidArticolo()%>&sesso=M"><button class="button">Visualizza dettagli</button></a></div>
        </div>
        <a id="a" href="Control?action=dettagli&id=<%=bean2.getidArticolo()%>&sesso=F">
        <div class="element<%=a%>" style="display: inline-block"><img class="thumbnails" src="./Immagini/Magliette/Maglietta(<%=bean2.getidArticolo()%>)F.jpg"></a>
            <div><%=bean2.getnome()%></div>
            <div class="prezzo"><%=bean2.getprezzo()%>€</div>
            <div class="hidden"><a id="a" href="Control?action=dettagli&id=<%=bean2.getidArticolo()%>&sesso=F"><button class="button">Visualizza dettagli</button></a></div>
        </div>
        <%i+=2;
           } 
          }%> 
          <img id="loadMore" src="Immagini/arrow.png">
    </div>
    </div>
        <footer>
        <div class="container">
		<div class="row">
			<div class="col1">
				<h2>I più venduti</h2>
				<div class="menu-container">
                    <ul>
                        <li><a href="./?action=uomo">T-Shirt Uomo</a></li>
                        <li><a href="./?action=donna">T-Shirt Donna</a></li>
                    </ul>
                </div>			
            </div>
			<div class="col1">
				<h2>Info</h2>
					<div class="menu-container">
                    <ul>
                        <li><a href="./About">About</a></li>
                        <li><a href="./About">Contattaci</a></li>
                        <li><a href="./Help">Guida alle taglie</a></li>
                        <li><a href="./Help">Tariffe Spedizione</a></li>
                    </ul>
                </div>			
            </div>
			<div class="col1">
				<h2>Segui</h2>
				<div class="menu-container">
                    <ul>
                        <li><a target="_blank" href="https://www.facebook.com/">Facebook</a></li>
                        <li><a target="_blank" href="https://twitter.com/">Twitter</a></li>
                        <li><a target="_blank" href="https://www.tumblr.com/">Tumblr</a></li>
                    </ul>
                </div>			
            </div>
			<div class="col2">
				<div class="CreditCard">
				<img src="Immagini/CreditCard.png">
					<div class="text">
						<p>
						© 2016 Core Shirt S.R.L | P. IVA 01594368721<br>
						All designs copyright by owner.<br>
						<a href="">Privacy Policy</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
    </footer>
</body>
</html>