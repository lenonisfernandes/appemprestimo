<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AppPedido</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container mt-3">
  <h2>Cadastramento de Revistas</h2>
  
  	<c:if test="${not empty mensagem }">
		<div class="alert alert-success">
	  		<strong>Confirmação!</strong> ${mensagem }
		</div>
	</c:if>
	
  <form action="/revista/incluir" method="post">
    <div class="mb-3 mt-3">
      <label>Título:</label>
      <input type="text" class="form-control" value="Matemática para Crianças" name="titulo">
    </div>
    
    <div class="mb-3 mt-3">
      <label>Ano:</label>
      <input type="text" class="form-control" value="2020" name="ano">
    </div>
    
    <div class="mb-3 mt-3">
      <label>Mês:</label>
      <input type="text" class="form-control" value="2" name="mes">
    </div>
    
    <div class="mb-3 mt-3">
      <label>Edição:</label>
      <input type="text" class="form-control" value="45" name="edicao">
    </div>

    <button type="submit" class="btn btn-primary">Cadastrar</button>
  </form>
</div>


</body>
</html>