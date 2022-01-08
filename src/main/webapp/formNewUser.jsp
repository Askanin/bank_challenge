<%--
  Created by IntelliJ IDEA.
  User: felip
  Date: 07/01/2022
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value = "/entrada" var="linkEntradaServlet"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Banco de Clientes</title>
</head>
<body>

<c:import url="logout-parcial.jsp"/>

<form action= "${linkEntradaServlet}" method="post">

    Nome: <input type="text" name="nome" />
    Email: <input type="email" name="email" />
    Senha: <input type="password" name="senha" />

    <input type="hidden" name="acao" value="NewUser" >

    <input type="submit" />
</form>

</body>
</html>