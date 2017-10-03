<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="UTF-8"%>
<% Collection<?> articoli=(Collection<?>) session.getAttribute("articoli"); 
   Boolean adminRoles = (Boolean) session.getAttribute("Magazzino");
   if ((adminRoles == null) || (!adminRoles.booleanValue()))
     {	
      response.sendRedirect("./Management");
      return;
     }
%>
 <%@page import="java.util.*,model.Articolo,control.manage.ManageDipendente,control.manage.DbConnect" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" lang="it">
<head>
    <script src="Script/jquery.js"></script>
    <script src="Script/loadmore.js"></script>
    <link rel="icon" href="./Immagini/sprite0.png" />
    <link rel="stylesheet" href="./CSS/base.css" type="text/css">
    <link rel="stylesheet" href="./CSS/home.css" type="text/css">
    <link rel="stylesheet" href="./CSS/InserisciDipendente.css" type="text/css">
    <link rel="stylesheet" href="./CSS/ModificaQuantitaProdotto.css" type="text/css">
    <link rel="stylesheet" href="./CSS/RifornimentoProdotto.css" type="text/css">
    <link rel="stylesheet" href="./CSS/thumbnails.css" type="text/css">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="it-IT" />
    <meta name="description" content="Il miglior sito dove acquistare T-Shirt  per qualsiasi gusto e necessità, con un'ampia scelta di modelli aggiornati periodicamente con i migliori design della rete." />
    <meta name="keywords" content="T-shirt, magliette, maglietta, nerd, cinema, divertenti, geek, core, series, best" />
    <title>Core Shirt: The Best T-Shirts series</title>
    <script type="text/javascript">
    $(document).ready(function(){
    	$("#anteprima").hide();
    	$('#insertarticolo').change(function(){
    		var num=$('#insertarticolo').val();
    		$('#anteprima>img').attr('src','Immagini/Magliette/Maglietta('+num+').jpg');
    		$('#anteprima').show();
    	})
    })
    </script>
</head>
<body>


<div>     
    <article id="articolo" >
		<script src="checkForm.js"></script>

<%!/*
ManageDipendente md=new ManageDipendente();
ArrayList<Dipendente> dipendenti=md.getDipendenti(); */
%>

<article>
<div id="wrapper">
    <article id="articolo1">
    
    <a href="./"><div id="banner"> <img class="Banner" src="Immagini/prova.png"> 
          <img class="core" src="Immagini/core2.png"></div></a>
 
     </article>
       </div>
        
    <article id="ArticleInserisciDipendente">
    <div id="Amministrazione">
          Area Magazzino
    </div>
      <div>
    <nav>    
            <ul id="Lista">
            <li><a href="./HomeMagazzino.jsp">Home</a> </li>
            <li><a href="./InserisciProdotto.jsp">Inserisci Prodotti</a></li>
            <li><a href="./RimuoviProdotto.jsp">Rimuovi Prodotti</a> </li>
            <li><a href="./EvadiOrdine.jsp">Evadi Ordini</a></li>
            <li><a href="./ModificaQuantita.jsp">Modifica Quantità</a></li>   
            <li><a href="./RifornimentoProdotto.jsp">Rifornimento Prodotti</a></li>
 
        </ul>
    </nav>
    </div>

<div id="sezione"> 
<div id="sezione2">Modifica Quantita Prodotto </div></div>

<div id="form">
<form name="AggiungiPezzi" action="ServletTShirt" method="post">
	
	
	<div>Seleziona Articolo</div>
	<select id="insertarticolo" name="insertarticolo">
       <%
       Iterator<?> it1=articoli.iterator();
          while(it1.hasNext()){
                  Articolo bean = (Articolo) it1.next();%>
            <option value="<%=bean.getidArticolo()%>">
               <%=bean.getidArticolo()%>
            </option>
         <%}%>
   </select><br>
   <div>Seleziona Sesso</div>
	<select id="sesso" name="sesso">
	           <option value="M">Uomo</option>
		       <option value="F">Donna</option>
	</select>
   <div>Seleziona Colore</div>
	<select id="colore" name="colore">
               <option value="black">Nero</option>
		       <option value="grey">Grigio</option>
		       <option value="white">Bianco</option>
		       <option value="green">Verde</option>
		       <option value="orange">Arancio</option>
		       <option value="red">Rosso</option>
		       <option value="purple">Viola</option>
		       <option value="blue">Blu</option>
   </select><br>
   <div>Seleziona Taglia</div>
	<select id="taglia" name="taglia">
               <option value="S">S</option>
		       <option value="M">M</option>
		       <option value="L">L</option>
		       <option value="XL">XL</option>
		       <option value="XXL">XXL</option>
		       <option value="3XL">3XL</option>
		       <option value="4XL">4XL</option>
		       <option value="5XL">5XL</option>
   </select><br>
	<div>Quantità</div>
    <input type="text" name="insertQuantita"/><br>
	<br><div id="modifica"><button id="submit" type="submit">Modifica</button></div>
</form>
</div>
<div id="anteprima">
    <img alt="seleziona articolo" src="0.png">
</div>
<br>
</article>
</article>
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