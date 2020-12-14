
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello, world!</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
</head>
<body>
    	<h1 align="center">
		<a type="button" class="btn btn-success"
			href="${pageContext.request.contextPath}">Back</a>Usuarios activos
	</h1>
	
		 <ul id="navegador" class="nav nav-tabs">
	    <li class="nav-item">
     <a class="nav-link " href="${pageContext.request.contextPath}">Inicio</a>
    </li>
    <li class="nav-item " >
      <a class="nav-link" href="user">Usuarios activos</a>
    </li>
    <li class="nav-item activo">
      <a class="nav-link " href="modify">Modificar empleados</a>
    </li>
    <li class="nav-item ">
      <a class="nav-link" href="salary">Calcular salario</a>
    </li>
  </ul>


	<div class="row ">
		<div class="col-md-3 ">
			<div class="float">
				<form name="Enviar"
					action="consultaPersonalizada"
					method="post">
					<div class="form-group">
						<label for="exampleFormControlInput1">Dni</label> <input
							type="text" name="consultaDni" class="form-control"
							id="exampleFormControlInput1" placeholder="Dni" value="">
						<label for="exampleFormControlInput1">Nombre</label> <input
							type="text" class="form-control" name="consultaNombre"
							id="exampleFormControlInput1" placeholder="Nombre" value="">
						<label for="exampleFormControlInput1">A�os</label> <input
							type="text" name="consultaAnios" class="form-control"
							id="exampleFormControlInput1" placeholder="A�os" value="">
					</div>
					
					
					
					<div class="form-group">
						<label for="exampleFormControlSelect1">Categoria</label> <select
							name="consultaCategoria" class="form-control"
							id="exampleFormControlSelect1">
							<option></option>
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
							<option>7</option>
							<option>8</option>
							<option>9</option>
							<option>10</option>
						</select>
					</div>
					<div class="form-group">
						<label for="exampleFormControlSelect1">Sexo</label> <select
							name="consultaSexo" class="form-control"
							id="exampleFormControlSelect1">
							<option></option>
							<option>F</option>
							<option>M</option>
						</select>
					</div>
					<input class="btn btn-primary btn-sm" type="submit"
						value="Consultar" />
				</form>
			</div>
		</div>
		<div class="col-md-7">
			<table class="table table-dark">
				<tr>
					<td>ID</td>
					<td>DNI</td>
					<td>Nombre</td>
					<td>Categoria</td>
					<td>Sexo</td>
					<td>A�os</td>
					<td>Modificar datos</td>
				</tr>

				<c:forEach var="empleado" items="${empleados}">
					<form name="CambiarDatos"
						action="actualizar"
						method="post">
						<tr class="tablaDatos">
						
						<td><input type="text" name="id"
								value="${empleado.getId()}" readonly /></td>

							<td><input type="text" name="dni"
								value="${empleado.getDni()}" readonly /></td>

							<td><input type="text" name="nombre"
								value="${empleado.getNombre()}" required /></td>

							<td><select name="categoria">
									<option>${empleado.getCategoria()}</option>
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
									<option>6</option>
									<option>7</option>
									<option>8</option>
									<option>9</option>
									<option>10</option>
							</select> <!--  <input class="casilla" type="text" name="categoria"
							value="${empleado.getCategoria()}" required />--></td>

							<td><select name="sexo">
									<option>${empleado.getSexo()}</option>
									<option>M</option>
									<option>F</option>

							</select> <!-- <input class="casilla" type="text" name="sexo"
							value="${empleado.getSexo()}" required /></td> -->
							<td><input class="casilla" type="text" name="anios"
								value="${empleado.getAnios()}" required /></td>

							<td><button value="ActualizarDatos" type="submit">Actualizar</button></td>
						</tr>

					</form>
				</c:forEach>


			</table>

		</div>
		<div class="col-md-3"></div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
		integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
		crossorigin="anonymous"></script>

	<style>
body {
	background-color: rgb(155, 155, 155);
}

.row {
	margin-top: 20px;
}

h1 {
	text-align: center;
	margin-bottom: 30px;
	background-color: rgb(30, 55, 56);
	color: rgb(255, 255, 255);
	padding: 20px;
}

h2 {
	background-color: rgb(30, 55, 56);
	color: rgb(255, 255, 255);
	padding-bottom: 50px;
	text-align: "center";
}

h4 {
	background-color: rgb(30, 55, 56);
	color: rgb(255, 255, 255);
	padding: 1%;
	margin-top: 16%;
}

#navegador {
	margin-top: -30px;
	background-color: rgb(30, 55, 56);
}

.nav-link {
	text-decoration: none;
}

a {
	color: rgb(255, 255, 255);
	font-size: 2vh;
}

.activo {
	background-color: rgb(155, 155, 155);
	color: black;
}

@media screen and (min-width: 400px) {
	.container {
		max-width: 50%;
	}
}

@media screen and (max-width: 800px) {
	.container {
		max-width: 100%;
	}
}

.float {
	float: right;
}

.table-dark {
	margin-top: 30px;
	border: 1px solid black;
}

.casilla {
	max-width: 50px;
}

form {
	max-width: 150px;
}

.btn-success {
	float: left;
}

@media ( max-width :800px) {
	.float {
		float: left;
	}
	.row {text-align ="center";
		padding: 50px;
	}
}
}
</style>
</body>
</html>