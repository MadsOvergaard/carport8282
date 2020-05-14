package DBAccess;

import FunctionLayer.Carport;
import FunctionLayer.LoginSampleException;

import java.sql.*;
import java.util.ArrayList;

public class CarportMapper {

    /**
     * Create carport.
     * Tager alle informationerne af den carport som kunden har bestilt og sender dem til databasen
     *
     * @param carport tager et carport objekt som parameter
     */
    public static void createCarport(Carport carport) {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO carport (length, width, height, slope, roof, slopeAngle, shack, shackLength, " +
                    "shackWidth, cladding) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, carport.getLength());
            ps.setInt(2, carport.getWidth());
            ps.setInt(3, carport.getHeight());
            ps.setBoolean(4, carport.isSlope());
            ps.setString(5, carport.getRoofType());
            ps.setInt(6, carport.getSlopeAngle());
            ps.setBoolean(7, carport.isShack());
            ps.setInt(8, carport.getShackLength());
            ps.setInt(9, carport.getShackWidth());
            ps.setString(10, carport.getCladding());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Roof material array list.
     * En metode som forbinder til databasen og henter alle de materialer som indeholder "Roof" i materialDetail
     * Den bliver brugt til at udfylde en dropdown menu som kunder kan bruge
     *
     * @return Den returnere en ArrayList af strings og det den indeholder er de materialer en kunde kan vælge som tag-beklædning
     */
    public static ArrayList<String> roofMaterial() {
        ArrayList<String> roofList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT materialType FROM materials WHERE materialDetail = \"Roof \"";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String roofType = rs.getString("materialType");
                roofList.add(roofType);
            }
            return roofList;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return roofList;
    }

    /**
     * Cladding array list.
     * En metode der forbinder til databasen og henter alle materialer som har "Cladding" i materialDetail
     * Den bliver brugt til at udfylde en dropdown menu som kunder kan bruge
     *
     * @return Den returnere en ArrayList af strings og det den indeholder er de materialer en kunde kan vælge som beklæding til carporten
     */
    public static ArrayList<String> cladding() {
        ArrayList<String> clad = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT materialType FROM materials WHERE materialDetail = \"Cladding \"";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String claddingType = rs.getString("materialType");
                clad.add(claddingType);
            }
            return clad;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return clad;
    }

    /**
     * Material list array list.
     * En metode som henter ID, Materiale og prisen fra vores database putter det i en ArrayList
     * Bruges til at hvis en medarbejder vil rette en pris i databasen så skal han nok også lige se hvad der er i forvejen
     *
     * @return Returnere en ArrayList med alle id, type og pris for materialer
     */
    public static ArrayList<String> materialList() {
        ArrayList<String> list = null;
        try {
            list = new ArrayList<>();
            Connection con = Connector.connection();
            String SQL = "SELECT materialID, materialType, price from materials";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("materialID");
                String type = rs.getString("materialType");
                double price = rs.getDouble("price");
                String asList = "ID: " + id + ", Materiale: " + type + ", Pris: " + price + " kr<br>";
                list.add(asList);
            }
            return list;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Update price in db.
     * En metode til at updatere prisen på et materiale ud fra ID'et
     *
     * @param price price er den nye pris på det materiale id man skriver
     * @param id    id er det materiale id man gerne vil ændre prisen på
     */
    public static void updatePriceInDB(double price, int id) {
        try {
            Connection con = Connector.connection();
            String SQL = "update materials set price = ? where materialID = ?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, price);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add material in db.
     * En metode man skal bruge til at tilføje et nyt materiale til databasen
     *
     * @param type   Hvilke type materiale det er
     * @param length længde på det nye materiale
     * @param width  bredden på det nye materiale
     * @param height højden af det nye materiale
     * @param detail noget informaiton om det nye materiale
     * @param price  prisen på det nye materiale
     */
    public static void addMaterialInDB(String type, int length, int width, int height, String detail, int price) {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO materials (materialType, materialLength, materialWidth, materialHeight, materialDetail, price) " +
                    "values (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, type);
            ps.setInt(2, length);
            ps.setInt(3, width);
            ps.setInt(4, height);
            ps.setString(5, detail);
            ps.setInt(6, price);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Stykliste carport carport.
     * Denne metode bliver brugt til at hente en carport fra databasen ud fra et givet id
     * carporten bliver returneret og vi bruger den så til når vi skal lave styklisten til den carport
     *
     *
     * @param id id på en carport fra databasen
     * @return returnere en carport objekt
     */
    public static Carport styklisteCarport(int id) {
        Carport carport = null;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM carport WHERE carportOrdreID = ?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                boolean slope = rs.getBoolean("slope");
                String roofType = rs.getString("roof");
                int slopeAngle = rs.getInt("slopeAngle");
                boolean shack = rs.getBoolean("shack");
                int shackLength = rs.getInt("shackLength");
                int shackWidth = rs.getInt("shackWidth");
                String cladding = rs.getString("cladding");
                carport = new Carport(length, width, height, slope, roofType, slopeAngle, shack, shackLength, shackWidth, cladding);
            }
            return carport;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return carport;
    }
}