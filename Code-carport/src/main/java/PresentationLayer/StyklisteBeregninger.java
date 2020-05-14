package PresentationLayer;

import DBAccess.MaterialsMapper;
import FunctionLayer.Materials;

import java.util.HashMap;

import static java.lang.Math.pow;

/**
 * The type Stykliste beregninger.
 * Her er alt vi bruger til at lave styklisten
 */
public class StyklisteBeregninger {

    private static double LosholterSide = 0;
    private static double LosholterFront = 0;
    private static double VinskederLength = 0;
    private static double WoodLength = 0;
    private static double AntalPlankerSide = 0;
    private static double AntalPlankerFront = 0;
    private static int stolperAntalLength = 2;
    private static int stolperAntalWidth = 2;
    private static HashMap<Integer, Materials> materialer = MaterialsMapper.hashMapAfMaterialer();

    /**
     * Calculate vinskeder length double.
     * En metode der udregner længden fra bunden af taget til toppen af taget
     * vi bruger tangents af vinklen til taget for at få modstående katete og vi kender allerede hosliggende katete
     * og så når vi kender dem kan vi bruge pytagoras' læresætning for at finde hypotenusen og det er hypotenusen vi gerne vil ha'
     *
     * @param width      bredden af carporten
     * @param slopeAngle carporten vinkel på taget
     * @return double en længde af det skrå stykke af taget
     */
    public static double CalculateVinskederLength(int width, int slopeAngle) {
        double temp = (width / 2);
        VinskederLength = 2 * Math.sqrt(Math.pow((temp) * Math.tan(slopeAngle), 2.0) + pow(temp, 2));
        return VinskederLength;
    }

    //Udregner Længden af
    public static double CalculateRoofWood(int Length, int width, int slopeAngle) {
        double Vinskeder = CalculateVinskederLength(width, slopeAngle);
        WoodLength = Length * ((Vinskeder / 50) * 2);
        return WoodLength;
    }

    /**
     * Calculate cladding front double.
     * En metode som tager længden af skuret og så fordi at vores planker der skal bruges til
     * skuret er 10 cm brede har vi valgt at dividere med 8 så der er udregnet noget overlap på de planker når de kommer op
     * og hænge. vi ganger med 2 fordi at der er 2 af den slags sider. Vi bruger så Math.ceil for at runde det tal op
     * og vi returnere så det antal
     *
     * @param shackLength skurets længde
     * @return double som er antallet af planker
     */
    public static double CalculateCladdingSide(int shackLength) {
        AntalPlankerSide = (shackLength * 2) / 8; // 8 er et tal vi har valgt fordi at plankerne vi bruger er 10 cm bredde men vi gør plads til overlap når plankerne skal sidde på hinanden
        return Math.ceil(AntalPlankerSide);
    }

    /**
     * Calculate cladding front double.
     * En metode som tager bredden af skuret og så fordi at vores planker der skal bruges til
     * skuret er 10 cm brede har vi valgt at dividere med 8 så der er udregnet noget overlap på de planker når de kommer op
     * og hænge. vi ganger med 2 fordi at der er 2 af den slags sider. Vi bruger så Math.ceil for at runde det tal op
     * og vi returnere så det antal
     *
     * @param shackWidth skurets bredde
     * @return double som er antallet af planker
     */
    public static double CalculateCladdingFront(int shackWidth) {
        AntalPlankerFront = ((shackWidth * 2) / 8);
        return Math.ceil(AntalPlankerFront);
    }

    /**
     * Total planker skur string.
     * En metoder der udregner hvor mange planker der skal bruges til skuret.
     *
     * @param shackWidth  bredden af skuret
     * @param shackLength længden af skuret
     * @return String med antallet af planker der skal bruges til skuret
     */
    public static String totalPlankerSkur(int shackWidth, int shackLength) {
        int sidePlanker = (int) CalculateCladdingSide(shackLength);
        int frontPlanker = (int) CalculateCladdingFront(shackWidth);
        int totalPlanker = sidePlanker + frontPlanker;
        String total = "Total antal planker til skuret: " + totalPlanker + "<br>";
        return total;
    }


    /**
     * Calculate stolper string.
     * En metode som udregner det antal stolper der skal bruges ud fra den carport som der er blevet valgt.
     * og returnere en string med det antal af stolper
     *
     * @param length længden af carporten
     * @param width  bredden af carporten
     * @param height højden af carporten
     * @return Den returnere en string som fortæller antallet af 2 forskellige stolpe typer vi har i databasen
     */
    public static String calculateStolper(int length, int width, int height) {
        stolperAntalLength = 2;
        stolperAntalWidth = 2;

        if (length > 420 && length <= 630) {
            stolperAntalLength += 1;
        } else if (length > 630) {
            stolperAntalLength += 2;
        }
        if (width > 520) {
            stolperAntalWidth += 1;
        }
        int antalStolper = stolperAntalLength * stolperAntalWidth;
        int cmStolpe = height * antalStolper;

        Materials stolpe1 = materialer.get(1);
        Materials stolpe2 = materialer.get(43);
        int stolpe1Length = stolpe1.getMatLength();
        int stolpe2Length = stolpe2.getMatLength();

        int stolpeMath1 = cmStolpe / stolpe1Length;
        int stolpeExtra1 = cmStolpe % stolpe1Length;

        int stolpeMath2 = stolpeExtra1 / stolpe2Length;
        int stolpeExtra2 = stolpeExtra1 % stolpe2Length;

        if (stolpeExtra2 > 0) {
            stolpeMath2 += 1;
        }
        String stolpeAntal1 = "Antal: " + stolpeMath1 + " Længden: " + stolpe1.getMatLength() + " cm. Type: " + stolpe1.getMatType() + "<br>";
        String stolpeAntal2 = "Antal: " + stolpeMath2 + " Længden: " + stolpe2.getMatLength() + " cm. Type: " + stolpe2.getMatType() + "<br>";
        if (stolpeMath2 == 0) {
            return stolpeAntal1;
        } else {
            return stolpeAntal1 + "  " + stolpeAntal2;
        }
    }

