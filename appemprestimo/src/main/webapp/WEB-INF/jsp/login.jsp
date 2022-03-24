<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AppMIT</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">

	<c:if test="${not empty mensagem}">
			<div class="alert alert-warning">
	    		<strong>Atenção!</strong> ${mensagem}
	  		</div>
  		</c:if>
	
	  <h2>Autenticação</h2>
	  <form action="login" method="post">
	    
	    <div class="mb-3 mt-3">
	      <label>Email:</label>
	      <input type="email" class="form-control" placeholder="Entre com o seu email" value="lenon@lenon.com" name="email">
	    </div>
	    
	    <div class="mb-3">
	      <label>Senha:</label>
	      <input type="password" class="form-control" placeholder="Entre com a sua senha" value="lenon@lenon.com" name="senha">
	    </div>
	    
	    <button type="submit" class="btn btn-primary">Acessar</button>
	  </form>
	</div>


</body>
</html>