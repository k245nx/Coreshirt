$(document).ready(function () {
	var i=1;
	$('.element').show();
	$('.element1').hide();
	$('.element2').hide();
	$('.element3').hide();
	$('.element4').hide();
	$('.element5').hide();
	$('#loadMore').click(function () {
		$('.element'+i).show();
		i++;
	});
});

