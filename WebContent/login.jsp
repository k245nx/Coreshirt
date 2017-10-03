<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="CSS/login.css" type="text/css">
<link rel="stylesheet" href="CSS/base.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login form</title>
</head>
<body>


<body>
    <div id="wrapper">
    <article id="articolo1">
    <div id="lista">
    <a href="./"><div id="banner"> <img class="Banner" src="Immagini/prova.png"> 
          <img class="core" src="Immagini/core2.png"></a>
        </div>
    </div>
    </article>

<div class="login">
<form action="Login" method="post" class="login"> 
<fieldset class="login_fieldset">
     <legend>Login</legend>
     <label for="username">Login</label>
     <input id="username" type="text" name="username" placeholder="enter login"> 
     <br>   
     <label for="password">Password</label>
     <input id="password" type="password" name="password" placeholder="enter password"> 
     <br>
     <input class="burton" type="submit" value="Login"/>
     <input class="burton" type="reset" value="Reset"/>
</fieldset>
</form> 
</div>
</body>
</html>