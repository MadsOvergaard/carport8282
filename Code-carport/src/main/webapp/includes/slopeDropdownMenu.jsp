<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<h2>Skal taget være med rejsning</h2>
<h3>Hvis nej kommer taget med at plasttrapezplader </h3>
<input type="radio" name="checkbox" value="yes" onchange="check3()" checked/> Nej
<input type="radio" name="checkbox" value="True" onchange="check4()"/> Ja
<br>

<h2>Hvis du har valgt rejsning så kan du vælge tagtype og hældning her</h2>
<div class="dropdown" >
    <select  name="roofType" id="roofType" disabled>
        <option value="" disabled selected>Vælg tagtype og farven her</option>
        <c:forEach var="i" items="${CarportMapper.RoofType()}" varStatus="count">
            <option value="${count.current}">${i.toString()}</option>
        </c:forEach>
    </select>
</div>

<div class="dropdown">
    <select  name="slope" id="slope" disabled>
        <%-- todo gør så det her kommer fra noget for each? --%>
        <option value="0" disabled selected>Vælg hældning her</option>
        <% int slopeindex;
            for (slopeindex = 15; slopeindex <= 45; slopeindex += 5 ) {
                out.print("<option value=\"" + slopeindex + "\">" + slopeindex + " cm</option> <br>");
            }
        %>
    </select>
</div>