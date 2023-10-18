package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    List<Package> getAllPackages(){
        List<Package> tempList = new ArrayList<>();
        try {
            /*statement = conn.prepareStatement("SELECT name FROM package RIGHT JOIN teneriffa.destinations d ON package.destination = d.id");*/
            statement = conn.prepareStatement("SELECT d.name, a.name, l.name, e.name FROM package\n" +
                    "INNER JOIN teneriffa.destinations d ON package.destination = d.id\n" +
                    "INNER JOIN teneriffa.activity a ON package.activity = a.id\n" +
                    "INNER JOIN teneriffa.lodging l ON package.lodging = l.id\n" +
                    "INNER JOIN teneriffa.extras e ON package.extras = e.id");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                /*String name = resultSet.getString("name");*/
                String activity = resultSet.getString("a.name");
                /*System.out.println("name " + name);*/
                System.out.println("activity " + activity);
            }
        } catch (Exception ex) { ex.printStackTrace(); }
        return tempList;
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