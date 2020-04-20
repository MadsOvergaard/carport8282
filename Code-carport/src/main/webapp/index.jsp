<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="DBAccess.CarportMapper" %>
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
            <option value="" disabled selected>Vælg længde</option>
            <option value="240">240 cm</option>
            <option value="270">270 cm</option>
            <option value="300">300 cm</option>
            <option value="330">330 cm</option>
            <option value="360">360 cm</option>
            <option value="390">390 cm</option>
            <option value="420">420 cm</option>
            <option value="450">450 cm</option>
            <option value="480">480 cm</option>
            <option value="510">510 cm</option>
            <option value="540">540 cm</option>
            <option value="570">570 cm</option>
            <option value="600">600 cm</option>
            <option value="630">630 cm</option>
            <option value="660">660 cm</option>
            <option value="690">690 cm</option>
            <option value="720">720 cm</option>
            <option value="750">750 cm</option>
            <option value="780">780 cm</option>
        </select>
    </div>
    <div class="dropdown">
        <select class="dropbtn" name="width">Bredde
            <option value="" disabled selected>Vælg bredde</option>
            <option value="240">240 cm</option>
            <option value="270">270 cm</option>
            <option value="300">300 cm</option>
            <option value="330">330 cm</option>
            <option value="360">360 cm</option>
            <option value="390">390 cm</option>
            <option value="420">420 cm</option>
            <option value="450">450 cm</option>
            <option value="480">480 cm</option>
            <option value="510">510 cm</option>
            <option value="540">540 cm</option>
            <option value="570">570 cm</option>
            <option value="600">600 cm</option>
            <option value="630">630 cm</option>
            <option value="660">660 cm</option>
            <option value="690">690 cm</option>
            <option value="720">720 cm</option>
            <option value="750">750 cm</option>
        </select>
    </div>
    <div class="dropdown">
        <select class="dropbtn" name="height">Højde
            <option value="" disabled selected>Vælg højde</option>
            <option value="300">300 cm</option>
            <option value="310">310 cm</option>
            <option value="320">320 cm</option>
            <option value="330">330 cm</option>
            <option value="340">340 cm</option>
            <option value="350">350 cm</option>
            <option value="360">360 cm</option>
            <option value="370">370 cm</option>
            <option value="380">380 cm</option>
            <option value="390">390 cm</option>
            <option value="400">400 cm</option>
        </select>
    </div>
    <br>
    
    <%-- todo gør så det her også bliver sendt til databsen --%>
    <h1>Skal taget være med rejsning</h1>
    <input type="radio" name="checkbox" value="no"/> Nej
    <input type="radio" name="checkbox" value="yes"/> Ja
    <br>
    <h2>Hvis du har valgt rejsning så kan du vælge tagtype og hældning her</h2>
    <div class="dropdown">
        <select class="dropbtn" name="roofType">
            <option value="" disabled selected>Vælg tagtype og farven her</option>
            <c:forEach var="i" items="${CarportMapper.RoofType()}" varStatus="count">
                <option value="${count.index}">${i.toString()}</option>
            </c:forEach>
        </select>
    </div>

    <%-- todo gør så det her også bliver sendt til databsen --%>
    <div class="dropdown">
        <select class="dropbtn" name="slope">
            <option value="" disabled selected>Vælg hældning her</option>
            <option value="15">15 grader</option>
            <option value="20">20 grader</option>
            <option value="25">25 grader</option>
            <option value="30">30 grader</option>
            <option value="35">35 grader</option>
            <option value="40">40 grader</option>
            <option value="45">45 grader</option>
        </select>
    </div>

<br>
<br>
<br>

    <input type="submit" value="Bestil carport">
</form>


<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

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
