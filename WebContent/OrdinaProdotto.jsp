<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="UTF-8"%>
    
<%
   ArrayList<?> rif=(ArrayList<?>)session.getAttribute("rifornimenti");
   Dipendente idDip=(Dipendente)session.getAttribute("DipendenteSession");
%>
<%
	Boolean adminRoles = (Boolean) session.getAttribute("Contabile");
	if ((adminRoles == null) || (!adminRoles.booleanValue()))
	{	
	 response.sendRedirect("./Management");
	 return;
	}
%>
 <%@page import="java.util.*,model.Rifornimento,model.Dipendente,control.manage.ManageDipendente,control.manage.DbConnect" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" lang="it">
<head>
    <script src="Script/jquery.js"></script>
    <script src="Script/loadmore.js"></script>
    <link rel="icon" href="./Immagini/sprite0.png" />
    <link rel="stylesheet" href="./CSS/base.css" type="text/css">
    <link rel="stylesheet" href="./CSS/home.css" type="text/css">
    <link rel="stylesheet" href="./CSS/InserisciDipendente.css" type="text/css">
    <link rel="stylesheet" href="./CSS/OrdinaProdotto.css" type="text/css">
    <link rel="stylesheet" href="./CSS/thumbnails.css" type="text/css">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="it-IT" />
    <meta name="description" content="Il miglior sito dove acquistare T-Shirt  per qualsiasi gusto e necessità, con un'ampia scelta di modelli aggiornati periodicamente con i migliori design della rete." />
    <meta name="keywords" content="T-shirt, magliette, maglietta, nerd, cinema, divertenti, geek, core, series, best" />
    <title>Core Shirt: The Best T-Shirts series</title>
    <script>
       $(document).ready(function() {
		  $(".dettaglir").hide();
		  $("#Richieste").change(function(){
			  var r=$("#Richieste").val();
			  $(".dettaglir").hide();
			  $("#dettagliR"+r).show();
		  })
		});
	</script>
</head>
<body>


<div>     
    <article id="articolo" >
		<script src="checkForm.js"></script>

<article>
<div id="wrapper">
    <article id="articolo1">
    
    <a href="./"><div id="banner"> <img class="Banner" src="Immagini/prova.png"> 
          <img class="core" src="Immagini/core2.png"></div></a>
 
     </article>
       </div>
        
    <article id="ArticleInserisciDipendente">
    <div id="Amministrazione">
          Area Contabilita
    </div>
      <div>
    <nav>    
            <ul id="Lista">
            <li><a href="./HomeContabile.jsp">Home</a> </li>
            <li><a href="./OrdinaProdotto.jsp">Ordina Prodotti</a></li>
            <li><a href="./AggiungiSpesa.jsp">Aggiungi Spesa</a> </li>
            <li><a href="./FlussoEconomico?tipo=1">Visualizza Flusso Economico</a></li>
            <li><a href="./PagaStipendi.jsp">Paga Stipendi</a></li>   
        </ul>
    </nav>
    </div>

<div id="sezione"> 
<div id="sezione2"> Ordina Prodotto </div></div>
<div id="rifornimento">
   <form id="rifornimento2" action="ServletRifornimento" method="post">
      <input type="hidden" name="evadi" value="1">
      Seleziona Richiesta 
      <select id="Richieste" name="richiesta">
      <%
       Iterator<?> it1=rif.iterator();
          while(it1.hasNext()){
                  Rifornimento bean = (Rifornimento) it1.next();%>
            <option value="<%=bean.getIdRifornimento()%>">
               <%=bean.getIdRifornimento()%>
            </option>
         <%}%>
      </select>
      <button id="evadi" type="submit">Evadi</button>
      <%int K=1; 
      it1=rif.iterator();
      while(it1.hasNext()){
          Rifornimento bean = (Rifornimento) it1.next();
          String path="./Immagini/Magliette/Maglietta("+bean.getTshirt().getidArticolo()+").jpg";%>
          <div id="dettagliR<%=K%>" class="dettaglir">
               <table>
                  <th>Maglia</th>
                  <th>Sesso</th>
                  <th>Taglia</th>
                  <th>Colore</th>
                  <th>Quantita</th>
                  <tr>
                     <td><div><img class="maglietta" src=<%=path%>></div></td></td>
                     <td><%=bean.getTshirt().getSesso() %></td>
                     <td><%=bean.getTshirt().getTaglia() %></td>
                     <td><%=bean.getTshirt().getColore() %></td>
                     <td><%=bean.getTshirt().getquantita()%></td>
                  </tr>
               </table>
          </div>
     <%K++;
     }%>
   </form>
</div>
<div id="form">
<form name="InsertProdotto" action="ServletInsertArticolo" enctype="multipart/form-data" method="post">
	<input type="hidden" name="rifornimento" value="1">
	<input type="hidden" name="id" value="<%=idDip.getId()%>">
	Inserisci il Nome
	<input id="nome" type="text" name="insertNome"><br>
	
	Seleziona Categoria
	<select id="tipo" name="insertCategoria">
                             <option value="Cinema">Cinema</option>
                             <option value="Geek">Geek</option>
                             <option value="Divertenti">Divertenti</option>
                             <option value="Manga">Anime e Manga</option>
                             <option value="Comics">Comics</option>
                             <option value="Nerd">Nerd</option>
   </select><br>
   
   Seleziona Sesso
   			<select id="sesso" name="sesso">
		       <option value="M">Uomo</option>
		       <option value="F">Donna</option>
   			</select> 
   			<br/>
     Inserisci Quantita
	<input id="Quantita" type="number" name="insertQuantita"><br>
	
   Seleziona Colore
	<select id="tipo" name="colore">
    <option value="black">Nero</option>
		       <option value="grey">Grigio</option>
		       <option value="white">Bianco</option>
		       <option value="green">Verde</option>
		       <option value="orange">Arancio</option>
		       <option value="red">Rosso</option>
		       <option value="purple">Viola</option>
		       <option value="blue">Blu</option>
   </select><br>
   Seleziona Taglia
	<select id="tipo" name="taglia">
	<option value="S">S</option>
	<option value="M">M</option>
	<option value="L">L</option>
	<option value="XL">XL</option>
	<option value="XXL">XXL</option>
	<option value="3XL">3XL</option>
	<option value="4XL">4XL</option>
	<option value="5XL">5XL</option>
   </select><br>
	
	
	<br><button id="submit" type="submit" onclick="ServletProdotto" onsubmit="return validateForm()">Ordina  </button>
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