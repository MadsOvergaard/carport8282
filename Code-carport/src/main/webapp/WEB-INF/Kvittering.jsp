<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Kvittering</title>
</head>
<body>
    <h1>Carport set ovenfra</h1>
    ${requestScope.svgdrawing}
    <h1>Carport set fra fronten</h1>
    ${requestScope.svg2drawing}
</body>
</html>
