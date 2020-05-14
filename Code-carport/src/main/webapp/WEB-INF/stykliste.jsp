<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title>stykliste</title>
</head>
<body>
<h1>Stykliste for Carport: ${requestScope.id}</h1>
${requestScope.stykliste}
</body>
</html>
