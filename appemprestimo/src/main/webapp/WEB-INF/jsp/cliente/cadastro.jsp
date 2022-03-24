<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container mt-3">
  <h2>Cadastramento de Clientes</h2>
  
  <form action="/cliente/incluir" method="post">
    <div class="mb-3 mt-3">
      <label>Nome:</label>
      <input type="text" class="form-control" value="Lenon" name="nome">
    </div>
    
    <div class="mb-3 mt-3">
      <label>E-mail:</label>
      <input type="email" class="form-control" placeholder="Entre com o seu email" value="lenon@email.com" name="email">
    </div>
    
    <div class="mb-3 mt-3">
      <label>CPF:</label>
      <input type="text" class="form-control" placeholder="Entre com o seu cpf" value="12345678901" name="cpf">
    </div>
    
    <c:import url="WEB-INF/jsp/endereco.jsp"/>
    

    <button type="submit" class="btn btn-primary">Cadastrar</button>
  </form>
</div>


</body>
</html>