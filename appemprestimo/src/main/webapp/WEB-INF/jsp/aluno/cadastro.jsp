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
  <h2>Cadastramento de Alunos</h2>
  
  <form action="/aluno/incluir" method="post">
    <div class="mb-3 mt-3">
      <label>Nome:</label>
      <input type="text" class="form-control" value="Lenon" name="nome">
    </div>
    
    <div class="mb-3 mt-3">
      <label>E-mail:</label>
      <input type="email" class="form-control" placeholder="Entre com o seu email" value="lenon@email.com" name="email">
    </div>
    
    <div class="mb-3 mt-3">
      <label>Idade:</label>
      <input type="text" class="form-control" placeholder="Entre com a sua idade" value="29" name="idade">
    </div>
    
    <div class="mb-3 mt-3">
      <label>Mensalidade:</label>
      <input type="text" class="form-control" placeholder="Entre com a sua mensalidade" value="999" name="mensalidade">
    </div>
    
    <div class="mb-3 mt-3">
      <label>Curso:</label>
	    <div class="form-check">
		  <input type="radio" class="form-check-input" name="curso" value="G">
		  <label class="form-check-label" for="radio2">Graduação</label>
		</div>
		<div class="form-check">
		  <input type="radio" class="form-check-input" name="curso" value="E" checked>
		  <label class="form-check-label" for="radio1">Especialização</label>
		</div>
		<div class="form-check">
		  <input type="radio" class="form-check-input" name="curso" value="M">
		  <label class="form-check-label" for="radio1">Mestrado</label>
		</div>
	</div>
	<div class="mb-3 mt-3">
      <label>Disciplinas:</label>
		 <div class="form-check">
	      <input type="checkbox" class="form-check-input" name="disciplinas" value="fundamentos" checked>
	      <label class="form-check-label">Fundamentos Java</label>
	    </div>
	    <div class="form-check">
	      <input type="checkbox" class="form-check-input" name="disciplinas" value="javaWeb">
	      <label class="form-check-label">Java Web</label>
	    </div>
	    <div class="form-check">
	      <input type="checkbox" class="form-check-input" name="disciplinas" value="poo">
	      <label class="form-check-label">POO</label>
	    </div>
	   </div>
	   
	<div class="mb-3 mt-3">
    	<label class="form-label">Região:</label>
		<select class="form-select" name="regiao">
	      <option value="S">Sul</option>
	      <option value="Su" selected>Sudeste</option>
	      <option value="C">Centro-oeste</option>
	      <option value="N">Norte</option>
	      <option value="No">Nordeste</option>
	    </select>
	</div>

    <button type="submit" class="btn btn-primary">Cadastrar</button>
  </form>
</div>


</body>
</html>