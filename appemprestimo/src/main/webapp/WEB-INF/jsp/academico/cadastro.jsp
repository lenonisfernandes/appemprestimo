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
  <h2>Cadastramento de Materiais Academicos</h2>
  
  	<c:if test="${not empty mensagem }">
		<div class="alert alert-success">
	  		<strong>Confirmação!</strong> ${mensagem }
		</div>
	</c:if>
	
  <form action="/academico/incluir" method="post">
    <div class="mb-3 mt-3">
      <label>Título:</label>
      <input type="text" class="form-control" value="Estudo de caso 5" name="titulo">
    </div>
    
    <div class="mb-3 mt-3">
      <label>Autor:</label>
      <input type="text" class="form-control" value="Silva, G. F." name="autor">
    </div>
    
    <div class="mb-3 mt-3">
      <label><input type="checkbox" class="form-control" value="" name="nacional">Nacional</label>
    </div>
    
    <div class="mb-3 mt-3">
      <label>Idioma:</label>
      <input type="text" class="form-control" value="pt-br" name="idioma">
    </div>
    
    <div class="mb-3 mt-3">
	  <label>Tipo:</label>
	  <select class="form-control" name="tipo">
	    <option value="artigo">Artigo</option>
	    <option value="tcc">TCC</option>
	    <option value="resumo">Resumo</option>
	  </select>
	</div>

    <button type="submit" class="btn btn-primary">Cadastrar</button>
  </form>
</div>


</body>
</html>