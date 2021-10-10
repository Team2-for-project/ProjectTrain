package Jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class trainDB {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/traindetails", "root", "Elonmusk@123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

