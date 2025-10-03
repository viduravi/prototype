package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {

    private Singleton dbConSingleton;
    private Connection connection;

    private Singleton(){
        try {
            // Example: MySQL connection (adjust for your DB)
            String url = "jdbc:mysql//localhost/student_management";
            String user = "root";
            String password = "root";

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Singleton getDbConSingleton() {
        if (dbConSingleton==null){
            dbConSingleton = new Singleton();
            return dbConSingleton;
        }
        return dbConSingleton;
    }

    public Connection getConnection() {
        return  connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.err.println("Failed to close connection: " + e.getMessage());
            }
        }
    }
}
