package bd.conectionBd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBd {
    
    private static String URL = "jdbc:mysql://localhost/bd_banco";
    private static String USER = "root";
    private static String PASSWORD = "";
    
    private static Connection con;
    public static Connection getConnection(){ 
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error en la conección: " + e.getMessage());
        }
        return con;
    }
}
