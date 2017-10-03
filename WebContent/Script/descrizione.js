$(document).ready(function() {
		$(".dettagliS").click(function(){
			   var k=this.getAttribute("id");
			   $("#descrizione").text(k);
			   $("#popup").show();
			   $("#veil").fadeIn();
			   });
		$(".chiudi").click(function(){
				$("#popup").hide();
				$("#veil").fadeOut();
 				});
});