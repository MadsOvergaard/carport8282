<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<h2 class="my-md-5 text-center text-black">Skal der være redskabsrum på carporten</h2>

<input type="radio" name="checkbox2" value="yes" onchange="check()" checked/> Nej
<input type="radio" name="checkbox2" value="True" onchange="check2()"/> Ja
<br>

<div class="dropdown">
    <select  name="shackWidth" id="shackWidth" disabled>
        <option value="" disabled selected>Vælg skur bredde her</option>
        <option value="100">Hele carportens bredde</option>
        <option value="50">Halvdelen af carportens bredde</option>
    </select>
</div>

<div class="dropdown">
    <select name="shackLength" id="shackLength" disabled>
        <option value="" disabled selected>Vælg skur længde her</option>
        <% int shackLength;
            for (shackLength = 150; shackLength <= 690; shackLength += 30 ) {
                out.print("<option value=\"" + shackLength + "\">" + shackLength + " cm</option> <br>");
            }
        %>
    </select>
</div>