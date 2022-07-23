<%--
  Created by IntelliJ IDEA.
  User: Marcos Ceola
  Date: 09/07/2022
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada?acao=VerificarLogin" var="login"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${login}" method="post">
        Login: <input type="text" name="login"/>
        Senha: <input type="password" name="senha"/>
        <input type="submit"/>
    </form>
</body>
</html>
