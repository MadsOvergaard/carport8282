package DBAccess;

import FunctionLayer.Materials;

import java.sql.*;
import java.util.HashMap;


public class MaterialsMapper {

    /**
     * Hash map af materialer hash map.
     * En metoder der henter alle vores materialer fra databasen og lægger dem ind i et hashmap
     * som vi så kan bruge i vores stykliste beregninger for at få længden på et given materiale.
     *
     * @return hash map med alle materialer i fra databasen
     */
    public static HashMap<Integer, Materials> hashMapAfMaterialer() {
        HashMap<Integer, Materials> materials = new HashMap<>();
        Materials mat;
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
               
                mat = new Materials(type, length, width, height, detail, price);
                materials.put(id, mat);
            }
            return materials;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return materials;
    }
}
