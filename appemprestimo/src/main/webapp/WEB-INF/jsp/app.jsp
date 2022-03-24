<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet"> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>
<body>

<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container">
  <h2>Quantidade de Registros</h2>
  <ul class="list-group">
    <c:forEach var="m" items="${myMap}">
    	<li class="list-group-item">${m.key } <span class="badge">${m.value }</span></li>
    </c:forEach>
  </ul>
</div>
  
  
</body>
</html>