    /**
     * Den her metode skal kaldes efter calculateStolper ellers virker det ikke
     * Calculate rem string.
     * Metoden udregner det rem vi skal bruge og returnere en string som fortæller hvor meget.
     *
     * @param length længed af carporten
     * @return en string med antallet af, og muligvis, forskellig antal længder af rem brædder
     */
    public static String calculateRem(int length) {
        int maxRemLength = length * stolperAntalWidth;

        Materials rem1 = materialer.get(12);
        Materials rem2 = materialer.get(13);
        int rem1Length = rem1.getMatLength();
        int rem2Length = rem2.getMatLength();

        int remMath1 = maxRemLength / rem1Length;
        int remExtra1 = maxRemLength % rem1Length;
        int remMath2 = remExtra1 / rem2Length;
        int remExtra2 = remExtra1 % rem2Length;

        if (remExtra2 > 0) {
            remMath2 += 1;
        }

        String remAntal1 = "Antal: " + remMath1 + " Længde: " + rem1.getMatLength() + " cm. Type: " + rem1.getMatType() + "<br>";
        String remAntal2 = "Antal: " + remMath2 + " Længde: " + rem2.getMatLength() + " cm. Type: " + rem2.getMatType() + "<br>";

        if (remMath2 == 0) {
            return remAntal1;
        } else {
            return remAntal1 + "  " + remAntal2;
        }
    }

    /**
     * Calculate spaer fladt tag string.
     * udregner antallet af spær der skal bruges til en carpot med fladt tag
     * og returnere en string med antallet
     *
     * @param length længden af carporten
     * @param width  bredden af carporten
     * @return antal af spær
     */
    public static String calculateSpaerFladtTag(int length, int width) {
        int spaerAntalRaekker = length / 80; // 80 er den længde der skal være mellem spær
        int maxSpaerLength = spaerAntalRaekker * width;

        Materials spaer1 = materialer.get(2);
        Materials spaer2 = materialer.get(3);
        int spaer1Length = spaer1.getMatLength();
        int spaer2Length = spaer2.getMatLength();

        int spaerMath1 = maxSpaerLength / spaer1Length;
        int spaerExtra1 = maxSpaerLength % spaer1Length;
        int spaerMath2 = spaerExtra1 / spaer2Length;
        int spaerExtra2 = spaerExtra1 % spaer2Length;

        if (spaerExtra2 > 0) {
            spaerMath2 += 1;
        }

        String spaerAntal1 = "Antal: " + spaerMath1 + " Længde: " + spaer1.getMatLength() + " cm. Type: " + spaer1.getMatType() + "<br>";
        String spaerAntal2 = "Antal: " + spaerMath2 + " Længde: " + spaer2.getMatLength() + " cm. Type: " + spaer2.getMatType() + "<br>";

        if (spaerMath2 == 0) {
            return spaerAntal1;
        } else {
            return spaerAntal1 + "  " + spaerAntal2;
        }
    }

    /**
     * Calculate spaer rejsning string.
     * udregner antallet af spær der skal bruges til en carpot med skråt tag
     * og returnere en string med antallet
     *
     * @param length     længden af carporten
     * @param width      bredden af carporten
     * @param slopeAngle vinklen som der er på det skrå tag på carpoten (kunden har valgt)
     * @return string med antallet af spær der skal bruges på skrå tag
     */
    public static String calculateSpaerRejsning(int length, int width, int slopeAngle) {
        int spaerAntalRaekker = length / 80; // 80 er den længde der skal være mellem spær
        double hypotenusenx2 = CalculateVinskederLength(width, slopeAngle);
        int maxSpaerLength = ((int) hypotenusenx2 + width) * spaerAntalRaekker;

        Materials spaer1 = materialer.get(2);
        Materials spaer2 = materialer.get(3);
        int spaer1Length = spaer1.getMatLength();
        int spaer2Length = spaer2.getMatLength();

        int spaerMath1 = maxSpaerLength / spaer1Length;
        int spaerExtra1 = maxSpaerLength % spaer1Length;
        int spaerMath2 = spaerExtra1 / spaer2Length;
        int spaerExtra2 = spaerExtra1 % spaer2Length;

        if (spaerExtra2 > 0) {
            spaerMath2 += 1;
        }

        String spaerAntal1 = "Antal: " + spaerMath1 + " Længde: " + spaer1.getMatLength() + " cm. Type: " + spaer1.getMatType() + "<br>";
        String spaerAntal2 = "Antal: " + spaerMath2 + " Længde: " + spaer2.getMatLength() + " cm. Type: " + spaer2.getMatType() + "<br>";

        if (spaerMath2 == 0) {
            return spaerAntal1;
        } else {
            return spaerAntal1 + "  " + spaerAntal2;
        }
    }
}


