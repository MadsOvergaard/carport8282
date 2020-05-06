package PresentationLayer;


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
        LosholterSide = (shackLength - (2*9.7))*2;

        return LosholterSide;

    }
    public static double CalculateLosholterFront(int shackWidth) {
        LosholterFront = ((shackWidth - (2*9.7)-1)*2)-110;

        return LosholterFront;

    }
    //Udregner Længden af det skrå tag
    public static double CalculateVinskederLength(int width, int slopeAngle) {
        double temp = (width / 2);
        VinskederLength = 2 * Math.sqrt(Math.pow((width / 2) * Math.tan(slopeAngle), 2.0) + pow(temp, 2));

        return VinskederLength;

    }

    //Udregner Længden af
    public static double CalculateRoofWood(int Length,int width, int slopeAngle) {
        double Vinskeder = CalculateVinskederLength(width, slopeAngle);
        WoodLength = Length*((Vinskeder/50)*2);


        return WoodLength;

    }


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


