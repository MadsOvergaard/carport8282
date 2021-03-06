package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.MissingDataException;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("login", new Login());
        commands.put("register", new Register());
        commands.put("carport", new CreateCarport());
        commands.put("admin", new Admin());
        commands.put("updateDBPrice", new Price());
        commands.put("addDBMaterial", new AddMaterial());
        commands.put("stykliste", new Stykliste());
    }

    static Command from(HttpServletRequest request) {
        String targetName = request.getParameter("target");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(targetName, new UnknownCommand());   // unknowncommand er default.
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws LoginSampleException, MissingDataException;

}
