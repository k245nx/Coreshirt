/**
 * 
 */
var request;
function postComment(){
var id=document.manageArticolo.idArticolo.value;
var url="index.jsp?id="+id;

if(window.XMLHttpRequest){
request=new XMLHttpRequest();
}
else if(window.ActiveXObject){
request=new ActiveXObject("Microsoft.XMLHTTP");
}

try{
request.onreadystatechange=function(){
if(request.readyState==4){
var val=request.responseText;
//document.getElementById('mylocation').innerHTML=val;
}
}//end of function
request.open("GET",url,true);
request.send();
}catch(e){alert("Unable to connect to server");}
}