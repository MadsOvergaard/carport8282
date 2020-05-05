package PresentationLayer;
import

import static PresentationLayer.VinskederLength.CalculateVinskederLength;
import static java.lang.Math.*;

public class RoofWood {

    private static double WoodLength = 0;



    //Udregner Længden af
    public static double CalculateRoofWood(int Length,int width, int slopeAngle) {
        double Vinskeder = CalculateVinskederLength(width, slopeAngle);
        WoodLength = Length*((Vinskeder/50)*2);


        return WoodLength;

    }




}


