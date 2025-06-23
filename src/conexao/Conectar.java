package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;;

public class Conectar {
    
 private static final String URL = "jdbc:mysql://127.0.0.1:3306/reservanotebook?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USER = "root";
    private static final String PASSWORD = ""; 

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Registra o Driver
        } catch (ClassNotFoundException e) {
            System.err.println("Driver não encontrado: " + e.getMessage());
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
