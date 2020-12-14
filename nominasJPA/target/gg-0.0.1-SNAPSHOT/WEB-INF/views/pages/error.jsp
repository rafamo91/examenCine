
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!doctype html>

<html lang="en">
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello, world!</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
  </head>
  <body>
  	<a type="button" class="btn btn-success" href="${pageContext.request.contextPath}">Back</a>
	
	
    <h1 align="center">ERROR. DATOS INCORRECTOS</h1>
	<div class="container">
	<h3>No se han podido modificar los datos en la base de datos porque uno de los valores introducidos es incorrecto</h3>

	
	


	</div>
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>

<style>

body{
    background-color: rgb(155, 155, 155);
}

h1{
    text-align: center;
    margin-bottom: 30px;
    background-color: rgb(30, 55, 56);
    color: rgb(255, 255, 255);
    padding:20px;
}





h2{
  background-color: rgb(30, 55, 56);
    color: rgb(255, 255, 255);
    padding-bottom:50px;
    text-align:"center";
}

h4{
  background-color: rgb(30, 55, 56);
    color: rgb(255, 255, 255);
    padding: 1%;
    margin-top: 16%;
}


#navegador{
    margin-top: -30px;
    background-color:  rgb(30, 55, 56);
}

.nav-link{
    text-decoration: none;
}

a{
    color: rgb(255, 255, 255);
    font-size: 2vh;
}

.activo{
    background-color: rgb(155, 155, 155);
    color: black;
}




@media screen and (min-width: 400px) {
  .container{
    max-width: 50%;
  }
}

@media screen and (max-width: 800px) {
  .container{
    max-width: 100%;
  }
}






.btn-success{
	float:left;
}

.container{
	
	margin-top:50px;
}


.table-dark{
	margin-top:70px;
}

.casilla{
	max-width:50px;
}

</style>
  </body>
</html>