<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List,com.bankchallenge.model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

<%--<c:import url="logout-parcial.jsp"/>--%>

<%--Usuario logado: ${usuarioLogado.login }--%>

<br>
<br>
<br>

<c:if test="${not empty user}">
    Cliente ${ user } cadastrado com sucesso!
</c:if>

Lista de Clientes: <br />
<ul>
    <c:forEach items="${ user }" var="user">
        <li>
                ${ user.name }  -  ${ user.email }
            <a href="/bankchallenge/entrada?acao=DisplayUser&id=${user.id }">editar</a>
            <a href="/bankchallenge/entrada?acao=RemoveUser&id=${user.id }">remove</a>
        </li>
    </c:forEach>
</ul>


</body>
</html>