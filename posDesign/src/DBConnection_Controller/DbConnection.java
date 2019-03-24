package DBConnection_Controller;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class DbConnection {

    Connection con;

    public Connection ConnDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/posSotware", "root", "");

            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error from DbConnection.Class: " + e);
            return null;
        }

    }
        public Connection testDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testDB", "root", "");

            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Error from DbConnection.Class: " + e);
            return null;
        }

    }

//    public Connection AdminConnDB() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = (Connection) DriverManager.getConnection(
//                    "jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12272707", "sql12272707", "z6IJYyuenB");
//
//            return con;
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "DB Connection Error: " + e);
//            return null;
//        } finally {
//            try {
//                con.close();
//            } catch (Exception e) {
//            }
//        }
//
//    }
}
