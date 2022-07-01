<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ejemplo spring</title>
	
	<script type="text/javascript" src="<c:url value="/js/jquery-3.6.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery-3.6.0.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/bootbox.all.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.validate.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/messages_es_AR.js"/>"></script>
	<link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet" >
	<link href="<c:url value="/css/general.css"/>" rel="stylesheet" >
</head>
<body>

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
	      </ul>
	      <form class="form-inline mt-2 mt-md-0">
	        <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
	        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
	      </form>
	    </div>
	  </nav>
	</header>


	<div class="container">
	<!-- INICIO CONTENIDO -->