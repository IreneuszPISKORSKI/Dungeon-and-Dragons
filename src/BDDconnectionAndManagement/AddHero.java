//package BDDconnectionAndManagement;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class AddHero {
//
//    static final String DB_URL = "jdbc:mysql://localhost:3306/d_and_d";
//    static final String USER = "irek";
//    static final String PASS = "";
//
//    public AddHero(int type, String name, int hp, int att_p, String weapon, String armor) {
//        // Open a connection
//        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            Statement stmt = conn.createStatement();
//        ) {
//            // Execute a query
//            System.out.println("Inserting records into the table...");
//            String sql = "INSERT INTO hero VALUES(NULL, '" + type +
//                    "', '" + name +
//                    "', '" + hp +
//                    "', '" + att_p + "', '" + weapon + "', '" + armor + "')";
//            stmt.executeUpdate(sql);
//
//
////            sql = "INSERT INTO hero VALUES (NULL, '1', 'ftjfj', '21', '122', '!ml!', 'gegmmsg'), (NULL, '2', 'Azerty', '11', '3', 'tth', 'hhttt')";
////            stmt.executeUpdate(sql);
////            sql = "INSERT INTO hero VALUES (NULL, '3', 'Qwerty', '69', '4', 'uuuy', 'hhh')";
////            stmt.executeUpdate(sql);
//
//            System.out.println("Inserted records into the table...");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
