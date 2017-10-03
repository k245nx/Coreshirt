<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@page
	import="java.util.ArrayList,model.Dipendente,control.ManageDipendente,control.DbConnect"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:v="urn:schemas-microsoft-com:vml" lang="it">
<head>
<script src="Script/jquery.js"></script>
<script src="Script/loadmore.js"></script>
<link rel="icon" href="./Immagini/sprite0.png" />
<link rel="stylesheet" href="./CSS/base.css" type="text/css">
<link rel="stylesheet" href="./CSS/home.css" type="text/css">
<link rel="stylesheet" href="./CSS/VisualizzaFlussoEconomico.css" type="text/css">
<link rel="stylesheet" href="./CSS/thumbnails.css" type="text/css">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="it-IT" />
<meta name="description"
	content="Il miglior sito dove acquistare T-Shirt  per qualsiasi gusto e necessità, con un'ampia scelta di modelli aggiornati periodicamente con i migliori design della rete." />
<meta name="keywords"
	content="T-shirt, magliette, maglietta, nerd, cinema, divertenti, geek, core, series, best" />
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
		<article id="articolo">
			<script src="checkForm.js"></script>

			<%!/*
ManageDipendente md=new ManageDipendente();
ArrayList<Dipendente> dipendenti=md.getDipendenti(); */
%>

			<article>
				<div id="wrapper">
					<article id="articolo1">

						<a href="./"><div id="banner">
								<img class="Banner" src="Immagini/prova.png"> <img
									class="core" src="Immagini/core2.png">
							</div></a>

					</article>
				</div>

				<article id="ArticleInserisciDipendente">
					<div id="Amministrazione">Area Contabilità</div>
					<div>
						<nav>
							<ul id="Lista">
								<li><a href="./HomeDipendenti.jsp">Home</a> </li>
                                <li><a href="./InserisciDipendente.jsp">Ordina Prodotti</a></li>
            					<li><a href="./RimuoviDipendente.jsp">Aggiungi Spesa</a> </li>
            					<li><a href="./ModificaStipendio.jsp">V Flusso Economico</a></li>
            					<li><a href="./VisualizzaFlussoEconomico.jsp">Aggiungi Straordinari</a></li>
							</ul>
						</nav>
					</div>

					<div id="sezione">
						<div id="sezione2">Visualizza Flusso Economico</div>
					</div>
					<div id="containerTab">
						<table id="table">

							<tr>
								<td id="Flusso">Elenco Entrate</td>
								<td>                        </td>
								<td id="Flusso">Elenco Uscite</td>
							</tr>
							<tr>
								<td><div class="box">
										<div class="box-inner">il contenuto qui</div>
										<div class="box-inner">il contenuto qui</div>
										<div class="box-inner">il contenuto qui</div>
										<div class="box-inner">il contenuto qui</div>
										<div class="box-inner">il contenuto qui</div>
										<div class="box-inner">il contenuto qui</div>
										<div class="box-inner">il contenuto qui</div>
									</div></td>
									<td>                          </td>
								<td><div class="box">
										<div class="box-inner">il contenuto qu  2i</div></td>
							</tr>
						</table>
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
								© 2016 Core Shirt S.R.L | P. IVA 01594368721<br> All
								designs copyright by owner.<br> <a href="">Privacy
									Policy</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>