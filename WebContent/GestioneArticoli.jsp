<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="java.util.ArrayList,model.Articolo,control.manage.ManageArticolo,control.manage.DbConnect,java.sql.*" %>
 
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.Articolo,model.Cart"%>
<html lang="it">
<head>
    <script src="Script/jquery.js"></script>
    <script src="Script/loadmore.js"></script>
    <link rel="icon" href="./Immagini/sprite0.png" />
    <link rel="stylesheet" href="./CSS/base.css" type="text/css">
    <link rel="stylesheet" href="./CSS/home.css" type="text/css">
    <link rel="stylesheet" href="./CSS/thumbnails.css" type="text/css">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="it-IT" />
    <meta name="description" content="Il miglior sito dove acquistare T-Shirt  per qualsiasi gusto e necessità, con un'ampia scelta di modelli aggiornati periodicamente con i migliori design della rete." />
    <meta name="keywords" content="T-shirt, magliette, maglietta, nerd, cinema, divertenti, geek, core, series, best" />
    <title>Core Shirt Gestionale: Gestione Dipendenti</title>
    <script src="ajaxProdotti.js"></script>    
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
    <script src="checkForm.js"></script>

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

        </aside>
    
    </article>
        
    <article id="articolo">

    </article>
    <div id="corpo" align="center">
    	<br>
    	<h3>Inserisci Articolo</h3>
		<form name="InsertArticolo" method="post" enctype="multipart/form-data" action="ServletInsertArticolo">
			Nome<br>
			<input type="text" name="insertNome"/><br>
			Categoria<br>
			<select name="insertCategoria">
                             <option value="Cinema">Cinema</option>
                             <option value="Geek">Geek</option>
                             <option value="Divertenti">Divertenti</option>
                             <option value="Manga">Anime e Manga</option>
                             <option value="Comics">Comics</option>
                             <option value="Nerd">Nerd</option>
                           </select>
			Prezzo<br>
			<input type="text" name="insertPrezzo"/><br>
			Quantita<br>
			<input type="text" name="insertQuantita"/><br>
			<label for="upfile">Percorso file locale</label><input type="file" name="upfile" placeholder="Nome file" required></input>
			<br><input type="submit"  value="Inserisci Articolo">
		</form>

<h3>Modifica Articolo</h3>


<%
ManageArticolo ma=new ManageArticolo();
ArrayList<Articolo> articoli=ma.getArticoli();
	if(articoli.size()==0){
		out.print("<b>Non ci sono articoli</b");
		
	}else{

%>
<form name="manageArticolo">
<select name="idArticolo">
<%

for(int i=0;i<articoli.size();i++){ %>
	<option value="<%=articoli.get(i).getidArticolo()%>"><%=articoli.get(i).getidArticolo()%></option>
	<%}%>
</select><input type="submit" onclick="postComment()"><br><br>
</form>
<form action="GestisciArticolo" method="post">
<%
	String id=request.getParameter("idArticolo");
	if(id=="" || id==null){
		out.print("<b>Seleziona id</b>");
	}else{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coreshirt2","root","Freitag22*");
			PreparedStatement ps=con.prepareStatement("select * from articolo where idarticolo=?");
			ps.setInt(1,Integer.parseInt(id));
			ResultSet rs=ps.executeQuery();
			while(rs.next()){%>
					<input type="hidden" name="id" value="<%=rs.getInt("idarticolo")%>">
					Id<input type="text" name="id" value="<%=rs.getInt("idarticolo")%>" readonly><br><br>
				Nome<input type="text" name="nome" value="<%=rs.getString("nome")%>"><br><br>
				Categoria<input type="text" name="categoria" value="<%=rs.getString("categoria")%>"><br><br>
				Prezzo<input type="text" name="prezzo" value="<%=rs.getDouble("prezzo")%>"><br><br>
				Quantità<input type="text" name="quantita" value="<%=rs.getString("quantita")%>"><br><br>
				<input type="submit" value="Modifica Articolo" onclick="GestisciArticolo">
				<button type="submit" name="rimuoviArticolo" value="<%=rs.getInt("idarticolo")%>" onclick="GestisciArticolo">Elimina Articolo</button>
				
				

			<%}%>
			
		<% }catch(Exception e){
			out.print(e);
		}
	}
}
%>
</form>
        </div>

          <img id="loadMore" src="Immagini/arrow.png">
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