<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="CSS/CarportDropdown.css" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome page</title>
</head>
<body>

<h1>Byg din carport her</h1>
<%--  todo lav en database som den henter værdierne fra  --%>
<form action="FrontController" method="post">
    <input type="hidden" name="target" value="carport">

    <div class="dropdown">
        <select class="dropbtn" name="length">Længde
            <option value="" disabled selected>Open this select menu</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
        </select>
    </div>

    <div class="dropdown">
        <select class="dropbtn" name="width">Bredde
            <option value="" disabled selected>Open this select menu</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
        </select>
    </div>


    <div class="dropdown">
        <select class="dropbtn" name="height">Højde
            <option value="" disabled selected>Open this select menu</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
        </select>
    </div>

    <input type="submit" value="Bestil carport">
</form>


<table>
    <tr>
        <td>Login</td>
        <td>
            <form name="login" action="FrontController" method="POST">
                <input type="hidden" name="target" value="login">
                Email:<br>
                <input type="text" name="email" value="someone@nowhere.com">
                <br>
                Password:<br>
                <input type="password" name="password" value="sesam">
                <br>
                <input type="submit" value="Submit">
            </form>
        </td>
        <td>Or Register</td>
        <td>
            <form name="register" action="FrontController" method="POST">
                <input type="hidden" name="target" value="register">
                Email:<br>
                <input type="text" name="email" value="someone@nowhere.com">
                <br>
                Password:<br>
                <input type="password" name="password1" value="sesam">
                <br>
                Retype Password:<br>
                <input type="password" name="password2" value="sesam">
                <br>
                <input type="submit" value="Submit">
            </form>
        </td>
    </tr>
</table>

<c:if test="${requestScope.error!= null}">
    <h2>Error ! </h2>
    ${requestScope.error}
</c:if>
</body>
</html>
