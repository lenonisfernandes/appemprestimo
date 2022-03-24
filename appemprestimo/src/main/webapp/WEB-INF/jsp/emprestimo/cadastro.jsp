<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<c:set var="botao" value=""/>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container mt-3">
  <h2>Cadastramento de Emprestimos</h2>
  
  <form action="/emprestimo/incluir" method="post">
  
  
	 <div class="mb-3 mt-3">
		  <c:if test="${not empty clientes}">
			  <label>Clientes:</label>
			  <select class="form-control" name="cliente.id">
				<c:forEach var="c" items="${clientes}"> 
			  		<option value="${c.id }">${c.nome }</option>
			  	</c:forEach>
			  </select>
		  </c:if>
		  
		  <c:if test="${empty clientes }">
		  	<c:set var="botao" value="disabled"/>
		  	<label>Não existem clientes cadastrados.</label>
		  </c:if>
	</div>
	
    <div class="mb-3 mt-3">
    <c:if test="${not empty materiais }">
      <label>Materiais:</label>
      <c:forEach var="m" items="${materiais}">
	      <div class="checkbox">
	      	<label><input type="checkbox" class="form-control" value="${m.id }" name="materiaisId"> ${m.titulo }</label>
	      </div>
	  </c:forEach>
    </c:if>
    <c:if test="${empty materiais }">
    <c:set var="botao" value="disabled"/>
    <label>Não existem materiais cadastrados.</label>
    </c:if>
    </div>
	
    
    <div class="mb-3 mt-3">
      <label>Descrição:</label>
      <input type="text" class="form-control" value="Primeiro material emprestado" name="descricao">
    </div>
    
    <div class="mb-3 mt-3">
    	<label>Web:</label>
      	<input type="checkbox" class="form-control" value="true" name="web">
    </div>
        

    <button ${botao } type="submit" class="btn btn-primary">Cadastrar</button>
  </form>
</div>


</body>
</html>