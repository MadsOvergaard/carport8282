<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../CSS/hjemmesideBilledeStyle.css" type="text/css">
    <meta name="viewport" content="with=device-width">
    <title>Admin</title>
    <style>
        .container {
            position: relative;
            width: 300px;
        }

        .image {
            opacity: 1;
            display: block;
            width: 300px;
            height: 300px;
            transition: .5s ease;
            backface-visibility: hidden;
        }

        .middle {
            transition: .5s ease;
            opacity: 0;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            -ms-transform: translate(-50%, -50%);
            text-align: center;
        }

        .container:hover .image {
            opacity: 0.3;
        }

        .container:hover .middle {
            opacity: 1;
        }

        .text {
            background-color: #031704;
            color: white;
            font-size: 16px;
            padding: 16px 32px;
        }
    </style>
</head>
<body>
<div>
    ${requestScope.materialList}
</div>
<div>
    <p>Updater prisen på noget her</p>
    <form action="FrontController" method="post">
        <input type="hidden" name="target" value="updateDBPrice">
        <input type="text" name="updateID" placeholder="Skriv ID her">
        <input type="text" name="updatePrice" placeholder="Skriv ny pris her">
        <input type="submit" value="Updater pris">
    </form>
</div>
<div>
    <p>Tilføj et nyt materiale her obs. længden skal være i cm og resten i mm.</p>
    <form action="FrontController" method="post">
        <input type="hidden" name="target" value="addDBMaterial">
        <input type="text" name="newMaterial" placeholder="Skriv materiale her">
        <input type="text" name="materialLength" placeholder="Skriv materiale længden her">
        <input type="text" name="materialWidth" placeholder="Skriv materiale bredden her">
        <input type="text" name="materialHeight" placeholder="Skriv materiale højden her">
        <input type="text" name="materialDetail" placeholder="Skriv materiale beskrivelsen her">
        <input type="text" name="materialPrice" placeholder="Skriv materiale prisen her">
        <input type="submit" value="Updater materiale">
    </form>
</div>
<div class="container">
    <img src="./pics/traestolpe.jpg" alt="Avatar" class="image" style="width:100%">
    <div class="middle">
        <div class="text">Træstolpen er en opretstående, fast forankret bjælke, der støtter eller bærer øvrige dele
            i en bygningskonstruktion
        </div>
    </div>
</div>
<div class="container">
    <img src="./pics/rembilledefix.jpg" alt="Avatar" class="image" style="width:100%">
    <div class="middle">
        <div class="text">Rem: vandret bjælke der indgår i en bygnings bærende konstruktion fx som underlag for
            væggenes lodrette bjælker eller for tagkonstruktionen
        </div>
    </div>
</div>
<div class="container">
    <img src="./pics/spaerbillede.jpg" alt="Avatar" class="image" style="width:100%">
    <div class="middle">
        <div class="text">Et spær er den mest elementære del af skelettet i en tagkonstruktion, altså skelettet af
            taget
        </div>
    </div>
</div>
<div class="container">
    <img src="./pics/sternbillede.jpg" alt="Avatar" class="image" style="width:100%">
    <div class="middle">
        <div class="text">sternbræt: bræt anbragt under tagskægget på en carport for at dække mellemrummet mellem
            tagkanten og facaden
        </div>
    </div>
</div>
<div class="container">
    <img src="./pics/soembillede.jpg" alt="Avatar" class="image" style="width:100%">
    <div class="middle">
        <div class="text">Et søm er en lille, spids metalpind forsynet med et (fladt) hoved og beregnet til at blive
            slået ind i noget, som regel med en hammer, for at samle eller fastgøre det
        </div>
    </div>
</div>
<div class="container">
    <img src="./pics/skrurer.jpg" alt="Avatar" class="image" style="width:100%">
    <div class="middle">
        <div class="text">Skrue er en lille metalpind med fladt eller rundt hoved og med et gevind der kan drejes ind i
            et materiale så genstande samles eller sættes fast
        </div>
    </div>
</div>
<div class="container">
    <img src="./pics/hulbaand.jpg" alt="Avatar" class="image" style="width:100%">
    <div class="middle">
        <div class="text">Hulbånd er et langt, smalt stykke metal med huller i der fx bruges til at bære et vandrør
            eller sammenholde en tømmerkonstruktion, idet båndet fastgøres eller låses med søm eller skruer gennem
            hullerne
        </div>
    </div>
</div>

</body>
</html>
