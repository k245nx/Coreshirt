function control(){
var colore=$('.colore:checked').val();
var taglia=$('.taglia:checked').val();
if(taglia!=null&&colore!=null){
	return true;
}
else {
	return false;}
}