<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
    <input type="hidden" name="id" value="${user.id }" >
    <input type="hidden" name="acao" value="ChangeUser" >

    <input type="submit" />
</form>

</body>
</html>