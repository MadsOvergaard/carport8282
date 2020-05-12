package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Svg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Drawing extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        Svg svg = new Svg(800, 600, "0,0,800,600", 0,0);
        svg.addRect(0,50,,45); //Rem


        return "drawing";
    }
}
