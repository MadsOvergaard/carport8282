<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="DBAccess.CarportMapper" %>
<h2 class="my-md-3 text-center text-black">Skal taget være med rejsning</h2>
<h5 class="my-md-3 text-center text-black">Hvis nej kommer taget med at plasttrapezplader </h5>
<input type="radio" name="checkbox" value="yes" onchange="check3()" checked/> Nej
<input type="radio" name="checkbox" value="True" onchange="check4()"/> Ja
<br>

<div class="dropdown" >
    <select  name="roofType" id="roofType" disabled>
        <option value="" disabled selected>Vælg tagtype og farven her</option>
        <c:forEach var="i" items="${CarportMapper.roofMaterial()}" varStatus="count">
            <option value="${count.current}">${i.toString()}</option>
        </c:forEach>
    </select>
</div>

<div class="dropdown">
    <select  name="slope" id="slope" disabled>
        <option value="0" disabled selected>Vælg hældning her</option>
        <% int slopeindex;
            for (slopeindex = 15; slopeindex <= 45; slopeindex += 5 ) {
                out.print("<option value=\"" + slopeindex + "\">" + slopeindex + " cm</option> <br>");
            }
        %>
    </select>
</div>