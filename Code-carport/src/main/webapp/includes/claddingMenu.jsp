<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="DBAccess.CarportMapper" %>

<h2>Vælg beklædning til carporten og skuret her</h2>

<div class="dropdown">
    <select  name="carportMats">
        <option value="" disabled selected>Vælg carport beklædning her</option>
        <c:forEach var="i" items="${CarportMapper.cladding()}" varStatus="count">
            <option value="${count.current}">${i.toString()}</option>
        </c:forEach>
    </select>
</div>