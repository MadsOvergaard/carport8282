package PresentationLayer;


import static java.lang.Math.*;

public class Cladding {

    private static double AntalPlankerSide = 0;
    private static double AntalPlankerFront = 0;

    //Udregner Længden af
    public static double CalculateCladdingSide(int shackWidth) {
        AntalPlankerSide = (shackWidth/8)*2;

        return Math.ceil(AntalPlankerSide);

    }

    public static double CalculateCladdingFront(int shackLength) {
        AntalPlankerFront = ((shackLength/8)*2)-110;

        return Math.ceil(AntalPlankerFront);

    }


}


