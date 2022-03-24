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
	<h2>Cadastramento de Usuários</h2>
	
	<c:if test="${not empty lista}">
	<h2>Total de usuários: ${lista.size()}</h2><hr>
	
  	  <table class="table table-striped">
	    <thead>
	      <tr>
	      	<th>ID</th>
	        <th>Nome</th>
	        <th>E-mail</th>
	        <th>Endereço</th>
 	        <th>Clientes</th>
 	        <th>Materiais</th>
 	        <th>Emprestimos</th> 
	        <c:if test="${user.admin}">
	        <th></th>
	        </c:if>
	      </tr>
	    </thead>
	    <tbody>
	    	<c:forEach var="u" items="${lista}"> 
		      <tr>
		      	<td>${u.id }</td>
		        <td>${u.nome}</td>
		        <td>${u.email}</td>
		        <td>${u.endereco.cep}</td>
		        <td>${u.clientes.size() }</td>
		        <td>${u.materiais.size() }</td>
		        <td>${u.emprestimos.size() }</td>
		        <c:if test="${user.admin}">
		        	<c:if test="${user.id != u.id}">
		        	<td><a href="/usuario/${u.id}/excluir">excluir</a></td>
					</c:if>
				</c:if>		        

		      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
	  
	  </c:if>
	  <c:if test="${empty lista }">
	  	<h2>Não existem usuários cadastrados!!!</h2>
	  </c:if>

</div>


</body>
</html>