<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

<h1>Listado de productos</h1>

<table class="table table-striped table-bordered">
	<thead class="thead-dark">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Precio</th>
			<th></th>
		</tr>
	</thead>
	<c:forEach items="${productos}" var="p">
		<tr>
			<td>${p.id}</td>
			<td>${p.nombre}</td>
			<td>
				<c:if test="${p.precio >= 5000}">
					<span style="color: red;">${p.precio}</span>
				</c:if>
				<c:if test="${p.precio < 5000}">
					<span style="color: green;">${p.precio}</span>
				</c:if>
			</td>
			<td>
				<a href="/productos/${p.id}" class="btn btn-primary">Ver</a>&nbsp;
				<a href="/productos/${p.id}/editar" class="btn btn-success">Editar</a>&nbsp;
				<a href="/productos/${p.id}/borrar" class="btn btn-danger">Borrar</a></td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
