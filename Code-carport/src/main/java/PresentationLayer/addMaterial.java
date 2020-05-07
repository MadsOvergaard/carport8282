package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addMaterial extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String material = request.getParameter("newMaterial");
        int length = Integer.parseInt(request.getParameter("materialLength"));
        int width = Integer.parseInt(request.getParameter("materialWidth"));;
        int height = Integer.parseInt(request.getParameter("materialHeight"));;
        String detail = request.getParameter("materialDetail");
        int price = Integer.parseInt(request.getParameter("materialPrice"));;

        LogicFacade.addMaterial(material, length, width, height, detail, price);

        return "index";
    }
}
