<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<head>

    <link rel="stylesheet" href="CSS/CarportDropdown.css" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="includes/Check.js"></script>
    <title>Welcome page</title>

    <!-- Bootstrap CDN-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <!--custom stylesheet-->
    <link rel="stylesheet" href="CSS/indexstyle.css" type="text/css">
</head>
<body>

<!--header-->
<header>
    <div class="container"></div>
    <div class="row">
    <div class="col-md-4 col-sm-12 col-12">
        <img src="./pics/foglogo.jpg" class="img-fluid" alt="Responsive image">


    </div>
        <div class="col-md-4 col-12 text-center">
            <h2 class="my-md-5 site-title text-white">Byg din carport her</h2>
        </div>
     <div class="col-md-4 col-12 text-right">
         <p class="my-md-4 header-links">
           <a href="WEB-INF/admin.jsp" class="px-1">Admin Side</a>
         </p>
     </div>
    </div>

</header>
<!--header-->

<main>
    <h2 class="my-md-5 text-center text-white">Vælg dimensioner til carporten</h2>
    <div class="container">
        <div class="form-group" style="text-align:center">
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
            </div>
    </div>
    </div>
</main>
<footer></footer>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>




<form action="FrontController" method="post">
    <input type="hidden" name="target" value="admin">
    <input type="submit" value="adminsiden version alpha 1.0">
</form>

<c:if test="${requestScope.error!= null}">
    <h2>Error ! </h2>
    ${requestScope.error}
</c:if>
</body>
</html>
