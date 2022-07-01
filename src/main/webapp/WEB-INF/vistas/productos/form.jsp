<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

	<h1>Formulario de producto</h1>

	<form:form method="post" action="/productos/guardar" modelAttribute="productoForm">

		<div class="form-group">
			<label>Id</label>
			<form:input path="id" readonly="true" cssClass="form-control"/>
		</div>


		<div class="form-group">
			<label>Nombre</label>
			<form:input path="nombre" cssClass="form-control" />
			<form:errors path="nombre" cssClass="error"/>
		</div>

		<div class="form-group">
			<label>Precio</label>
			<form:input path="precio" cssClass="form-control" />
			<form:errors path="precio" cssClass="error"/>
		</div>

		<div class="form-group">
			<label>Categoria</label>
			<form:select path="categoriaId" items="${categorias}" itemLabel="nombre" itemValue="id" cssClass="form-control" />
		</div>


		<button type="submit" class="btn btn-primary">Enviar datos</button>
	</form:form>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
