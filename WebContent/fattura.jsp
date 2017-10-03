
<div id="veil">
<div id="popup">
		<table class="tabella">
		<tr>
			<th>Nome</th>
			<th>Colore</th>
			<th>Taglia</th>
			<th>Quantità</th>
			<th>Totale</th>
		</tr>
    <%
		   k=0;
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
			<td class="colonna"><div><%=beancart.getnome()%></div>
			    <div><img class="maglietta" src=<%=path%>></div></td>
			<td class="colonna"><%=beancart.getColore()%></td>
			<td class="colonna"><%=beancart.getTaglia()%></td>
			<td class="colonna"><%=beancart.getquantita()%></td>
			<td class="colonna"><%=beancart.getprezzo()*beancart.getquantita()%> &euro;</td>
		</tr>
		<%} %>
	</table>
   <div id="totale">totale : <%=cart.getTotal()%> &euro;</div>
   <div>Gli articoli saranno spediti in 3-5giorni lavorativi</div>
  <input type="submit" class="submit" value="Acquista">
  <input type="button" class="submit" id="chiudi" value="Chiudi">
</div>
</div>