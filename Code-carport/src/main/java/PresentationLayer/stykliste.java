package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class stykliste extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        int id = Integer.parseInt(request.getParameter("carportID"));
        String stykliste = LogicFacade.styklisteForCarport(id);

        request.setAttribute("stykliste", stykliste);


        return "stykliste";
    }
}