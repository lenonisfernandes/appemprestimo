<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container mt-3">

	<div class="container mt-3">
	  <h2>O aluno ${nome} foi cadastrado com sucesso!!!</h2>

  <form action="/alunos" method="get">
    <button type="submit" class="btn btn-primary">Voltar</button>
  </form>

</div>

</body>
</html>