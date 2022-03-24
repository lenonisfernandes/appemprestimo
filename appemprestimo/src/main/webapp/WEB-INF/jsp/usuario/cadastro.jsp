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
  <h2>Cadastramento de Usuário</h2>
  
  	<c:if test="${not empty mensagem }">
		<div class="alert alert-success">
	  		<strong>Confirmação!</strong> ${mensagem }
		</div>
	</c:if>
	
    <form action="/cep" method="post">
	    <div class="mb-3 mt-3">
	      <label>Busca por CEP:</label>
	      <input type="text" class="form-control" value="26010380" name="cep">
	    </div>
	    
	    <button type="submit" class="btn btn-primary">Buscar</button>
	    
    </form>
  
  
  <form action="/usuario/incluir" method="post">
    <div class="mb-3 mt-3">
      <label>Nome:</label>
      <input type="text" class="form-control" value="Bruna" name="nome">
    </div>
    
    <div class="mb-3 mt-3">
      <label>E-mail:</label>
      <input type="email" class="form-control" placeholder="Entre com o seu email" value="bruna@email.com" name="email">
    </div>
    
    <div class="mb-3 mt-3">
      <label>Senha:</label>
      <input type="password" class="form-control" placeholder="Entre com a sua senha" value="123" name="senha">
    </div>
    
    <c:import url="/WEB-INF/jsp/endereco.jsp"/>
    
    <button type="submit" class="btn btn-primary">Cadastrar</button>
  </form>
</div>


</body>
</html>