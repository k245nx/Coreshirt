function validateForm(){
	var nome,cognome,cf,stip,tipo,user,pass;
	var x=document.forms["InsertDipendente"]["nome"].value;
	if(!x.match(/^[A-Za-z ]{3,30}$/)){
		nome="no";
	}
	
	var x=document.forms["InsertDipendente"]["cognome"].value;
	if(!x.match(/^[A-Za-z ]{3,30}$/)){
		cognome="no";
	}
	
	var x=document.forms["InsertDipendente"]["codiceFiscale"].value;
	if(!x.match(/^[a-zA-Z]{6}\d\d[a-zA-Z]\d\d[a-zA-Z]\d\d\d[a-zA-Z]/)){
		cf="no";
	}
	
	var x=document.forms["InsertDipendente"]["stipendio"].value;
	if(!x.match(/^([0-9]{1,10}).([0-9]{0,2})$/)){
		stip="no";
	}
	
	var x=document.forms["InsertDipendente"]["tipo"].value;
	if(!x.match(/^([a-zA-Z]{0,20})$/)){
		tipo="no";
	}
	
	var x=document.forms["InsertDipendente"]["username"].value;
	if(!x.match(/^[A-Za-z0-9.]{3,30}$/)){
		user="no";
	}
	
	var x=document.forms["InsertDipendente"]["password"].value;
	if(!x.match(/^[A-Za-z0-9]{5,12}$/)){
		pass="no";
	}
	
	if(nome=="no"){
		if(cognome=="no"||cf=="no"||stip=="no"||tipo=="no"||user=="no"||pass=="no"){
			alert("uno o piu' input non sono validi");
			return false;
		}
		else{
			alert("nome non valido");
			return false;
		}
	}
	if(cognome=="no"){
		if(nome=="no"||cf=="no"||stip=="no"||tipo=="no"||user=="no"||pass=="no"){
			alert("uno o piu' input non sono validi");
			return false;
		}
		else{
			alert("cognome non valido");
			return false;
		}
	}
	if(cf=="no"){
		if(cognome=="no"||nome=="no"||stip=="no"||tipo=="no"||user=="no"||pass=="no"){
			alert("uno o piu' input non sono validi");
			return false;
		}
		else{
			alert("codice fiscale non valido");
			return false;
		}
	}
	if(stip=="no"){
		if(cognome=="no"||cf=="no"||nome=="no"||tipo=="no"||user=="no"||pass=="no"){
			alert("uno o piu' input non sono validi");
			return false;
		}
		else{
			alert("stipendio non valido");
			return false;
		}
	}
	if(tipo=="no"){
		if(cognome=="no"||cf=="no"||stip=="no"||nome=="no"||user=="no"||pass=="no"){
			alert("uno o piu' input non sono validi");
			return false;
		}
		else{
			alert("tipo non valido");
			return false;
		}
	}
	if(user=="no"){
		if(cognome=="no"||cf=="no"||stip=="no"||tipo=="no"||nome=="no"||pass=="no"){
			alert("uno o piu' input non sono validi");
			return false;
		}
		else{
			alert("username non valido");
			return false;
		}
	}
	if(pass=="no"){
		if(cognome=="no"||cf=="no"||stip=="no"||tipo=="no"||user=="no"||nome=="no"){
			alert("uno o piu' input non sono validi");
			return false;
		}
		else{
			alert("password non valido");
			return false;
		}
	}
	
}