<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="DBAccess.CarportMapper" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="CSS/CarportDropdown.css" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome page</title>
    <script type="text/javascript" src="includes/Check.js"></script>
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

    <h2>Skal taget være med rejsning</h2>
    <h3>Hvis nej kommer taget med at plasttrapezplader </h3>
    <input type="radio" name="checkbox" value="yes" onchange="check3()" checked/> Nej
    <input type="radio" name="checkbox" value="True" onchange="check4()"/> Ja
    <br>

    <h2>Hvis du har valgt rejsning så kan du vælge tagtype og hældning her</h2>
    <div class="dropdown" >
        <select class="dropbtn" name="roofType" id="roofType" disabled>
            <option value="" disabled selected>Vælg tagtype og farven her</option>
            <c:forEach var="i" items="${CarportMapper.RoofType()}" varStatus="count">
                <option value="${count.current}">${i.toString()}</option>
            </c:forEach>
        </select>
    </div>

    <div class="dropdown">
        <select class="dropbtn" name="slope" id="slope" disabled>
            <%-- todo gør så det her kommer fra noget for each? --%>
            <option value="0" disabled selected>Vælg hældning her</option>
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
    <%-- todo der skal være noget (enable) her, så hvis man har checket nej, så kan man ikke bruge knapperne--%>
    <h2>Skal der være redskabsrum på carporten</h2>
    <br>

    <input type="radio" name="checkbox2" value="yes" onchange="check()" checked/> Nej
    <input type="radio" name="checkbox2" value="True" onchange="check2()"/> Ja
    <br>
    <h2>Hvis ja, så skal du vælge bredde og længde her</h2>
    <div class="dropdown">
        <select class="dropbtn" name="shackWidth" id="shackWidth" disabled>
            <option value="" disabled selected>Vælg skur bredde her</option>
            <option value="100">Hele carportens bredde</option>
            <option value="50">Halvdelen af carportens bredde</option>
        </select>
    </div>
    <div class="dropdown">
        <select class="dropbtn" name="shackLength" id="shackLength" disabled>
            <%-- todo gør så det her kommer fra noget for each? --%>
            <option value="" disabled selected>Vælg skur længde her</option>
            <option value="150">150 cm</option>
            <option value="180">180 cm</option>
            <option value="210">210 cm</option>
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
        </select>
    </div>
    <br>
    <h2>Vælg beklædning til carporten og skuret her</h2>
    <div class="dropdown">

        <select class="dropbtn" name="carportMats">
            <option value="" disabled selected>Vælg carport beklædning her</option>
            <c:forEach var="i" items="${CarportMapper.cladding()}" varStatus="count">
                <option value="${count.current}">${i.toString()}</option>
            </c:forEach>
        </select>

        <select class="dropbtn" name="shackMats">
            <option value="" disabled selected>Vælg skurets beklædning her</option>
            <c:forEach var="i" items="${CarportMapper.cladding()}" varStatus="count">
                <option value="${count.current}">${i.toString()}</option>
            </c:forEach>
        </select>
    </div>
    <br>
    <br>
    <br>
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
