package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.Svg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


public class CreateCarport extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {

        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        boolean slope = Boolean.parseBoolean(request.getParameter("checkbox"));
        String roofType;
        int slopeAngle;
        int shackLength;
        int shackWidth;
        boolean shack = Boolean.parseBoolean(request.getParameter("checkbox2"));
        String cladding = request.getParameter("carportMats");
        int stolperAntalLength = 2;
        int stolperAntalWidth = 2;

        if (slope == false) {
            roofType = "plasttrapezplader";
            slopeAngle = 0;
        } else {
            roofType = request.getParameter("roofType");
            slopeAngle = Integer.parseInt(request.getParameter("slope"));
        }
        if (shack == false) {
            shackLength = 0;
            shackWidth = 0;
        } else {
            shackLength = Integer.parseInt(request.getParameter("shackLength"));
            shackWidth = Integer.parseInt(request.getParameter("shackWidth"));
        }
        LogicFacade.createCarport(length, width, height, slope, roofType, slopeAngle, shack, shackLength, shackWidth, cladding);

        Svg svg = new Svg(1000, 1000, "0,0,1000,1000", 0,0);
        svg.addRect(50,50,width, length); //Carport omrids



        if (length > 420 && length <= 630) {
            stolperAntalLength += 1;
        } else if (length > 630) {
            stolperAntalLength += 2;
        }
        if (width > 520) {
            stolperAntalWidth += 1;
        }
        svg.addRect(50,75+2.4,4.5, length); //Rem
        svg.addRect(50,50+width-25+2.4,4.5, length); //Rem

        svg.addRect(50+50,75,9.7, 9.7); //Stolpe
        svg.addRect(50+length-50,75,9.7, 9.7); //Stolpe
        svg.addRect(50+50,50+width-25,9.7, 9.7); //Stolpe
        svg.addRect(50+length-50,50+width-25,9.7, 9.7); //Stolpe


        int antalstolper = stolperAntalLength*stolperAntalWidth;

        if (antalstolper == 6 && stolperAntalLength == 3){
            svg.addRect(50+(length/2),75,9.7, 9.7); //Stolpe
            svg.addRect(50+(length/2),50+width-25,9.7, 9.7); //Stolpe
        } else if ( antalstolper == 6){
            svg.addRect(50,50+(width/2)+2.4,4.5, length); //Rem

            svg.addRect(50+length-50,50+(width/2),9.7, 9.7); //Stolpe
            svg.addRect(50+50,50+(width/2),9.7, 9.7); //Stolpe
        } else if(antalstolper == 8){
            svg.addRect(50+(length/3),75,9.7, 9.7); //Stolpe
            svg.addRect(50+((length/3)*2),75,9.7, 9.7); //Stolpe
            svg.addRect(50+(length/3),50+width-25,9.7, 9.7); //Stolpe
            svg.addRect(50+((length/3)*2),50+width-25,9.7, 9.7); //Stolpe
        } else if (antalstolper == 9){
            svg.addRect(50,50+(width/2)+2.4,4.5, length); //Rem

            svg.addRect(50+(length/2),75,9.7, 9.7); //Stolpe
            svg.addRect(50+50,50+(width/2),9.7, 9.7); //Stolpe
            svg.addRect(50+(length/2),50+width-25,9.7, 9.7); //Stolpe
            svg.addRect(50+(length/2),50+(width/2),9.7, 9.7); //Stolpe
            svg.addRect(50+length-50,50+(width/2),9.7, 9.7); //Stolpe
        } else if (antalstolper == 12){
            svg.addRect(50,50+(width/2)+2.4,4.5, length); //Rem

            svg.addRect(50+(length/3),75,9.7, 9.7); //Stolpe
            svg.addRect(50+((length/3)*2),75,9.7, 9.7); //Stolpe
            svg.addRect(50+(length/3),50+width-25,9.7, 9.7); //Stolpe
            svg.addRect(50+((length/3)*2),50+width-25,9.7, 9.7); //Stolpe
            svg.addRect(50+(length/3),50+(width/2),9.7, 9.7); //Stolpe
            svg.addRect(50+((length/3)*2),50+(width/2),9.7, 9.7); //Stolpe
            svg.addRect(50+50,50+(width/2),9.7, 9.7); //Stolpe
            svg.addRect(50+length-50,50+(width/2),9.7, 9.7); //Stolpe
        }
        request.setAttribute("svgdrawing", svg.toString());



        return "Kvittering";
    }

}