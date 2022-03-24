<%@page import="br.edu.infnet.appemprestimo.model.domain.Aluno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AppMIT</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container mt-3">
	<h2>Cadastramento de Alunos</h2>
	
	<c:if test="${not empty mensagem }">
		<div class="alert alert-success">
	  		<strong>Confirmação!</strong> ${mensagem }
		</div>
	</c:if>
	
	<form action="aluno" method="get">
		<button type="submit" class="btn btn-primary">Novo</button>
	</form>
	
	<hr>
	
	<c:if test="${not empty alunos}">
	<h2>Total de alunos: ${lista.size()}</h2><hr>
	
  	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Nome</th>
	        <th>E-mail</th>
	      </tr>
	    </thead>
	    <tbody>
	    	<c:forEach var="a" items="${alunos}"> 
		      <tr>
		        <td>${a.nome}</td>
		        <td>${a.email}</td>
		      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
	  
	  </c:if>
	  <c:if test="${empty alunos }">
	  	<h2>Não existem alunos cadastrados!!!</h2>
	  </c:if>

</div>


</body>
</html>