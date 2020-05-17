package DBAccess;

import FunctionLayer.Materials;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import java.sql.*;
import java.util.HashMap;

public class MaterialsMapperTest {

    private static Connection testConnection;
    private static String USER = "root";
    private static String USERPW = "uqt42vqx";
    private static String DBNAME = "carports_test?serverTimezone=CET&useSSL=false";
    private static String HOST = "localhost";

    @BeforeClass
    public static void SetUp() {
        try {
            if (testConnection == null) {
                String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
                Class.forName("com.mysql.cj.jdbc.Driver");
                testConnection = DriverManager.getConnection(url, USER, USERPW);
                Connector.setConnection(testConnection);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            testConnection = null;
            ex.printStackTrace();
        }
    }

    @Before
    public void beforeEachTest() {
        try (Statement st = testConnection.createStatement()) {
            st.execute("drop table if exists materials");
            st.execute("create table materials like carports.materials");
            st.execute("insert into materials values " +
                    "(1, 'Trykimpregneret stolpe', 300, 97, 97, 'Det er en stolpe som bestemmer højden, trykimpregneret', 39.0)," +
                    "(2, 'Spærtræ', 600, 45, 195, 'Vandret planke som forbinder stolper, spærtræ', 36.38)," +
                    "(3, 'Spærtræ', 480, 45, 195, 'Vandret planke som forbinder stolper, spærtræ', 36.38)," +
                    "(4, 'Spærtræ', 600, 45, 195, 'Holder de to sider sammen, reglar.', 36.38)," +
                    "(5, 'Trykimpregneret brædt', 360, 25, 200, 'Understernbræder', 39.0)," +
                    "(6, 'Trykimpregneret brædt', 540, 25, 200, 'Understernbræder', 39.0);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConOK() {
        assertNotNull(testConnection);
    }

    @Test
    public void testDatabase01() {
        HashMap<Integer, Materials> materials = new HashMap<>();
        Materials mat;
        try {
            Connection con = testConnection;
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        assertTrue(materials != null);
    }

    @Test
    public void testDatabase02(){
        HashMap<Integer, Materials> materials = new HashMap<>();
        Materials mat;
        try {
            Connection con = testConnection;
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Materials expectedMat = new Materials("Trykimpregneret stolpe", 300,97,97,"Det er en stolpe som bestemmer højden, trykimpregneret", 39.0);
        Materials actualMat = materials.get(1);

        assertEquals(expectedMat.getMatType(), actualMat.getMatType());
        assertEquals(expectedMat.getMatLength(), actualMat.getMatLength());
        assertEquals(expectedMat.getMatWidth(), actualMat.getMatWidth());
        assertEquals(expectedMat.getMatHeight(), actualMat.getMatHeight());
        assertEquals(expectedMat.getMatDetail(), actualMat.getMatDetail());
        assertEquals(expectedMat.getMatPrice(), actualMat.getMatPrice(), 0);
    }

    @Test
    public void testDatabase03(){
        HashMap<Integer, Materials> materials = new HashMap<>();
        Materials mat;
        try {
            Connection con = testConnection;
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Materials expectedMat = new Materials("Trykimpregneret stolpe", 300,97,97,"Det er en stolpe som bestemmer højden, trykimpregneret", 39.0);
        Materials actualMat = materials.get(2);

        assertNotEquals(expectedMat.getMatType(), actualMat.getMatType());
    }
}