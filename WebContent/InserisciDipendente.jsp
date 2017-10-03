<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="UTF-8"%>
<%
	Boolean adminRoles = (Boolean) session.getAttribute("AdminDip");
	if ((adminRoles == null) || (!adminRoles.booleanValue()))
	{	
	 response.sendRedirect("./Management");
	 return;
	}
%>
 <%@page import="java.util.ArrayList,model.Dipendente,control.manage.ManageDipendente,control.manage.DbConnect" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" lang="it">
<head>
    <script src="Script/jquery.js"></script>
    <script src="Script/loadmore.js"></script>
    <link rel="icon" href="./Immagini/sprite0.png" />
    <style>
    @import url("./CSS/base.css");
    @import url("./CSS/home.css");
    @import url("./CSS/InserisciDipendente.css");
    @import url("./CSS/thumbnails.css");
    </style>
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
          Area Amministrazione
    </div>
      <div>
    <nav>    
            <ul id="Lista">
            <li><a href="./HomeDipendenti.jsp">Home</a> </li>
            <li><a href="./InserisciDipendente.jsp">Aggiungi Dipendente</a></li>
            <li><a href="./RimuoviDipendente.jsp">Rimuovi Dipendente</a> </li>
            <li><a href="./ModificaStipendio.jsp">Modifica Stipendio</a></li>
            <li><a href="./FlussoEconomico?tipo=2">Visualizza Flusso Economico</a></li>   
        </ul>
    </nav>
    </div>

<div id="sezione"> 
<div id="sezione2"> Aggiungi Dipendente</div></div>

<div id="form">
<form name="InsertDipendente" action="ServletInserisciDipendente" method="post" onsubmit="return validateForm()">
	<div>Nome</div>
	<input id="nome" type="text" name="nome">
	<div>Cognome</div>
	<input id="cognome" type="text" name="cognome">
	<div>Codice Fiscale</div>
	<input id="fiscale" type="text" name="codiceFiscale">
	<div>Stipendio</div> 
	<input id="stipendio" type="text" name="stipendio">
	<div>Tipo</div>
	<select id="tipo" name="tipo">
       <option  value="Magazzino" selected>Magazziniere</option>
       <option  value="Contabilita" selected>Contabile</option>
       </select>
	<div>Username</div>
	<input id="utente"  type="text" name="username">
	<div>Password</div>
	<input id="pssw" type="text" name="password">
	<br><div id="inserisci"><button id="submit" type="submit" onclick="ServletDipendente" onsubmit="return validateForm()">Inserisci</button></div>
</form>
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