<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div class="dropdown">
    <select name="length">Længde
        <option value="" disabled selected>Vælg længde</option>
        <% int lengthIndex;
            for (lengthIndex = 240; lengthIndex <= 780; lengthIndex += 30) {
                out.print("<option value=\"" + lengthIndex + "\">" + lengthIndex + " cm</option> <br>");
            }
        %>
    </select>
</div>

<div class="dropdown">
    <select name="width">Bredde
        <option value="" disabled selected>Vælg bredde</option>
        <% int widthIndex;
            for (widthIndex = 240; widthIndex <= 750; widthIndex += 30) {
                out.print("<option value=\"" + widthIndex + "\">" + widthIndex + " cm</option> <br>");
            }
        %>
    </select>
</div>

<div class="dropdown">
    <select name="height">Højde
        <option value="" disabled selected>Vælg højde</option>
        <% int heigthIndex;
            for (heigthIndex = 300; heigthIndex <= 400; heigthIndex += 10) {
                out.print("<option value=\"" + heigthIndex + "\">" + heigthIndex + " cm</option> <br>");
            }
        %>
    </select>
</div>