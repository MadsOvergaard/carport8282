package FunctionLayer;

import DBAccess.CarportMapper;
import DBAccess.UserMapper;

public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static Carport createCarport(double length, double width, double height) {
        Carport carport = new Carport(length, width, height);
        CarportMapper.createCarport(carport);
        return carport;
    }

}
