<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList,model.Dipendente,control.manage.ManageDipendente,control.manage.DbConnect,java.sql.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prova Ajax</title>
<script src="ajaxs.js"></script>
</head>
<body>
<form name="manageDipendente" >
<select name="idDipendente">
<%
	ManageDipendente md=new ManageDipendente();
	ArrayList<Dipendente> dipendenti=md.getDipendenti();

for(int i=0;i<dipendenti.size();i++){ %>
	<option value="<%=dipendenti.get(i).getId()%>"><%=dipendenti.get(i).getId()%></option>
	<%}%>
</select><input type="submit" onclick="postComment()"><br><br>
</form>
<form action="GestisciDipendente" method="post">
<%
	String id=request.getParameter("idDipendente");
	if(id=="" || id==null)
		out.print("<b>inserisci id</b>");
	else{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coreshirt","root","kalibandulu");
			PreparedStatement ps=con.prepareStatement("select * from dipendente where idDipendente=?");
			ps.setInt(1,Integer.parseInt(id));
			ResultSet rs=ps.executeQuery();
			while(rs.next()){%>
				
					<input type="hidden" name="id" value="<%=rs.getInt("idDipendente")%>">
				
				Nome<input type="text" name="nome" value="<%=rs.getString("nome")%>"><br><br>
				
				Cognome<input type="text" name="cognome" value="<%=rs.getString("cognome")%>"><br><br>
				CodF<input type="text" name="cf" value="<%=rs.getString("codicefiscale")%>"><br><br>
				Stipendio<input type="text" name="stipendio" value="<%=rs.getString("stipendio")%>"><br><br>
				Tipo<input type="text" name="tipo" value="<%=rs.getString("tipo")%>"><br><br>
				Username<input type="text" name="username" value="<%=rs.getString("username")%>"><br><br>
				Password<input type="text" name="password" value="<%=rs.getString("password")%>"><br><br>

			<%}%>
			
		<% }catch(Exception e){
			out.print(e);
		}
	}
%>
<input type="submit" onclick="GestisciDipendente">
</form>
</body>
</html>