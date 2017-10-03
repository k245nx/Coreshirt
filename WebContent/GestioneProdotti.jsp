<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="java.util.ArrayList,model.Articolo,control.manage.ManageArticolo,control.manage.DbConnect" %>
 
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.Articolo,model.Cart,java.sql.SQLException"%>
<html lang="it">
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
    <title>Core Shirt Gestionale: Gestione Dipendenti</title>
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

        </aside>
    
    </article>
        
    <article id="articolo">

    </article>
    <div id="corpo" align="center">
    <%!
		ManageArticolo ma=new ManageArticolo();
		ArrayList<Articolo> articoli=ma.getArticoli(); 
        
	%>
    	<h3>Inserisci Articolo</h3>
		<form name="InsertArticolo" action="ServletInsertArticolo" method="post" onsubmit="return validateForm()">
	id Articolo<br>
	<input type="text" name="idArticolo"><br>
	Nome<br>
	<input type="text" name="nome"><br>
	Categoria<br>
	<input type="text" name="categoria"><br>
	Prezzo<br>
	<input type="text" name="prezzo"><br>
	Quantità <br>
	<input type="text" name="quantita"><br>
	<br><button type="submit" onclick="ServletInsertArticolo" onsubmit="return validateForm()">Inserisci</button>
</form>

<h3>Inserisci Tshirt</h3><br>


        </div>

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