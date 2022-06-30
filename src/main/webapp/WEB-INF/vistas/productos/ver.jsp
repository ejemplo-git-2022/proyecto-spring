<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

${producto.id}<br>
${producto.nombre}<br>
${producto.precio}<br>

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
