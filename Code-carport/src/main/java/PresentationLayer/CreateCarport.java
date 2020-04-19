package PresentationLayer;

import FunctionLayer.Carport;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateCarport extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response)  {

        double lenght = Double.parseDouble(request.getParameter("lenght"));
        double width = Double.parseDouble(request.getParameter("width"));
        double height = Double.parseDouble(request.getParameter("height"));

        LogicFacade.createCarport(lenght, width, height);

        return "../index";
    }
}
