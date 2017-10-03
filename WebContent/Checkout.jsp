<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
   Cart cart = (Cart) session.getAttribute("cart");%>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.Articolo,model.Cart,model.TShirt"%>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" lang="it">
<head>
    <script src="Script/jquery.js"></script>
    <script src="Script/showfattura.js"></script>
    <link rel="icon" href="Immagini/sprite0.png" />
    <link rel="stylesheet" href="CSS/base.css" type="text/css">
    <link rel="stylesheet" href="CSS/Cart.css" type="text/css">
    <link rel="stylesheet" href="CSS/Checkout.css" type="text/css">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="it-IT" />
    <meta name="description" content="Il miglior sito dove acquistare T-Shirt  per qualsiasi gusto e necessità, con un'ampia scelta di modelli aggiornati periodicamente con i migliori design della rete." />
    <meta name="keywords" content="T-shirt, magliette, maglietta, nerd, cinema, divertenti, geek, core, series, best" />
    <title>Core Shirt: The Best T-Shirts series</title>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script>
    $( function() {
    var availableTags = [
    	"San Giuseppe Vesuviano",
        "Terzigno",
        "Napoli",
        "Milano",
        "Roma",
        "Poggiomarino",
        "Sarno",
        "Salerno",
        "Campobasso",
        "Striano",
        "Fisciano",
        "Baronissi",
    ];
    $( "#tags" ).autocomplete({
      source: availableTags
    });
  } );
  </script>
    <script>
    $(document).ready(function(){
    	$("#popup").hide();
    	$('.hidden').hide();
    	$('.Payment').change(function(){
    		var Payment=$('.Payment').val();
    		if(Payment=='3'){
    			$('.Numerocarta .input').hide();
    			$('.hidden').show();
    		}
    		else{
    			$('.Numerocarta .input').show();
    			$('.hidden').hide();
    		}
    	})
    	$("#chiudi").click(function(){
			$("#popup").hide();
			$("#veil").fadeOut();
				});
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
    <%if(cart==null||cart.totalItem()==0){ %>
    <div class="empty_cart">Carrello vuoto</div>
    <%
    } 
    else {%>
    <h2 class="minghie">Carrello</h2>
		<table class="tabella">
		<tr>
			<th>Nome</th>
			<th>Colore</th>
			<th>Taglia</th>
			<th>Quantità</th>
			<th>Prezzo</th>
		</tr>
    <%ArrayList<TShirt> prodcart = cart.getProducts(); 
		   int k=0;
		   for(TShirt beancart: prodcart) {
			   k++;
			   String path="./Immagini/Magliette/Maglietta("+beancart.getidArticolo()+")";
			   if(beancart.getSesso().equalsIgnoreCase("F")){
				   path=path+"F.jpg";
			   }
			   else{
				   path=path+".jpg";
			   }
		%>
		<tr class="riga<%=k%>">
			<td class="colonna"><div><%=beancart.getnome()%></div>
			    <div><img class="maglietta" src=<%=path%>></div></td>
			<td class="colonna"><%=beancart.getColore()%></td>
			<td class="colonna"><%=beancart.getTaglia()%></td>
			<td class="colonna"><%=beancart.getquantita()%></td>
			<td class="colonna"><%=beancart.getprezzo()*beancart.getquantita()%> €</td>
		</tr>
		<%} %>
	</table>
    <div class="div_hidden" id="form">
        <form action="./?" method="post">
          <input type="hidden" name="action" value="saveCart">
          <label for="Nome" class="input">Nome</label>
          <div class="ui-widget">
          <input class="input" type="text" name="Nome">
          </div>
          <label for="Cognome" class="input">Cognome</label>
          <div class="ui-widget">
          <input class="input" type="text" name="Cognome">
          </div>
          <label for="Recapito" class="input">Recapito</label>
          <div class="ui-widget">
          <input class="input" type="text" name="Recapito">
          </div>
          <label for="citta" class="input">Città</label>
          <div class="ui-widget">
          <input id="tags" class="input" type="text" name="citta">
          </div>
          <label for="Indirizzo" class="input">Indirizzo</label>
          <div class="ui-widget">
          <input class="input" type="text" name="Indirizzo">
          </div>
          <label for="CAP" class="input">CAP</label>
          <div class="ui-widget">
          <input class="input" type="text" name="CAP">
          </div>
          <div class="metododipagamento">
                    <div> Seleziona il metodo di pagamento:</div>
                    <select name="Payment" class="Payment">
                        <option value="1">MasterCard</option>
                        <option value="2">Visa</option>
                        <option value="3">PayPal</option>
                        <option value="4">postepay</option>
                        <option value="5">Maestro</option>
                        <option value="6">American Express</option>
                        <option value="7">Discover</option>
                        <option value="8">Aura</option>
                    </select>
                    <div class="Numerocarta">
                    <label for="NumeroCarta" class="input">Numero carta</label>
                    <div class="ui-widget">
                    <input class="input" type="text" name="NumeroCarta"> 
                    </div>
                    <label for="NomeUtente" class="hidden">Nome Utente</label>
                    <div class="ui-widget">
                    <input class="hidden" type="text" name="nomeutente"> 
                    </div>
                    <label for="Password" class="hidden">Password</label>
                    <div class="ui-widget">
                    <input class="hidden" type="text" name="password"> 
                          </div>                          
                    </div>
                </div>
                <button class="input" type="button" onclick="showfattura();">Confermare i dati?</button>
                <%@include file="fattura.jsp" %>
        </form>
    </div>
    <%} %>
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