
<div id="veil">
<div id="popup">Lista prodotti
		<table class="tabella">
		<tr>
			<th>Nome</th>
			<th>Colore</th>
			<th>Taglia</th>
			<th>Quantità</th>
		</tr>
    <%
		  if(articoli!=null){
		   for(TShirt beancart: articoli) {
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
		</tr>
		<%} }%>
	</table>
	<%if(c!=null){ %>
	<div id="Cliente">Cliente
	<table class="tabella">
		<tr>
			<th>Nome</th>
			<th>Cognome</th>
			<th>E-mail</th>
		</tr>
		<tr class="riga">
			<td class="colonna"><%=c.getNome()%></td>
			<td class="colonna"><%=c.getCognome()%></td>
			<td class="colonna"><%=c.getEmail()%></td>
		</tr>
	</table>
	</div>
	<%} %>
  <input type="button" class="chiudi" value="chiudi">
</div>
</div>