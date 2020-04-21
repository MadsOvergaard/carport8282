package PresentationLayer;

import FunctionLayer.LogicFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


public class CreateCarport extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {

        String defaultRoofType = "plasttrapezplader";
        int defaultSlopeAngle = 0;
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        boolean slope = Boolean.parseBoolean(request.getParameter("checkbox"));
        String roofType = request.getParameter("roofType");


        if (slope == false) {
            LogicFacade.createCarport(length, width, height, slope, defaultRoofType, defaultSlopeAngle);
        } else {
            int slopeAngle = Integer.parseInt(request.getParameter("slope"));
            LogicFacade.createCarport(length, width, height, slope, roofType, slopeAngle);
        }
        return "../index";
    }
}
//todo gør så at man kan hente den her array fra index siden
//  ArrayList<Integer> listLength = new ArrayList<>();
//        for (int i = 480; i < 920; i += 40) {
//            listLength.add(i);
//        }
//      request.setAttribute("listLength", listLength);