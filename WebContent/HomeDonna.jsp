<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Collection<?> productsF = (Collection<?>) request.getAttribute("productsF");
   Collection<?> productsC = (Collection<?>) request.getSession().getAttribute("productsC");
   String all=""+request.getSession().getAttribute("all");
   String categoria=""+request.getSession().getAttribute("cat");
   Cart cart = (Cart) request.getAttribute("cart");%>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.Articolo,model.Cart"%>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" lang="it">
<head>
    <script src="Script/jquery.js"></script>
    <script src="Script/loadmore.js"></script>
    <link rel="icon" href="Immagini/sprite0.png" />
    <link rel="stylesheet" href="CSS/base.css" type="text/css">
    <link rel="stylesheet" href="CSS/uomo.css" type="text/css">
    <link rel="stylesheet" href="./CSS/thumbnails.css" type="text/css">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="it-IT" />
    <meta name="description" content="Il miglior sito dove acquistare T-Shirt  per qualsiasi gusto e necessità, con un'ampia scelta di modelli aggiornati periodicamente con i migliori design della rete." />
    <meta name="keywords" content="T-shirt, magliette, maglietta, nerd, cinema, divertenti, geek, core, series, best" />
    <title>Core Shirt: The Best T-Shirts series</title>
    <script>
      $(document).ready(function(){
    	 $('.categoria').click(function(){
    		 var cat=this.getAttribute("id");
    		 var sex='F';
    		  $.ajax({
    			 type:"get",
    			 url:"./?action=getCategory&sesso="+sex+"&categoria="+cat,
    		    success:function(){
    		    	 $('#corpo').load("./?action=donna&categoria="+cat+" #corpo>div,#loadMore");
    		    }
    		})
    	 })
    	 $('.categoria1').click(function(){
    		 var cat=this.getAttribute("id");
    		 var sex='M';
    		 window.location.href="./?action=getCategory1&sesso="+sex;
    	 })
      })
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
    
    <article>
    <aside id="aside_bar">
        <span> <img  src="Immagini/spedizione.png"> 
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
    
    
        <article>
     <div>
    <p class="uomo"> T-shirt donna <p>
     </div>
    </article>
        
    <article>
    <div id="sideContainer">
        <div id="menuL">
            <ul>
                <li class="type"><a href="./?action=Donna">Donna</a></li>
                <ul>
                    <li><a href="#" class="categoria" id="Cinema">Cinema</a></li>
                    <li><a href="#" class="categoria" id="Geek">Geek</a></li>
                    <li><a href="#" class="categoria" id="Divertenti">Divertenti</a></li>
                    <li><a href="#" class="categoria" id="Manga">Anime e Manga</a></li>
                    <li><a href="#" class="categoria" id="Comics">Comics</a></li>
                    <li><a href="#" class="categoria" id="Nerd">Nerd</a></li>
                </ul>
                <li class="type"><a href="./?action=uomo">Uomo</a></li>
                <ul>
                    <li><a href="#" class="categoria1" id="Cinema">Cinema</a></li>
                    <li><a href="#" class="categoria1" id="Geek">Geek</a></li>
                    <li><a href="#" class="categoria1" id="Divertenti">Divertenti</a></li>
                    <li><a href="#" class="categoria1" id="Manga">Anime e Manga</a></li>
                    <li><a href="#" class="categoria1" id="Comics">Comics</a></li>
                    <li><a href="#" class="categoria1" id="Nerd">Nerd</a></li>
                </ul>
            </ul> 
        </div>
  <div id="corpo" align="center">
    <%  Collection<?> products1=null;
        if(all.contains("1")&&categoria.contains("1"))
    	   {products1=productsC;}
        else
    	   {products1=productsF;}
        if (products1 != null && products1.size() != 0) {
	    Iterator<?> it = products1.iterator();
		String a="";
		int i=0,k=1;
		while (it.hasNext()) {
			Articolo bean = (Articolo) it.next(); 
			if(i%12==0&&i!=0){a=""+k;k++;}%>
        <a id="a" href="Control?action=dettagli&id=<%=bean.getidArticolo()%>&sesso=<%=bean.getSesso()%>">	
        <div class="element<%=a%>" style="display: inline-block"><img class="thumbnails" src="./Immagini/Magliette/Maglietta(<%=bean.getidArticolo()%>)F.jpg"></a>
            <div><%=bean.getnome()%></div>
            <div class="prezzo"><%=bean.getprezzo()%>€</div>
            <div class="hidden"><a id="a" href="Control?action=dettagli&id=<%=bean.getidArticolo()%>&sesso=<%=bean.getSesso()%>"><button class="button">Visualizza dettagli</button></a></div>
        </div>
        <% i++;
           } 
          }%>
          <img id="loadMore" src="Immagini/arrow.png"> 
    </div>
          
    </div>  
        </article>
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