package databaseConnection;

import CLASSES.*;
import CLASSES.Package;


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

    public List<Package> getAllPackages(){
        List<Package> tempList = new ArrayList<>();
        try {
            /*statement = conn.prepareStatement("SELECT name FROM package RIGHT JOIN teneriffa.destinations d ON package.destination = d.id");*/
            statement = conn.prepareStatement("SELECT package.id, d.id, d.name, d.startDate, d.endDate, d.price, " +
                    "a.name, a.startDate, a.endDate, a.price, l.name, l.startDate, l.endDate,l.price, l.capacity, l.destination, " +
                    "e.name, e.price FROM package\n" +
                    "INNER JOIN teneriffa.destinations d ON package.destination = d.id\n" +
                    "INNER JOIN teneriffa.activity a ON package.activity = a.id\n" +
                    "INNER JOIN teneriffa.lodging l ON package.lodging = l.id\n" +
                    "INNER JOIN teneriffa.extras e ON package.extras = e.id \n" +
                    "ORDER BY package.id");

            resultSet = statement.executeQuery();
            while (resultSet.next()){

                /*String name = resultSet.getString("name");*/
                List<Activity> activities = getActivityByDestination(resultSet.getInt("d.id"));
                List<Activity> activityList = new ArrayList<>();
                Activity activity = new Activity(
                        resultSet.getString("a.name"),
                        resultSet.getInt("a.startDate"),
                        resultSet.getInt("a.endDate"),
                        resultSet.getDouble("a.price"),
                        null
                );
                activityList.add(activity);

                tempList.add(new Package(resultSet.getInt("package.id"),
                        new Destination(resultSet.getString("d.name"), resultSet.getInt("d.startDate"), resultSet.getInt("d.endDate"),
                        resultSet.getDouble("d.price")),
                        activityList,
                        new Lodging(resultSet.getString("l.name"), resultSet.getInt("l.startDate"), resultSet.getInt("l.endDate"),
                        resultSet.getDouble("l.price"), resultSet.getInt("l.capacity"), resultSet.getString("l.destination")),
                        new Extras(resultSet.getString("e.name"), resultSet.getDouble("e.price"))));

            }
        } catch (Exception ex) { ex.printStackTrace(); }
        return tempList;
    }
    List<Activity> getActivityByDestination(int id){
        ResultSet resultSetTemp;
        PreparedStatement statementTemp;
        List<Activity> tempList = new ArrayList<>();
        try {
            statementTemp = conn.prepareStatement("SELECT activity.name, activity.startDate, activity.endDate, activity.price, d.name FROM activity\n" +
                    "INNER JOIN teneriffa.destinations d ON activity.destinations = d.id \n" +
                    "WHERE d.id = ?"
            );
            statementTemp.setInt(1, id);
            resultSetTemp = statementTemp.executeQuery();

            while(resultSetTemp.next()){
                tempList.add(
                        new Activity(resultSetTemp.getString("name"),
                                resultSetTemp.getInt("startDate"),
                                resultSetTemp.getInt("endDate"),
                                resultSetTemp.getDouble("price"),
                                resultSetTemp.getString("d.name")));
            }
        }catch (Exception ex) { ex.printStackTrace(); }
        return tempList;
    }
    /*
    tempList.add(new User(resultSet.getInt("id"),48
      resultSet.getString("name"),49
     resultSet.getString("type"),50
     resultSet.getString("email")));
     */
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