package DBAccess;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


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
                String url = String.format("jdbc:mysql//%s:3306/%s", HOST, DBNAME);
                Class.forName("com.mysql.cj.jdbc.Driver");
                testConnection = DriverManager.getConnection(url, USER, USERPW);
                Connector.setConnection(testConnection);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            testConnection = null;
            ex.printStackTrace();
        }
    }

    @Before
    public void beforeEachTest() {
        try (Statement st = testConnection.createStatement()) {
            st.execute("drop table if exists materials");
            st.execute("create table materials like carports.materials");
            st.execute("insert into materials values" +
                    "(1, 'Trykimpregneret stolpe', 300, 97, 97, 'Det er en stolpe som bestemmer højden, trykimpregneret', 39.0)," +
                    "(2, 'Spærtræ', 600, 45, 195, 'Vandret planke som forbinder stolper, spærtræ', 36.38)," +
                    "(3, 'Spærtræ', 480, 45, 195, 'Vandret planke som forbinder stolper, spærtræ', 36.38)," +
                    "(4, 'Spærtræ', 600, 45, 195, 'Holder de to sider sammen, reglar.', 36.38)," +
                    "(5, 'Trykimpregneret brædt', 360, 25, 200, 'Understernbræder', 39.0)," +
                    "(6, 'Trykimpregneret brædt', 540, 25, 200, 'Understernbræder', 39.0),");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConOK() {
        assertNotNull(testConnection);
    }

}