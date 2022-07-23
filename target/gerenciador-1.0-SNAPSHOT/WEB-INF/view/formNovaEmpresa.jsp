<%--
  Created by IntelliJ IDEA.
  User: Marcos Ceola
  Date: 07/07/2022
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada?acao=NovaEmpresa" var="linkServletNovaEmpresa" />
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${linkServletNovaEmpresa}" method="post">
        Nome: <input type="text" name="nomeNovaEmpresa" />
        Data Abertura: <input type="date" name="dataAbertura">
        <input type="submit" />
    </form>
</body>
</html>
