<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ejemplo spring</title>
	
	<script type="text/javascript" src="<c:url value="/js/jquery-3.6.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/bootbox.all.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.validate.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/messages_es_AR.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/select2.min.js"/>"></script>
	
	<link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet" >
	<link href="<c:url value="/css/select2.min.css"/>" rel="stylesheet" >
	<link href="<c:url value="/css/general.css"/>" rel="stylesheet" >
	
	<script type="text/javascript">
		$(document).ready(function() {
			$('#select-autocomplete-productos').select2({ 
				width: '300px',
				placeholder: 'Buscador ajax',
				minimumInputLength: 2,
				ajax: {
				    url: '/api/productos/buscar',
				    data: function (params) {
				        var query = {
				          nombre: params.term
				        };
				        return query;
				    },
				    processResults: function (data) {
				        var nuevosDatos = [];
				    	
				        for(var producto of data) {
				        	nuevosDatos.push({ id: producto.id, text: producto.nombre + ' ' + producto.precio });
				        }
				        
				    	return {
				          results: nuevosDatos
				        };
				    },
				    dataType: 'json'
				}
			}).on('select2:select', function(event) {
				window.location = '/productos/' + event.params.data.id;
			});
		});
	</script>
</head>
<body>

	<sec:authorize access="isAuthenticated()">
		<header>
		  <!-- Fixed navbar -->
		  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
		    <a class="navbar-brand" href="<c:url value="/productos"/>">Ejemplo Spring</a>
		    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarCollapse">
		      <ul class="navbar-nav mr-auto">
		        <li class="nav-item">
		          <a class="nav-link" href="<c:url value="/productos"/>">Listado</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="<c:url value="/productos/nuevo"/>">Nuevo</a>
		        </li>
		        
		        <li class="nav-item">
		          <a class="nav-link" href="<c:url value="/logout"/>">Cerrar session de <sec:authentication property="principal.username" /> - <sec:authentication property="principal" /> </a>
		        </li>
		        
		      </ul>
		     
		      <form class="form-inline mt-2 mt-md-0">
		      	<select id="select-autocomplete-productos"></select>
		      </form>
		    </div>
		  </nav>
		</header>
	</sec:authorize>

	<div class="container">
		<div>${texto}</div>
	<!-- INICIO CONTENIDO -->