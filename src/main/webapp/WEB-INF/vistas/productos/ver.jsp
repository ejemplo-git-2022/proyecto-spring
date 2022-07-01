<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>


<div class="card">
  <h5 class="card-header">Producto id: ${producto.id}</h5>
  <div class="card-body">
    <h5 class="card-title">${producto.nombre}</h5>
    <p class="card-text">Precio: <fmt:formatNumber type="number" value="${producto.precio}" /> </p>    
    <c:if test="${not empty producto.categoriaProducto}">
	    <p class="card-text">Categoria: <c:out value="${producto.categoriaProducto.nombre}" default="Sin categoria" /></p>
 	</c:if>
  </div>
</div>


<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
