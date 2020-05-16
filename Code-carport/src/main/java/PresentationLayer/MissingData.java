package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.MissingDataException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MissingData extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws MissingDataException {
        String msg = "Der er et eller flere felter der mangler at blive udfyldt";
        throw new MissingDataException( msg );
    }
}
