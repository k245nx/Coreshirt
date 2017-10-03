<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
   Articolo product = (Articolo) request.getAttribute("product"); 
   Cart cart = (Cart) request.getAttribute("cart");
   Collection<?> items=(Collection<?>) request.getAttribute("productsM");
   Boolean adminRoles = (Boolean) session.getAttribute("adminRoles");
    if ((adminRoles == null) || (!adminRoles.booleanValue()))
      {	
        response.sendRedirect("./Login");
        return;
       }
%>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.Articolo,model.Cart"%>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" lang="it">
<head>
    <link rel="icon" href="Immagini/sprite0.png" />
    <link rel="stylesheet" href="CSS/base.css" type="text/css">
    <link rel="stylesheet" href="CSS/admin.css" type="text/css">
    <script src="Script/jquery.js"></script>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="it-IT" />
    <meta name="description" content="Il miglior sito dove acquistare T-Shirt  per qualsiasi gusto e necessità, con un'ampia scelta di modelli aggiornati periodicamente con i migliori design della rete." />
    <meta name="keywords" content="T-shirt, magliette, maglietta, nerd, cinema, divertenti, geek, core, series, best" />
    <title>Core Shirt: The Best T-Shirts series</title>
    <script>
    $(document).ready(function(){
    	$('.item').change(function(){
    		var num=$('.item').val();
    		$('.immagine').attr('src','Immagini/Magliette/Maglietta('+num+').jpg');
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
    <form name="fileupload" method="POST" enctype="multipart/form-data" action="./?">
                    <label for="title">Nome maglietta</label><input type="text" name="title" required>
                    <label for="categoria">Categoria</label>
                           <select name="categoria">
                             <option value="Cinema">Cinema</option>
                             <option value="Geek">Geek</option>
                             <option value="Divertenti">Divertenti</option>
                             <option value="Anime e Manga">Anime e Manga</option>
                             <option value="Comics">Comics</option>
                             <option value="Nerd">Nerd</option>
                           </select>
                    <input type="hidden" name="action" value="upload"/>
                    <label for="upfile">Percorso file locale</label><input type="file" name="upfile" placeholder="Nome file" required></input>
                    <input type="submit" ></input>
    </form>
    <form name="delete" method="post" action="./?">
       <input type="hidden" name="action" value="deleteItem">
       <select name="item" class="item">
         <%
            Iterator<?> it1=items.iterator();
            while(it1.hasNext()){
                  Articolo bean = (Articolo) it1.next();%>
            <option value="<%=bean.getidArticolo()%>">
               <%=bean.getnome()%>
            </option>
         <%}%>
       </select>
       <img class="immagine" alt="Seleziona una maglietta" src="/">
       <button type="submit">Cancella</button>
    </form>
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