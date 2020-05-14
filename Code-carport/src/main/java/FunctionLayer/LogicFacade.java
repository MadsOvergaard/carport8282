package FunctionLayer;

import DBAccess.CarportMapper;
import DBAccess.UserMapper;
import PresentationLayer.StyklisteBeregninger;

public class LogicFacade {

    // ikke vores. bliver ikke brugt til noget
    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }
    // ikke vores. bliver ikke brugt til noget
    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    /**
     * Create carport carport.
     * Det her er en mellemmand mellem PresentationLayer og DBAccess
     *
     * @param length      længden af carporten
     * @param width       bredden af carporten
     * @param height      højden af carporten
     * @param slope       En boolean som hvis er true betyder det at der er rejsning på taget af carporten
     * @param roofType    teglbeklædningen af carporten
     * @param slopeAngle  vinklen af carportens tag
     * @param shack       En boolean som hvis er true betyder at der skal et skur med til carporten
     * @param shackLength skurets længde
     * @param shackWidth  skurets bredde
     * @param cladding    beklædningen af carporten
     * @return Returnere en carport objekt
     */
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

    public static String styklisteForCarport(int id) {
        Carport carport = CarportMapper.styklisteCarport(id);

        String stolper = StyklisteBeregninger.calculateStolper(carport.getLength(), carport.getWidth(), carport.getHeight());
        String rem = StyklisteBeregninger.calculateRem(carport.getLength());
        String spaer;
        String skurPlanker;
        int width;

        // En lille statement som bestemmer bredden af carportents skur. Fordi værdien den ellers ville få ville bare være 50 eller 100.
        // Som i 50% af bredden eller 100% af bredden af carporten
        if (carport.getShackWidth() == 50) {
            width = carport.getWidth() / 2;
        } else {
            width = carport.getWidth();
        }

        if (carport.isSlope()) {
            spaer = StyklisteBeregninger.calculateSpaerRejsning(carport.getLength(), carport.getWidth(), carport.getSlopeAngle());
        } else {
            spaer = StyklisteBeregninger.calculateSpaerFladtTag(carport.getLength(), carport.getWidth());
        }

        if (carport.isShack()) {
            skurPlanker = StyklisteBeregninger.totalPlankerSkur(width, carport.getShackLength());
        } else {
            skurPlanker = "";
        }

        return stolper + rem + spaer + skurPlanker;

    }

}
