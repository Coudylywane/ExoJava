package allocation.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    private static String users = "root";
    private static String passwords = "";
    private static String urls = "jdbc:mysql://localhost:3306/projet";

    private static Connection conn = null;

    
    public static Connection getConnection() {
        try {
            conn = DriverManager.getConnection(urls, users, passwords);

            if (conn != null) {
                System.out.println("connected sucessfully");
            } else {
                System.out.println("Failed to connect to database");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
