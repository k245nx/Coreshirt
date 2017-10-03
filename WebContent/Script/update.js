$(document).ready(function () {
	$('.taglia').change(function () {
		var riga=this.getAttribute("id");
		var id=$('.riga'+riga+' .id').val();
		var sex=$('.riga'+riga+' .sex').val();
		var taglia=$('.riga'+riga+' .taglia').val();
		var taglia1=$('.riga'+riga+' .tg1').val();
		var colore=$('.riga'+riga+' .color').val();
		$.ajax({
			type:"get",
			url:"./?action=modifyT&id="+id+"&sesso="+sex+"&taglia="+taglia+"&taglia1="+taglia1+"&colore="+colore,
			success:function(result){
			}
		});
	})
	$('.pezzi').change(function () {
		var riga=this.getAttribute("id");
		var id=$('.riga'+riga+' .id').val();
		var sex=$('.riga'+riga+' .sex').val();
		var pz=$('.riga'+riga+' .pezzi').val();
		var taglia1=$('.riga'+riga+' .tg1').val();
		var color=$('.riga'+riga+' .color').val();
		$.ajax({
			type:"get",
			url:"./?action=modifyQ&id="+id+"&sesso="+sex+"&quantity="+pz+"&taglia="+taglia1+"&colore="+color,
			success:function(result){
				$('#prima-riga').load("./?action=cart #prima-riga>td");
				$('#seconda-riga').load("./?action=cart #seconda-riga>td");
			}
		});
	})
	$('div.conferma').click(function() {
  	  location.href="./Checkout";
    });
})