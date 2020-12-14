	<c:if test="${usuarioActivo != null}">
		<a type="button" class="botonLogin btn "
			href="salirSesion">Logout</a>
	</c:if>
	<c:if test="${usuarioActivo == null}">
		<a type="button" class="botonLogin btn "
			href="login">Login</a>
	</c:if>