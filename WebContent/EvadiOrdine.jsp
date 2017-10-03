<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="UTF-8"%>
<%
    ArrayList<TShirt> articoli=(ArrayList<TShirt>) session.getAttribute("listaArticoli");
    Cliente c=(Cliente) session.getAttribute("Cliente");
    Boolean adminRoles = (Boolean) session.getAttribute("Magazzino");
    if ((adminRoles == null) || (!adminRoles.booleanValue()))
      {	
       response.sendRedirect("./Management");
       return;
      }
%>
 <%@page import="java.util.*,model.Ordine,model.Cliente,model.TShirt,control.manage.ManageOrdine,control.manage.DbConnect" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml" lang="it">
<head>
    <script src="Script/jquery.js"></script>
    <script src="Script/loadmore.js"></script>
    <link rel="icon" href="./Immagini/sprite0.png" />
    <link rel="stylesheet" href="./CSS/base.css" type="text/css">
    <link rel="stylesheet" href="./CSS/home.css" type="text/css">
    <link rel="stylesheet" href="./CSS/InserisciDipendente.css" type="text/css">
    <link rel="stylesheet" href="./CSS/EvadiOrdine.css" type="text/css">
    <link rel="stylesheet" href="./CSS/thumbnails.css" type="text/css">
    <link rel="stylesheet" href="./CSS/Magazzino.css" type="text/css">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="it-IT" />
    <meta name="description" content="Il miglior sito dove acquistare T-Shirt  per qualsiasi gusto e necessità, con un'ampia scelta di modelli aggiornati periodicamente con i migliori design della rete." />
    <meta name="keywords" content="T-shirt, magliette, maglietta, nerd, cinema, divertenti, geek, core, series, best" />
    <title>Core Shirt: The Best T-Shirts series</title>
    <script type="text/javascript">
       $(document).ready(function(){
    	   $("#popup").hide();
    	   $("#veil").hide();
    	   $(".chiudi").click(function(){
    			$("#popup").hide();
    		$("#veil").fadeOut();
    	    });
    	   $(".dettagli").click(function(){
    		   var k=this.getAttribute("id");
    		   var o=$("#ordine"+k).val();
        	   var c=$("#cliente"+k).val();
        	   var a="GestisciOrdine?dettagli=1&idOrdine="+o+"&idCliente="+c;
        	   $.ajax({
       			type:"get",
       			url: a,
       			success:function(result){
       				$('#popup>table').load("./EvadiOrdine.jsp #popup>table");
       				$("#popup").show();
        	    	$("#veil").fadeIn();
       			}  
    	   })
   		})
       })
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
    <div id="corpo" align="center">
    	<br>
		<h3>Gestione Ordini</h3>
		<%
			ManageOrdine mo=new ManageOrdine();
			ArrayList<Ordine> ordini=mo.getInevasi();//Per provare il css mettere mo.getOrdini();
		%>
			<table>
			<tr>
			<th>Id Ordine</th>
			<th>Stato</th><br>
			<th>Data</th><br>
			<th>Indirizzo Spedizione</th>
			<th>Totale</th>
			</tr>
			<%for(int i=0;i<ordini.size();i++){%>
			<form  action="GestisciOrdine"  method="post">
			<tr>
			<td><%=ordini.get(i).getIdOrdine()%></td>
			<td>
			<input id="ordine<%=i%>" type="hidden" name="idOrdine" value="<%=ordini.get(i).getIdOrdine()%>" >
			<input id="cliente<%=i%>" type="hidden" name="idCliente" value="<%=ordini.get(i).getIdCliente()%>" >
			<%=ordini.get(i).getStato()%></td>
			<td><%=ordini.get(i).getData()%></td>
			<td><%=ordini.get(i).getIndirizzoSpedizione()%></td>
			<td><%=ordini.get(i).getTotale()%></td>
			<td><button id="evadi" type="submit" name="cambiaStato" value="true">evadi</button></td>
			<td><button class="dettagli" id="<%=i%>"type="button" >dettagli</button></td>
			</tr>
			</form>
			
			<%}%>
			</table>
	</div>
	<%int k=0;%>
    <%@include file="dettagliordine.jsp" %>
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