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

    public static Carport createCarport(int length, int width, int height, boolean slope, String roofType, int slopeAngle,
                                        boolean shack, int shackLength, int shackWidth, String cladding) {
        Carport carport = new Carport(length, width, height, slope, roofType, slopeAngle, shack, shackLength, shackWidth, cladding);
        CarportMapper.createCarport(carport);
        return carport;
    }

    public static void updatePrice(double price, int id) {
        CarportMapper.updatePriceInDB(price, id);
    }

    public static void addMaterial(String type, int length, int width, int height, String detail, int price) {
        CarportMapper.addMaterialInDB(type, length, width, height, detail, price);
    }

}
