<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form name="Enviar"
		action="iniciarSesion"
		method="post">
		<div class="form-group">
			<label for="exampleFormControlInput1">Usuario</label> <input
				type="text" class="form-control" name="usuario"
				id="exampleFormControlInput1" placeholder="Usuario" value="">
			<label for="exampleFormControlInput1">password</label> <input
				type="text" name="password" class="form-control"
				id="exampleFormControlInput1" placeholder="Password" value="">
				<input class="btn btn-primary btn-sm" type="submit"
			value="Iniciar sesión" />
		</div>		
	</form>
	<p>${noExiste}</p>

</body>
</html>