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
        VinskederLength = 2 * Math.sqrt(Math.pow((width / 2) * Math.tan(slopeAngle), 2.0) + pow(temp, 2));

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
        HashMap<String, FunctionLayer.materials> materialer = MaterialsMapper.hashMapAfMaterialer();
        int stolperAntalWidth = 2;
        int stolperAntalLength = 2;

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

        materials stolpeLength1 = materialer.get("Trykimpregneret stolpe1");
        materials stolpeLength2 = materialer.get("Trykimpregneret stolpe43");

        int stl1 = stolpeLength1.getMatLength();
        int stl2 = stolpeLength2.getMatLength();

        int stolpeMath1 = cmStolpe / stl1;
        int stolpeExtra1 = cmStolpe % stl1;

        int stolpeMath2 = stolpeExtra1 / stl2;
        int stolpeExtra2 = stolpeExtra1 % stl2;

        if (stolpeExtra2 > 0) {
            stolpeMath2 += 1;
        }
        String stolpeAntal1 = stolpeMath1 + stolpeLength1.getMatLength() + stolpeLength1.getMatType();
        String stolpeAntal2 = stolpeMath2 + stolpeLength2.getMatLength() + stolpeLength2.getMatType();

        return stolpeAntal1 + " " + stolpeAntal2;
    }

}


