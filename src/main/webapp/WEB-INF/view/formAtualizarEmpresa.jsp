<%--
  Created by IntelliJ IDEA.
  User: Marcos Ceola
  Date: 07/07/2022
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada?acao=AtualizarEmpresa" var="linkServletAtualizarEmpresa"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${linkServletAtualizarEmpresa}&id=${empresa.id}" method="post">
    Novo nome: <input type="text" name="nomeAtualizadoEmpresa" value="${empresa.nome}"/>
    <input type="submit"/>
</form>

</body>
</html>
