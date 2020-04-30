<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../CSS/hjemmesideBilledeStyle.css" type="text/css">
    <meta name="viewport" content="with=device-width">
    <title>Admin</title>
</head>
<body>
<div>
    ${requestScope.materialList}
</div>
<div>
    <form action="FrontController" method="post">
        <input type="hidden" name="Target" value="updateDBPrice">
        <input type="text" name="updateID" placeholder="Skriv ID her">
        <input type="text" name="updatePrice" placeholder="Skriv ny pris her">
        <input type="submit" value="Updater pris">
    </form>
</div>
<div>
    <div class="textOverImage"
         style="background-image:url(../pics/traestolpe.jpg)"
         data-text="Træstolpen er en opretstående, fast forankret bjælke, der støtter eller bærer øvrige dele i en bygningskonstruktion">
    </div>

    <div class="textOverImage"
         style="background-image:url(../pics/rembilledefix.jpg)"
         data-text="Rem: vandret bjælke der indgår i en bygnings bærende konstruktion fx som underlag for væggenes lodrette bjælker eller for tagkonstruktionen">
    </div>

    <div class="textOverImage"
         style="background-image:url(../pics/spaerbillede.jpg)"
         data-text="Et spær er den mest elementære del af skelettet i en tagkonstruktion, altså skelettet af taget">
    </div>

    <div class="textOverImage"
         style="background-image:url(../pics/Sternbillede.jpg)"
         data-text="sternbræt: bræt anbragt under tagskægget på en carport for at dække mellemrummet mellem tagkanten og facaden">
    </div>

    <div class="textOverImage"
         style="background-image:url(../pics/soembillede.jpg)"
         data-text="Et søm er en lille, spids metalpind forsynet med et (fladt) hoved og beregnet til at blive slået ind i noget, som regel med en hammer, for at samle eller fastgøre det">
    </div>

    <div class="textOverImage"
         style="background-image:url(../pics/Skrurer.jpg)"
         data-text="Skrue er en lille metalpind med fladt eller rundt hoved og med et gevind der kan drejes ind i et materiale så genstande samles eller sættes fast">
    </div>

    <div class="textOverImage"
         style="background-image:url(../pics/hulbaand.jpg)"
         data-text="Hulbånd er et langt, smalt stykke metal med huller i der fx bruges til at bære et vandrør eller sammenholde en tømmerkonstruktion, idet båndet fastgøres eller låses med søm eller skruer gennem hullerne">
    </div>
</div>
</body>
</html>
