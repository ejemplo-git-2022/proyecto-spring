<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form:form method="post" action="/productos/guardar" modelAttribute="productoForm">
		<form:input path="id" readonly="true"/>
		<form:input path="nombre"/>
		<form:errors path="nombre"/>
		<form:input path="precio"/>
		<form:errors path="precio"/>
		<form:select path="categoriaId" items="${categorias}" itemLabel="nombre" itemValue="id"  />
		<button type="submit">Enviar datos</button>
	</form:form>

</body>
</html>