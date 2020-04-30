package PresentationLayer;

import FunctionLayer.LogicFacade;

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

        return "../index";
    }
}