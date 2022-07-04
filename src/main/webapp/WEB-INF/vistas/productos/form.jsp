<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#select-categorias').select2();
			$('#form-producto').validate();
		});
	</script>

	<h1>Formulario de producto</h1>

	<form:form method="post" action="/productos/guardar" modelAttribute="productoForm" id="form-producto">

		<div class="form-group">
			<label>Id</label>
			<form:input path="id" readonly="true" cssClass="form-control"/>
		</div>


		<div class="form-group">
			<label>Nombre</label>
			<form:input path="nombre" cssClass="form-control required" />
			<form:errors path="nombre" cssClass="error"/>
		</div>

		<div class="form-group">
			<label>Precio</label>
			<form:input path="precio" cssClass="form-control required number" />
			<form:errors path="precio" cssClass="error"/>
		</div>

		<div class="form-group">
			<label>Stock actual</label>
			<form:input path="stockActual" cssClass="form-control required number" />
			<form:errors path="stockActual" cssClass="error"/>
		</div>

		<div class="form-group">
			<label>Categoria</label>
			<form:select path="categoriaId" items="${categorias}" itemLabel="nombre" itemValue="id" cssClass="form-control" id="select-categorias" />
		</div>


		<button type="submit" class="btn btn-primary">Enviar datos</button>
	</form:form>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
