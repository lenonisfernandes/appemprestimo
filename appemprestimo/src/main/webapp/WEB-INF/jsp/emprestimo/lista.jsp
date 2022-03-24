<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h2>Cadastramento de Emprestimo</h2>
	
	<c:if test="${not empty mensagem }">
		<div class="alert alert-success">
	  		<strong>Confirmação!</strong> ${mensagem }
		</div>
	</c:if>
	
	<form action="/emprestimo" method="get">
		<button type="submit" class="btn btn-primary">Novo</button>
	</form>
	
	<hr>
	
	<c:if test="${not empty lista}">
	<h2>Total de emprestimo: ${lista.size()}</h2><hr>
	
  	  <table class="table table-striped">
	    <thead>
	      <tr>
	      	<th>ID</th>
	        <th>Data</th>
	        <th>Descrição</th>
	        <th>Web</th>
	        <th>Cliente</th>
	        <th>Materiais</th>
	        <th></th>
	      </tr>
	    </thead>
	    <tbody>
	    	<c:forEach var="e" items="${lista}"> 
		      <tr>
		      	<td>${e.id }</td>
		        <td>${e.data}</td>
		        <td>${e.descricao}</td>
		        <td>${e.web}</td>
		        <td>${e.cliente.nome}</td>
		        <td>${e.materiais.size()}</td>
		        <td><a href="/emprestimo/${e.id}/excluir">excluir</a></td>
		      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
	  
	  </c:if>
	  <c:if test="${empty lista }">
	  	<h2>Não existem emprestimos cadastrados!!!</h2>
	  </c:if>

</div>


</body>
</html>