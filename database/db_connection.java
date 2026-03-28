package database;

//import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class db_connection {
    private static final String URL = "jdbc:mysql://localhost:3306/mobile_money_db";
    private static final String USER = "root"; // à adapter
    private static final String PASSWORD = ""; // à adapter

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }    
}