<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/app">AppPedido</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/home">Home</a></li>
      <c:if test="${not empty user}">
      <li><a href="/usuarios">Usu?rio</a></li>
      <li><a href="/clientes">Cliente</a></li>
      <li><a href="/materiais">Material</a></li>
      <li><a href="/livros">Livro</a></li>
      <li><a href="/academicos">Acad?mico</a></li>
      <li><a href="/revistas">Revista</a></li>
      <li><a href="/emprestimos">Emprestimo</a></li>
      </c:if>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <c:if test="${empty user}">
      <li><a href="/usuario"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      </c:if>
      <c:if test="${not empty user}">
      <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout, ${user }</a></li>
      </c:if>
      <c:if test="${empty user}">
      <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:if>
    </ul>
  </div>
</nav>