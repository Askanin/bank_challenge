<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<body>
<%--//<c:import url="logout-parcial.jsp"/>--%>

<c:if test="${not empty user}">
    Cliente ${ user } cadastrado com sucesso!
</c:if>

<c:if test="${empty user}">
    Nenhum cliente cadastrada!
</c:if>

</body>
</html>
