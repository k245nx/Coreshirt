function prodotto(){
	var nome=$("#nome").val();
	var prezzo=$("#prezzo").val();
	var quantita=$("#quantita").val();
	if(!nome.match(/^[A-Za-z ]{3,30}$/)){
		nome="no";
	}
	if(!prezzo.match(/^([0-9]{1,10}).([0-9]{0,2})$/)){
		prezzo="no";
	}
	
	
	if(!quantita.match(/^[0-9]{1,4}$/)){
		quantita="no";
	}
	
	if(nome=="no"){
		if(prezzo=="no"||quantita=="no"){
			alert("uno o piu' input non sono validi");
			return false;
		}
		else{
			alert("nome non valido");
			return false;
		}
	}
	
	if(prezzo=="no"){
		if(nome=="no"||quantita=="no"){
			alert("uno o piu' input non sono validi");
			return false;
		}
		else{
			alert("prezzo non valido");
			return false;
		}
	}
	
	if(quantita=="no"){
		if(prezzo=="no"||nome=="no"){
			alert("uno o piu' input non sono validi");
			return false;
		}
		else{
			alert("quantita' non valida");
			return false;
		}
	}
	
}