<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
   Cart cart = (Cart) request.getAttribute("cart");%>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.Cart"%>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" lang="it">
<head>
    <link rel="icon" href="Immagini/sprite0.png" />
    <link rel="stylesheet" href="CSS/base.css" type="text/css">
    <link rel="stylesheet" href="CSS/About.css" type="text/css">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="it-IT" />
    <meta name="description" content="Il miglior sito dove acquistare T-Shirt  per qualsiasi gusto e necessità, con un'ampia scelta di modelli aggiornati periodicamente con i migliori design della rete." />
    <meta name="keywords" content="T-shirt, magliette, maglietta, nerd, cinema, divertenti, geek, core, series, best" />
    <title>Core Shirt: The Best T-Shirts series</title>
    
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
        
        
        <div class="help">
        <h1 class="about"> About</h1>
        </div>
        
        
       
            <div class="answers-column">
                 <div class="answers">
                     <div class="titolo"><h4> Core Shirt nasce nel primo semestre del 2016 dall'ambizione di due amici che diventa realtà. Pasquale e Giorgio si sono conosciuti alle scuole medie e successivamente si sono ritrovati all'Universita. Oggi, capitanano un gruppo di 0 giovani creativi, e hanno diverse filiali nelle loro abitazioni. Il laboratorio di stampa ha sede dal miglior offerente. </div></h4>
                     <p>
                     
                  <div>      
                  Essenzialmente, stampiamo magliette. In edizione super-iper-mega-stra limitata, al costo di 12 euro.
                 </div><br />
                     
                  <div>
                  Sei creativo? Non riesci a tenere a bada la tua originilità e vuoi lasciare scorrere la tua immaginazione? Unisciti a noi! Diventerai un creatore di T-shirt e potrai farti conoscere da migliaia di clienti in cerca di abiti unici e originali.
                 </div><br /><br />
                     
                  <div>
                  Per contattarci scrivere all'indirizzo mail:<br /><br />
                      CoreShirt.srl@gmail.com
                     </div>
                      
                 </div>
                </div>
            </div>
    </div>
    <br /><br />
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