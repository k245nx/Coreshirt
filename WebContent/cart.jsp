<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% Collection<?> productsM = (Collection<?>) request.getAttribute("productsM");
   Articolo product = (Articolo) request.getAttribute("product"); 
   Cart cart = (Cart) request.getAttribute("cart");%>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.Articolo,model.TShirt,model.Cart"%>
<head>
    <link rel="icon" href="Immagini/sprite0.png" />
    <script src="Script/jquery.js"></script>
    <script src="Script/update.js"></script>
    <link rel="stylesheet" href="CSS/base.css" type="text/css">
    <link rel="stylesheet" href="CSS/Cart.css" type="text/css">
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

<div id="contenitore">
 <% String x=""+cart.getTotal();
    x=x.substring(0,x.length()-2);
     if(cart != null && cart.getProducts().size()>0) { %>
		<h2 class="minghie">Carrello</h2>
		<table class="tabella">
		<tr>
			<th>Name</th>
			<th>Color</th>
			<th>Size</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Action</th>
		</tr>
		<% ArrayList<TShirt> prodcart = cart.getProducts(); 
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
		    <input type="hidden" class="id" value="<%=beancart.getidArticolo()%>"/>
		    <input type="hidden" class="sex" value="<%=beancart.getSesso()%>"/>
		    <input type="hidden" class="tg1" value="<%=beancart.getTaglia()%>"/>
		    <input type="hidden" class="color" value="<%=beancart.getColore()%>"/>
			<td class="colonna"><div><%=beancart.getnome()%></div>
			    <div><img class="maglietta" src=<%=path%>></div></td>
			<td class="colonna"><%=beancart.getColore()%></td>
			<td class="colonna"><select class="taglia" id="<%=k%>">
                        <%String tg="";
                           for(int i=0;i<8;i++){
                        	   switch(i){
                        	   case 0:tg="S";break;
                        	   case 1:tg="M";break;
                        	   case 2:tg="L";break;
                        	   case 3:tg="XL";break;
                        	   case 4:tg="XXL";break;
                        	   case 5:tg="3XL";break;
                        	   case 6:tg="4XL";break;
                        	   case 7:tg="5XL";break;
                        	   }
                               if(tg.equalsIgnoreCase(beancart.getTaglia())){%>
                               <option value="<%=tg%>" selected><%=tg%></option>
                        <%}
                               else{
                            	   %>
                               <option value="<%=tg%>"><%=tg%></option>
                            	   <%
                               }
                        }%>
                         </select>
                       </td>
			<td class="colonna">
			    <select class="pezzi" id="<%=k%>">
			        <%for(int i=1;i<=12;i++){ 
			              if(i==beancart.getquantita()){%>
			              <option value="<%=beancart.getquantita()%>" selected><%=beancart.getquantita()%></option>
			             <%}
			              else{%> 
			              <option value="<%=i%>"><%=i%></option>     
			              <%}
			             }%>
			    </select>
			</td>
			<td class="colonna" id="prezzo"><%=beancart.getprezzo()%></td>
			<td class="colonna" id="rimozione"><a href="./?action=deleteC&id=<%=beancart.getidArticolo()%>&sesso=<%=beancart.getSesso()%>&taglia=<%=beancart.getTaglia()%>&color=<%=beancart.getColore()%>">Remove</a></td>
		</tr>
		<%} %>
	</table>		
	<table id="subtotal">
	<tr>
	    <th class="subtotale-header"> Subtotale </th>
	</tr>
	<tr id="prima-riga">
	<td><div class="label">Costi di spedizione:</div>
	<div class="labelfriend"><%=cart.getShipmentString()%></div>          </td>
	</tr>
	<tr id="seconda-riga">
	<td><div class="label2">Totale del tuo ordine:</div>
	<div class="labelfriend2"><%=x+",00 €"%></div>          </td>
	</tr>
	<tr>
	<td><div class="conferma">Conferma il tuo ordine</div>        
	</td>
	</tr>
	<tr>
	<td><img class="creditcard" src="Immagini/CreditCard2.jpg">        
	</td>
	</tr>
	</table>
	<% } 
     else{
	%>
	<div>Carrello vuoto</div>
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