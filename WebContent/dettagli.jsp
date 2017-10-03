<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Collection<?> products = (Collection<?>) request.getAttribute("products");
   Articolo product = (Articolo) request.getAttribute("product"); 
   Object quantita=request.getSession().getAttribute("disponibilita");
   Cart cart = (Cart) request.getAttribute("cart");
   Object aggiunto=request.getSession().getAttribute("aggiunto");
   %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.Articolo,model.Cart"%>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" lang="it">
<head>
    <link rel="icon" href="./Immagini/sprite0.png" />
    <link rel="stylesheet" href="./CSS/base.css" type="text/css">
    <link rel="stylesheet" href="./CSS/Dettagli.css" type="text/css">
    <script src="Script/jquery.js"></script>
    <script src="Script/control.js"></script>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="it-IT" />
    <meta name="description" content="Il miglior sito dove acquistare T-Shirt  per qualsiasi gusto e necessità, con un'ampia scelta di modelli aggiornati periodicamente con i migliori design della rete." />
    <meta name="keywords" content="T-shirt, magliette, maglietta, nerd, cinema, divertenti, geek, core, series, best" />
    <title>Core Shirt: The Best T-Shirts series</title>
    <script type="text/javascript">
    function ParseQueryString() {
        var result =0;
        var strQS = window.location.href;
        var index = strQS.indexOf("?");
        if (index > 0) {
            var temp = strQS.split("?");
            var arrData = temp[1].split("&");
            var x="aa"+arrData+"aa";
            if(x === "aaaa")
            	return "1";
        }
        return result;
    }
        $(document).ready(function(){
        	var QS = ParseQueryString();
            if (QS === "1") {
            	$("#popup").show();
            	$("#veil").fadeIn();
            	setTimeout(function(){$("#popup").fadeOut();$("#veil").fadeOut();}, 2000);
            }
            else{
        	$("#popup").hide();}
            $(".disponibilita").hide();
            $(".colore").click(function(){
            	var colore=$('.colore:checked').val();
                var taglia=$('.taglia:checked').val();
                if(taglia!=null&&colore!=null){
                	var k=$( "input[name='id']" ).val();
                	var b=$( "input[name='sesso']" ).val();
                	var c=$( "input[name='nome']" ).val();
                	var f=$( "input[name='prezzo']" ).val();
                	 var a="./?action=disponibilita&id="+k+"&sesso="+b+"&nome="+c+"&color="+colore+"&taglia="+taglia+"&prezzo="+f+"&quantity="+1;
                	 $.ajax({
                			type:"get",
                			url: a,
                			success:function(result){
                				$(".disponibilita").load("./dettagli.jsp .disponibilita");
                			    $(".disponibilita").show();
                			}  
             	   })
                }
            });
            $(".taglia").click(function(){
            	var colore=$('.colore:checked').val();
                var taglia=$('.taglia:checked').val();
                if(taglia!=null&&colore!=null){
                	var k=$( "input[name='id']" ).val();
                	var b=$( "input[name='sesso']" ).val();
                	var c=$( "input[name='nome']" ).val();
                	var f=$( "input[name='prezzo']" ).val();
                	 var a="./?action=disponibilita&id="+k+"&sesso="+b+"&nome="+c+"&color="+colore+"&taglia="+taglia+"&prezzo="+f+"&quantity="+1;
                	 $.ajax({
                			type:"get",
                			url: a,
                			success:function(result){
                				$(".disponibilita").load("./dettagli.jsp .disponibilita");
                			    $(".disponibilita").show();
                			}  
             	   })
                }
            })
            
        })
        function changeColor(color)
        {
            var styl=document.styleSheets[1]
            var rules=styl.cssRules? styl.cssRules: styl.rules
            for (i=0; i<rules.length; i++){
            if(rules[i].selectorText.toLowerCase()==".maglia"){
                rules[i].style.backgroundColor=color
                break;
                }
            }   
        }
        function show(){
        	$("#popup").hide();
        }
    </script>
