package DBAccess;

import FunctionLayer.materials;

import java.sql.*;
import java.util.HashMap;


public class MaterialsMapper {

    public static HashMap<String, FunctionLayer.materials> hashMapAfMaterialer() {
        HashMap<String, materials> materials = new HashMap<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM materials;";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                FunctionLayer.materials mat;
                int id = rs.getInt("materialID");
                String type = rs.getString("materialType");
                int length = rs.getInt("materialLength");
                int width = rs.getInt("materialWidth");
                int height = rs.getInt("materialHeight");
                String detail = rs.getString("materialDetail");
                double price = rs.getDouble("price");
                String uniqueKey = type + id;
                mat = new materials(type, length, width, height, detail, price);
                materials.put(uniqueKey, mat);
            }
            return materials;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return materials;
    }
}
