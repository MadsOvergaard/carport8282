package DBAccess;

import FunctionLayer.Carport;
import FunctionLayer.LoginSampleException;

import java.sql.*;
import java.util.ArrayList;

public class CarportMapper {
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

    // En metode som henter ID, Materiale og prisen fra vores database putter det i en ArrayList
    // Bruges til at hvis en medarbejder vil rette en pris i databasen så skal han nok også lige se hvad der er i forvejen
    public static ArrayList<String> materialList() throws LoginSampleException {
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

    // En metode til at updatere prisen på et materiale ud fra ID'et
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
}