</head>
<body>
<%@include file="PopUp.jsp" %>
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
        <div class="container-di-tutto">
        <%if(product!=null) {%>
            <div class="maglia" ><img src="Immagini/Magliette/TiziM.png">
                <img class="design-left" src="./Immagini/Magliette/<%=product.getidArticolo()%>.png">
                <img class="design-right" src="./Immagini/Magliette/<%=product.getidArticolo()%>.png">
            </div>
            <div class="scegli-colore">
                
                <form onsubmit="return control()" action="./?" method="post">
                  <input type="hidden" name="action" value="addC">
                  <input type="hidden" name="id" value="<%=product.getidArticolo()%>">
                  <input type="hidden" name="sesso" value="<%=product.getSesso()%>">
                 <input type="hidden" name="nome" value="<%=product.getnome()%>">
              <div>
                 <p class="par">Dettagli</p>
              </div>
              <div class="nome-maglia"><%=product.getnome()%></div>
                <div class="dettagli">
                    <input type="radio" name="color" value="black" class="colore" onclick="changeColor('#000000');">
                    <label for="colore"><span style="background-image : linear-gradient(rgb(22,22,22),rgb(22,22,22));"><span></span></span> </label>
                    
                    
             
                    <input type="radio" name="color" value="grey" class="colore"
                           onclick="changeColor('#454449');">
                    <label for="colore"><span style="background-image : linear-gradient(rgb(97,97,97),rgb(97,97,97));"><span></span></span> </label>
                    
                    
                    
                    <input type="radio" name="color" value="white" class="colore"
                           onclick="changeColor('#F8F8F8');">
                    <label for="colore"><span style="background-image : linear-gradient(rgb(250,250,250),rgb(250,250,250));"><span></span></span> </label>
                    
                    <input type="radio" name="color" value="green" class="colore"
                           onclick="changeColor('#037302');">
                    <label for="colore"><span style="background-image : linear-gradient(rgb(7,128,7),rgb(7,128,7));"><span></span></span> </label>
                    
                    
                    <input type="radio" name="color" value="orange" class="colore"
                           onclick="changeColor('#F37B1C');">
                    <label for="colore"><span style="background-image : linear-gradient(rgb(243,131,33),rgb(243,131,33));"><span></span></span> </label>
                    
                    
                    <input type="radio" name="color" value="red" class="colore" onclick="changeColor('#C21111');">
                    <label for="colore"><span style="background-image : linear-gradient(rgb(197,17,17),rgb(197,17,17));"><span></span></span> </label>
                    
                    
                    <input type="radio" name="color" value='purple' class="colore" onclick="changeColor('#665098');">
                    <label for="colore"><span style="background-image : linear-gradient(rgb(102,80,152),rgb(102,80,152));"><span></span></span> </label>
                    
                    
                    <input type="radio" name="color" value="blue" class="colore" onclick="changeColor('#0E73DB');">
                    <label for="colore"><span style="background-image : linear-gradient(rgb(14,115,219),rgb(14,115,219));"><span></span></span> </label>
                    
                    
                </div>
                <div class="details">
                    <div class="descriptor">Seleziona la taglia:</div>
                    <input type="radio" name="taglia" value='S' class="taglia">
                    <label for="taglia"><span style="background-image : linear-gradient(rgb(255,250,245),rgb(255,250,245));"><span></span><p>S</p></span> </label>
                    
                    <input type="radio" name="taglia" value='M' class="taglia">
                    <label for="taglia"><span style="background-image : linear-gradient(rgb(255,250,245),rgb(255,250,245));"><span></span><p>M</p></span> </label>
                    
                    <input type="radio" name="taglia" value='L' class="taglia">
                    <label for="taglia"><span style="background-image : linear-gradient(rgb(255,250,245),rgb(255,250,245));"><span></span><p>L</p></span> </label>
                    
                    <input type="radio" name="taglia" value='XL' class="taglia">
                    <label for="taglia"><span style="background-image : linear-gradient(rgb(255,250,245),rgb(255,250,245));"><span></span><p>XL</p></span> </label>
                    
                    <input type="radio" name="taglia" value='XXL' class="taglia">
                    <label for="taglia"><span style="background-image : linear-gradient(rgb(255,250,245),rgb(255,250,245));"><span></span><p>XXL</p></span> </label>
                    
                    <input type="radio" name="taglia" value='3XL' class="taglia">
                    <label for="taglia"><span style="background-image : linear-gradient(rgb(255,250,245),rgb(255,250,245));"><span></span><p>3XL</p></span> </label>
                    
                    <input type="radio" name="taglia" value='4XL' class="taglia">
                    <label for="taglia"><span style="background-image : linear-gradient(rgb(255,250,245),rgb(255,250,245));"><span></span><p>4XL</p></span> </label>
                    
                    <input type="radio" name="taglia" value='5XL' class="taglia">
                    <label for="taglia"><span style="background-image : linear-gradient(rgb(255,250,245),rgb(255,250,245));"><span></span><p>5XL</p></span> </label>
                    </div>
                <div class="numpezzi">
                    <div> Seleziona la quantità:</div>
                    <select name="quantity">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                    </select>
                </div>
                <div class="price">
                    <input type="hidden" name="prezzo" value="12" class="price-hidden"><label for="price-hidden">12,00 €</label>
                </div>
                <div class="submit-button">
                    <button class="submit" ><img src="Immagini/white-cart.png"><div>Aggiungi al carrello!</div></button> 
                </div>
                </form>
            </div>
             <%} %>
            <div class="disponibilita">disponibilità: <%=quantita%></div>
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