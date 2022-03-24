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
  <h2>Cadastramento de Livros</h2>
  
  	<c:if test="${not empty mensagem }">
		<div class="alert alert-success">
	  		<strong>Confirmação!</strong> ${mensagem }
		</div>
	</c:if>
	
  <form action="/livro/incluir" method="post">
    <div class="mb-3 mt-3">
      <label>Título:</label>
      <input type="text" class="form-control" value="A História do Java" name="titulo">
    </div>
    
    <div class="mb-3 mt-3">
      <label>Autor:</label>
      <input type="text" class="form-control" value="Santos, M. J." name="autor">
    </div>
    
    <div class="mb-3 mt-3">
      <label>Edicao:</label>
      <input type="text" class="form-control" value="5" name="edicao">
    </div>
    
    <div class="mb-3 mt-3">
      <label>Ano:</label>
      <input type="text" class="form-control" value="2019" name="ano">
    </div>
    
    <div class="mb-3 mt-3">
      <label>Quantidade:</label>
      <input type="text" class="form-control" value="20" name="qnt">
    </div>
    
    <button type="submit" class="btn btn-primary">Cadastrar</button>
  </form>
</div>


</body>
</html>