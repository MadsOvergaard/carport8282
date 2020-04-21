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

    public static Carport createCarport(int length, int width, int height, boolean slope, String roofType, int slopeAngle) {
        Carport carport = new Carport(length, width, height, slope, roofType, slopeAngle);
        CarportMapper.createCarport(carport);
        return carport;
    }

}
