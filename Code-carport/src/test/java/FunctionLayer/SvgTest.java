package FunctionLayer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SvgTest {

    Svg svgTest;

    @Before
    public void setUp() {
        svgTest = new Svg(600,600,"0, 0, 1000, 1000",0,0);
    }

    @Test
    public void addRect01(){
        svgTest.addRect(50,50,32,32);
        String expected = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
                "height=\"600.0\" width=\"600.0\" viewbox=\"0, 0, 1000, 1000\" preserveAspectRatio=\"xMinY;om\">"+
                "<rect x=\"50,000000\" y=\"50,000000\" height=\"32,000000\" width=\"32,000000\" style=\"Stroke:#000000; fill: #ffffff\" />" + "</svg>";
        assertEquals(svgTest.toString(),expected);
    }

    @Test
    public void addRectRotate01(){
        svgTest.addRectRotate(51,50,33,32,45,15,25);
        String expected = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" " +
                "height=\"600.0\" width=\"600.0\" viewbox=\"0, 0, 1000, 1000\" preserveAspectRatio=\"xMinY;om\">" + "<rect x=\"51,000000\" y=\"50,000000\" height=\"33,000000\" width=\"32,000000\" " +
                "style=\"Stroke:#000000; fill: #ffffff\" transform=\"rotate(45,000000, 15,000000, 25,000000)\" />" + "</svg>";
        assertEquals(svgTest.toString(),expected);
    }

}