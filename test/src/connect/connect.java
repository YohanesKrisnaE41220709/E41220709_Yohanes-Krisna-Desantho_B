package connect;
import java.sql.*;
import javax.swing.*;
public class connect {
    private static Connection koneksi;
    public static Connection configDB() throws SQLException {
        try {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/msgrup99","root","");
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
        return koneksi;
    }
}
