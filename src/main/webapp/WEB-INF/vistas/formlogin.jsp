<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="/WEB-INF/vistas/template_superior.jsp"></jsp:include>

<style>
	html,
	body {
	  height: 100%;
	}
	
	body {
	  display: -ms-flexbox;
	  display: flex;
	  -ms-flex-align: center;
	  align-items: center;
	  padding-top: 40px;
	  padding-bottom: 40px;
	  background-color: #f5f5f5;
	}
	
	.form-signin {
	  width: 100%;
	  max-width: 330px;
	  padding: 15px;
	  margin: auto;
	}
	.form-signin .checkbox {
	  font-weight: 400;
	}
	.form-signin .form-control {
	  position: relative;
	  box-sizing: border-box;
	  height: auto;
	  padding: 10px;
	  font-size: 16px;
	}
	.form-signin .form-control:focus {
	  z-index: 2;
	}
	.form-signin input[type="email"] {
	  margin-bottom: -1px;
	  border-bottom-right-radius: 0;
	  border-bottom-left-radius: 0;
	}
	.form-signin input[type="password"] {
	  margin-bottom: 10px;
	  border-top-left-radius: 0;
	  border-top-right-radius: 0;
	}
</style>

	<form class="form-signin" method="post" action="/validarusuario">
	  <h1 class="h3 mb-3 font-weight-normal">Login de usuario</h1>
	  <label for="inputEmail" class="sr-only">Email address</label>
	  <input type="text" name="username" class="form-control" placeholder="Usuario" required autofocus>
	  <label for="inputPassword" class="sr-only">Password</label>
	  <input type="password"  name="password" class="form-control" placeholder="Password" required>
	
	  <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
	  <p class="mt-5 mb-3 text-muted">&copy; 2022</p>
	</form>
	

<jsp:include page="/WEB-INF/vistas/template_inferior.jsp"></jsp:include>
