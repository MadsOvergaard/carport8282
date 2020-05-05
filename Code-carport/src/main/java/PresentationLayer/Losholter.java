package PresentationLayer;


import static java.lang.Math.*;

public class Losholter {

    private static double length = 0;
    private static double length2 = 0;

    //Udregner Længden af
    public static double CalculateLosholterSide(int shackLength) {
        length = (shackLength - (2*9.7))*2;

        return length;

    }
    public static double CalculateLosholterFront(int shackWidth) {
        length2 = ((shackWidth - (2*9.7)-1)*2)-110;

        return length2;

    }

}


