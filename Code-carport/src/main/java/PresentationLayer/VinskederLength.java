package PresentationLayer;


import static java.lang.Math.*;

public class VinskederLength {

        private static double length = 0;

        //Udregner Længden af det skrå tag
        public static double CalculateVinskederLength(int width, int slopeAngle) {
            double temp = (width / 2);
            length = 2 * Math.sqrt(Math.pow((width / 2) * Math.tan(slopeAngle), 2.0) + pow(temp, 2));

            return length;

        }
    }


