<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="CSS/CarportDropdown.css" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="includes/Check.js"></script>
    <title>Welcome page</title>
</head>
<body>
<form action="FrontController" method="post">
    <input type="hidden" name="target" value="admin">
    <input type="submit" value="adminsiden version alpha 1.0">
</form>

<h1>Byg din carport her</h1>

<form action="FrontController" method="post">
    <input type="hidden" name="target" value="carport">

    <%@include file="includes/LWHDropdownMenu.jsp" %>
    <br>
    <%@include file="includes/slopeDropdownMenu.jsp" %>
    <br>
    <%@include file="includes/shackDropdownMenu.jsp" %>
    <br>
    <%@include file="includes/claddingDropdownMenu.jsp" %>
    <br>
    <br>

    <input type="submit" value="Bestil carport">
</form>

<c:if test="${requestScope.error!= null}">
    <h2>Error ! </h2>
    ${requestScope.error}
</c:if>
</body>
</html>
