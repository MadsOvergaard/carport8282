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

        //todo gør så at man kan hente den her array fra index siden
        ArrayList<Integer> listLength = new ArrayList<>();
        listLength.add(480);
        listLength.add(520);
        listLength.add(560);
        listLength.add(600);
        listLength.add(640);
        listLength.add(680);
        listLength.add(720);
        listLength.add(760);
        listLength.add(800);
        listLength.add(840);
        listLength.add(880);
        listLength.add(920);
//        for (int i = 480; i < 920; i += 40) {
//            listLength.add(i);
//        }
        request.setAttribute("listLength", listLength);

        LogicFacade.createCarport(length, width, height);

        return "../index";
    }
}
