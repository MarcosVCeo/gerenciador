<%@ page import="java.util.List, br.com.marcos.gerenciador.servlet.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada?acao=RemoverEmpresa" var="linkServletRemoveEmpresa" />
<c:url value="/entrada?acao=MostrarEmpresa" var="linkServletAtualizarEmpresa"/>

<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <a href="entrada?acao=Logout" >Sair</a>
  <br>
  <br>
  <br>
  Usuario Logado: ${usuarioLogado.login}

  <h1>Empresas cadastradas</h1>
  <ul>
    <c:forEach items="${empresas}" var="empresa">
      <li>${empresa.nome} <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
        <a href="${linkServletRemoveEmpresa}&id=${empresa.id}">remover</a>
        <a href="${linkServletAtualizarEmpresa}&id=${empresa.id}">atualizar</a>
      </li>
    </c:forEach>
  </ul>
  </body>
</html>
