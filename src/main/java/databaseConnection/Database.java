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
        getAllPackages();
       /* getUsersByType("BIDDER");
        printUserResultSet();
        createNewUser("Bennie", "SELLER", "bennie@thejets.com");
        getUsersByType("SELLER");
        printUserResultSet();*/
    }
    void connectToDb(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://161.97.144.27:8009/teneriffa?user=root&password=bowlingspeedyfins");
            System.out.println("Connected successfully");
        } catch (Exception ex) { ex.printStackTrace(); }
    }



    void getAllPackages(){
        try {
            statement = conn.prepareStatement("SELECT name FROM package RIGHT JOIN teneriffa.destinations d ON package.destination = d.id");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                System.out.println("name " + name);
            }
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
}