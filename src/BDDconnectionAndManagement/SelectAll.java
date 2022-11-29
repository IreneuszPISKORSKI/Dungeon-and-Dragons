//package BDDconnectionAndManagement;
//
//import java.sql.*;
//
//public class SelectAll {
//    static final String DB_URL = "jdbc:mysql://localhost:3306/d_and_d";
//    static final String USER = "irek";
//    static final String PASS = "";
//    static final String QUERY = "SELECT * FROM hero";
//
//    public SelectAll() {
//        System.out.println("Connecting to a selected database...");
//        // Open a connection
//        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(QUERY);) {
//            System.out.println("Available heroes:");
//            while (rs.next()) {
//                // Retrieve by column name
////                System.out.print("ID: " + rs.getInt("id"));
//                System.out.println("Name: " + rs.getString("name") +
//                        ", Type: " + rs.getInt("type") +
//                        ", HP: " + rs.getInt("health_points") +
//                        ", AP: " + rs.getInt("attack_power") +
//                        ", Weapon: " + rs.getString("weapon") +
//                        ", Armor: " + rs.getString("armor"));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
