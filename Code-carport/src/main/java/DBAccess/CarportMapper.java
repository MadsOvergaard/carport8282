package DBAccess;

import FunctionLayer.Carport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CarportMapper {
    public static void createCarport(Carport carport) {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Carport (length, width, height) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, carport.getLength());
            ps.setInt(2, carport.getWidth());
            ps.setInt(3, carport.getHeight());
            ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
