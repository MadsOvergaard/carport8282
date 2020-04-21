package DBAccess;

import FunctionLayer.Carport;
import FunctionLayer.LoginSampleException;

import java.sql.*;
import java.util.ArrayList;

public class CarportMapper {
    public static void createCarport(Carport carport) {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Carport (length, width, height, slope, roof, slopeAngle) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, carport.getLength());
            ps.setInt(2, carport.getWidth());
            ps.setInt(3, carport.getHeight());
            ps.setBoolean(4, carport.isSlope());
            ps.setString(5, carport.getRoofType());
            ps.setInt(6, carport.getSlopeAngle());
            ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> RoofType() throws LoginSampleException {
        ArrayList<String> roof = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM Carports.rooftype";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("roofID");
                String roofType = rs.getString("type");
                roof.add(roofType);
            }
            return roof;

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static ArrayList<String> cladding() throws LoginSampleException {
        ArrayList<String> clad = new ArrayList<>();
        try {Connection con = Connector.connection();
            String SQL = "SELECT * FROM Carports.mats";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("MatsID");
                String claddingType = rs.getString("type");
                clad.add(claddingType);
            }
            return clad;

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
}

