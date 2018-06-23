package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {

    private static Connection connection;

    public static void getConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ResultSet search(String query) throws ClassNotFoundException, SQLException {
        if (connection == null) {
            getConnection();
        }
        ResultSet rs = connection.createStatement().executeQuery(query);
        return rs;
    }

    public static void Execute(String query) throws ClassNotFoundException, SQLException {
        if (connection == null) {
            getConnection();
        }
        connection.createStatement().executeUpdate(query);
    }

    public static void main(String[] args) {
        try {
            DB.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
