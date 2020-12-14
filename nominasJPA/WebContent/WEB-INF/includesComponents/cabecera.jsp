
<h1 align="center">
	Cine
	<%@include file="botonLogin.jsp" %>
</h1>

<ul id="navegador" class="nav nav-tabs">
	<li class="nav-item"><a class="nav-link activo"
		href="home">Inicio</a>
	</li>
	<li class="nav-item"><a class="nav-link"
		href="buscar">
			Consultar directores</a></li>
	<li class="nav-item"><a class="nav-link"
		href="info">Info
	</a></li>
	<c:if test="${usuarioActivo != null}">
		<li class="nav-item"><a class="nav-link"
			href="darAlta">Dar de alta</a></li>
	</c:if>
</ul>