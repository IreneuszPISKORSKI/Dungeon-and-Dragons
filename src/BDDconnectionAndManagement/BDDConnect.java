package BDDconnectionAndManagement;

import java.sql.*;

public class BDDConnect {
    static final String DB_URL = "jdbc:mysql://localhost:3306/d_and_d";
    static final String USER = "irek";
    static final String PASS = "";
    private static Connection connect;

    private BDDConnect() {
        try {
            connect = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance() {
        if (connect == null) {
            new BDDConnect();
        }
        return connect;
    }

    public static void selectAll() {

        try {
            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM hero");

            while (rs.next()) {
                // Retrieve by column name
                System.out.println("Id: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Type: " + rs.getInt("type") +
                        ", HP: " + rs.getInt("health_points") +
                        ", AP: " + rs.getInt("attack_power") +
                        ", Weapon: " + rs.getString("weapon") +
                        ", Armor: " + rs.getString("armor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet selectOne(int id) {
        ResultSet rs = null;
        try {
            Statement stmt = connect.createStatement();
            rs = stmt.executeQuery("SELECT * FROM hero WHERE id = " + id );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void addHero(int type, String name, int hp, int att_p, String weapon, int wAttack, String wType, String armor) {

        try {
            Statement stmt = connect.createStatement();
            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO hero VALUES(NULL, " + type +
                    ", '" + name +
                    "', " + hp +
                    ", " + att_p +
                    ", '" + weapon +
                    "', " + wAttack +
                    ", '" + wType +
                    "', '" + armor + "')";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editHero(int type, String name, int hp, int att_p, String weapon, int wAttack, String wType, String armor, int id){
        try {
            Statement stmt = connect.createStatement();
            System.out.println("Updating records in the table...");
            String sql = "UPDATE hero SET type = " + type +
                    ", '" + name +
                    "', " + hp +
                    ", " + att_p +
                    ", '" + weapon +
                    "', " + wAttack +
                    ", '" + wType +
                    "', '" + armor + "' WHERE id = " + id ;
            stmt.executeUpdate(sql);
            System.out.println("Updated records in the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteHero(String name){   //ok
        try {
            Statement stmt = connect.createStatement();
            System.out.println("Updating records in the table...");
            String sql = "DELETE FROM hero WHERE name = '" + name + "'";
            stmt.executeUpdate(sql);
            System.out.println("Updated records in the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
