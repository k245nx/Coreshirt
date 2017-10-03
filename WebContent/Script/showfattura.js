var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/    	

	function showfattura(){
    	var nome=$( "input[name='Nome']" ).val();
    	var cognome=$("input[name='Cognome']").val();
    	var indirizzo=$("input[name='Indirizzo']").val();
    	var recapito=$("input[name='Recapito']").val();
    	var citta=$("input[name='citta']").val();
    	var CAP=$("input[name='CAP']").val();
    	var NumeroCarta=$("input[name='NumeroCarta']").val();
    	var username=$("input[name='nomeutente']").val();
    	var Payment=$('.Payment').val();
    	if(!nome.match(/^[A-Za-z ]{3,30}$/)){
    		nome="no";
    	}
    	if(!cognome.match(/^[A-Za-z ]{3,30}$/)){
    		cognome="no";
    	}
    	if(!recapito.match(re)){
    		recapito="no";
    	}
    	if(!citta.match(/^[A-Za-z ]{3,30}$/)){
    		citta="no";
    	}
    	var regexp = /^[\w\s.-]+\d$/;
    	if(!regexp.test(indirizzo)){
    		indirizzo="no";
    	}
    	if(!CAP.match(/^[0-9]{5}$/)){
    		CAP="no";
    	}
    	if(Payment=='3'){
    		if(!username.match(re)){
        		username="no";
    		}
    	}
    	else{
    	if(!NumeroCarta.match(/^[0-9]{16}$/)){
    		NumeroCarta="no";
    	}
    	}
    	if(nome=="no"){
    		if(cognome=="no"||recapito=="no"||citta=="no"||indirizzo=="no"||CAP=="no"||username=="no"||NumeroCarta=="no"){
    			alert("uno o più input non sono validi");
    			return false;
    		}
    		else{
    			alert("nome non valido");
    			return false;
    		}
    	}
    	if(cognome=="no"){
    		if(nome=="no"||recapito=="no"||citta=="no"||indirizzo=="no"||CAP=="no"||username=="no"||NumeroCarta=="no"){
    			alert("uno o più input non sono validi");
    			return false;
    		}
    		else{
    			alert("cognome non valido");
    			return false;
    		}
    	}
    	if(recapito=="no"){
    		if(cognome=="no"||nome=="no"||citta=="no"||indirizzo=="no"||CAP=="no"||username=="no"||NumeroCarta=="no"){
    			alert("uno o più input non sono validi");
    			return false;
    		}
    		else{
    			alert("email non valida");
    			return false;
    		}
    	}
    	if(citta=="no"){
    		if(cognome=="no"||recapito=="no"||nome=="no"||indirizzo=="no"||CAP=="no"||username=="no"||NumeroCarta=="no"){
    			alert("uno o più input non sono validi");
    			return false;
    		}
    		else{
    			alert("città non valido");
    			return false;
    		}
    	}
    	if(indirizzo=="no"){
    		if(cognome=="no"||recapito=="no"||citta=="no"||nome=="no"||CAP=="no"||username=="no"||NumeroCarta=="no"){
    			alert("uno o più input non sono validi");
    			return false;
    		}
    		else{
    			alert("indirizzo non valido");
    			return false;
    		}
    	}
    	if(CAP=="no"){
    		if(cognome=="no"||recapito=="no"||citta=="no"||indirizzo=="no"||nome=="no"||username=="no"||NumeroCarta=="no"){
    			alert("uno o più input non sono validi");
    			return false;
    		}
    		else{
    			alert("CAP non valido");
    			return false;
    		}
    	}
    	if(username=="no"){
    		if(cognome=="no"||recapito=="no"||citta=="no"||indirizzo=="no"||CAP=="no"||nome=="no"||NumeroCarta=="no"){
    			alert("uno o più input non sono validi");
    			return false;
    		}
    		else{
    			alert("username non valido");
    			return false;
    		}
    	}
    	if(NumeroCarta=="no"){
    		if(cognome=="no"||recapito=="no"||citta=="no"||indirizzo=="no"||CAP=="no"||username=="no"||nome=="no"){
    			alert("uno o più input non sono validi");
    			return false;
    		}
    		else{
    			alert("numero carta non valido");
    			return false;
    		}
    	}
    	$("#popup").show();
    	$("#veil").fadeIn();
    }