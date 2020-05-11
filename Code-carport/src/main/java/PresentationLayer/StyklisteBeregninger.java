package PresentationLayer;


import DBAccess.MaterialsMapper;
import FunctionLayer.materials;

import java.util.HashMap;

import static java.lang.Math.pow;

public class StyklisteBeregninger {

    private static double LosholterSide = 0;
    private static double LosholterFront = 0;
    private static double VinskederLength = 0;
    private static double WoodLength = 0;
    private static double AntalPlankerSide = 0;
    private static double AntalPlankerFront = 0;
    private static int stolperAntalLength = 2;
    private static int stolperAntalWidth = 2;


    //Udregner Længden af Losholter
    public static double CalculateLosholterSide(int shackLength) {
        LosholterSide = (shackLength - (2 * 9.7)) * 2;

        return LosholterSide;

    }

    public static double CalculateLosholterFront(int shackWidth) {
        LosholterFront = ((shackWidth - (2 * 9.7) - 1) * 2) - 110;

        return LosholterFront;

    }

    //Udregner Længden af det skrå tag
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


    //Udregner Længden af
    public static double CalculateCladdingSide(int shackWidth) {
        AntalPlankerSide = (shackWidth / 8) * 2;

        return Math.ceil(AntalPlankerSide);

    }

    public static double CalculateCladdingFront(int shackLength) {
        AntalPlankerFront = ((shackLength / 8) * 2) - 110;

        return Math.ceil(AntalPlankerFront);

    }

    //Pepega stolpe udregner todo Det her er ikke dynamisk!!!
    public static String calculateStolper(int length, int width, int height) {
        stolperAntalLength = 2;
        stolperAntalWidth = 2;
        HashMap<String, FunctionLayer.materials> materialer = MaterialsMapper.hashMapAfMaterialer();

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

        materials stolpe1 = materialer.get("Trykimpregneret stolpe1");
        materials stolpe2 = materialer.get("Trykimpregneret stolpe43");
        int stolpe1Length = stolpe1.getMatLength();
        int stolpe2Length = stolpe2.getMatLength();

        int stolpeMath1 = cmStolpe / stolpe1Length;
        int stolpeExtra1 = cmStolpe % stolpe1Length;

        int stolpeMath2 = stolpeExtra1 / stolpe2Length;
        int stolpeExtra2 = stolpeExtra1 % stolpe2Length;

        if (stolpeExtra2 > 0) {
            stolpeMath2 += 1;
        }
        String stolpeAntal1 = stolpeMath1 + stolpe1.getMatLength() + stolpe1.getMatType();
        String stolpeAntal2 = stolpeMath2 + stolpe2.getMatLength() + stolpe2.getMatType();

        return stolpeAntal1 + " " + stolpeAntal2;
    }

    // Den her metode skal kaldes efter calculateStolper ellers virker det ikke
    public static String calculateRem(int length) {
        HashMap<String, FunctionLayer.materials> materialer = MaterialsMapper.hashMapAfMaterialer();
        int maxRemLength = length * stolperAntalWidth;

        materials rem1 = materialer.get("Reglar ub.12");
        materials rem2 = materialer.get("Reglar ub.13");
        int rem1Length = rem1.getMatLength();
        int rem2Length = rem2.getMatLength();

        int remMath1 = maxRemLength / rem1Length;
        int remExtra1 = maxRemLength % rem1Length;
        int remMath2 = remExtra1 / rem2Length;
        int remExtra2 = remExtra1 % rem2Length;

        if (remExtra2 > 0) {
            remMath2 += 1;
        }

        String remAntal1 = remMath1 + " " + rem1.getMatLength() + " " + rem1.getMatType();
        String remAntal2 = remMath2 + " " + rem2.getMatLength() + " " + rem2.getMatType();

        return remAntal1 + " " + remAntal2;
    }

    public static String calculateSpaerFladtTag(int length, int width) {
        HashMap<String, FunctionLayer.materials> materialer = MaterialsMapper.hashMapAfMaterialer();
        int spaerAntalRaekker = length / 80; // 80 er den længde der skal være mellem spær
        int maxSpaerLength = spaerAntalRaekker * width;

        materials spaer1 = materialer.get("Spærtræ2");
        materials spaer2 = materialer.get("Spærtræ3");
        int spaer1Length = spaer1.getMatLength();
        int spaer2Length = spaer2.getMatLength();

        int spaerMath1 = maxSpaerLength / spaer1Length;
        int spaerExtra1 = maxSpaerLength % spaer1Length;
        int spaerMath2 = spaerExtra1 / spaer2Length;
        int spaerExtra2 = spaerExtra1 % spaer2Length;

        if (spaerExtra2 > 0) {
            spaerMath2 += 1;
        }

        String spaerAntal1 = spaerMath1 + " " + spaer1.getMatLength() + " " + spaer1.getMatType();
        String spaerAntal2 = spaerMath2 + " " + spaer2.getMatLength() + " " + spaer2.getMatType();
        return spaerAntal1 + " " + spaerAntal2;
    }

    public static String calculateSpaerRejsning(int length, int width, int slopeAngle) {
        HashMap<String, FunctionLayer.materials> materialer = MaterialsMapper.hashMapAfMaterialer();
        int spaerAntalRaekker = length / 80; // 80 er den længde der skal være mellem spær
        double hypotenusenx2 = CalculateVinskederLength(width, slopeAngle);
        int maxSpaerLength = ((int)hypotenusenx2 + width)*spaerAntalRaekker;

        materials spaer1 = materialer.get("Spærtræ2");
        materials spaer2 = materialer.get("Spærtræ3");
        int spaer1Length = spaer1.getMatLength();
        int spaer2Length = spaer2.getMatLength();

        int spaerMath1 = maxSpaerLength / spaer1Length;
        int spaerExtra1 = maxSpaerLength % spaer1Length;
        int spaerMath2 = spaerExtra1 / spaer2Length;
        int spaerExtra2 = spaerExtra1 % spaer2Length;

        if (spaerExtra2 > 0) {
            spaerMath2 += 1;
        }

        String spaerAntal1 = spaerMath1 + " " + spaer1.getMatLength() + " " + spaer1.getMatType();
        String spaerAntal2 = spaerMath2 + " " + spaer2.getMatLength() + " " + spaer2.getMatType();
        return spaerAntal1 + " " + spaerAntal2;
    }

}


