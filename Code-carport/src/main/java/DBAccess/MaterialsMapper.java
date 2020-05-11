package DBAccess;

import FunctionLayer.materials;

import java.sql.*;
import java.util.HashMap;


public class MaterialsMapper {

    public static HashMap<Integer, materials> hashMapAfMaterialer() {
        HashMap<Integer, materials> materials = new HashMap<>();
        materials mat;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM materials;";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("materialID");
                String type = rs.getString("materialType");
                int length = rs.getInt("materialLength");
                int width = rs.getInt("materialWidth");
                int height = rs.getInt("materialHeight");
                String detail = rs.getString("materialDetail");
                double price = rs.getDouble("price");
               
                mat = new materials(type, length, width, height, detail, price);
                materials.put(id, mat);
            }
            return materials;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return materials;
    }
}
