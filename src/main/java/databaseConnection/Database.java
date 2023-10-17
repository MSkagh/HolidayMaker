package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database {
    ResultSet resultSet;
    PreparedStatement statement;
    Connection conn = null;

    public Database(){
        connectToDb();
        getUsersByType("BIDDER");
        printUserResultSet();
        createNewUser("Bennie", "SELLER", "bennie@thejets.com");
        getUsersByType("SELLER");
        printUserResultSet();

    }

    void connectToDb(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://161.97.144.27/teneriffa?user=root&password=bowlingspeedyfins");
            System.out.println(conn);
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    void getUsersByType(String type){
        try {
            statement = conn.prepareStatement("SELECT * FROM users WHERE type = ?");
            statement.setString(1,type);
            resultSet = statement.executeQuery();
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    void createNewUser(String name, String type, String email){
        try {
            statement = conn.prepareStatement("INSERT INTO users SET name = ?, type = ?, email = ?");
            statement.setString(1,name);
            statement.setString(2,type);
            statement.setString(3,email);
            statement.executeUpdate();
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    void printUserResultSet(){
        try {
            while (resultSet.next()) {
                String row = "id: " + resultSet.getString("id")
                        + ", name: " + resultSet.getString("name")
                        + ", type: " + resultSet.getString("type")
                        + ", email: " + resultSet.getString("email") + ".";
                System.out.println(row);
            }
        } catch (Exception ex){ ex.printStackTrace(); }
    }
}