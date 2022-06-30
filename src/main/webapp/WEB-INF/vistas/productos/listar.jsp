<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

<h1>Listado de personas</h1>

<table>
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
			<td><a href="/productos/${p.id}">Ver</a>&nbsp;<a href="/productos/${p.id}/editar">Editar</a>&nbsp;<a href="/productos/${p.id}/borrar">Borrar</a></td>
		</tr>
	</c:forEach>
</table>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
