package databaseConnection;

import CLASSES.*;
import CLASSES.Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class TestDatabase {
    ResultSet resultSet;
    PreparedStatement statement;
    Connection conn = null;
    private List<Package> packageList = new ArrayList<>();
    private List<Destination> destinationList = new ArrayList<>();
    private List<Activity> activityList = new ArrayList<>();
    private List<Lodging> lodgingList = new ArrayList<>();

    public TestDatabase(){
        connectToDb();
        updateDatabase();
    }
    void connectToDb(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://161.97.144.27:8009/HolidayMaker?user=root&password=bowlingspeedyfins");
            System.out.println("Connected successfully");
        } catch (Exception ex) { ex.printStackTrace(); }
    }
    //GETTERS
    public List<Package> getAllPackages(){
        return packageList;
    }
    public List<Destination> getAllDestinations(){
        return destinationList;
    }
    public List<Activity> getAllActivities(){
        return activityList;
    }
    public List<Lodging> getAllLodgings(){
        return lodgingList;
    }

    //FUNCTIONS THAT UPDATES THE LISTS
    void updateDatabase(){
        updatePackages();
        updateDestinations();
        updateLodgings();
        updateActivities();
    }
    void updatePackages(){
        packageList = new ArrayList<>();
        try {
            statement = conn.prepareStatement("""
                    SELECT
                          ID,
                          name,
                          destination -> '$.name',
                          destination -> '$.startDate',
                          destination -> '$.endDate',
                          destination -> '$.price',
                          activity -> '$.name',
                          activity -> '$.startDate',
                          activity -> '$.endDate',
                          activity -> '$.price',
                          activity -> '$.location',
                          lodging -> '$.name',
                          lodging -> '$.startDate',
                          lodging -> '$.endDate',
                          lodging -> '$.pricePerDay',
                          lodging -> '$.capacity',
                          lodging -> '$.location'
                      FROM Packages;
                            """);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                packageList.add(new Package(
                        resultSet.getInt("ID"),
                        resultSet.getString("name"),
                        new Destination(
                                resultSet.getString("destination -> '$.name'"),
                                resultSet.getInt("destination -> '$.startDate'"),
                                resultSet.getInt("destination -> '$.endDate'"),
                                resultSet.getDouble("destination -> '$.price'")
                        ),
                        new Activity(
                                resultSet.getString("activity -> '$.name'"),
                                resultSet.getInt("activity -> '$.startDate'"),
                                resultSet.getInt("activity -> '$.endDate'"),
                                resultSet.getDouble("activity -> '$.price'"),
                                resultSet.getString("activity -> '$.location'")
                        ),
                        new Lodging(
                                resultSet.getString("lodging -> '$.name'"),
                                resultSet.getInt("lodging -> '$.startDate'"),
                                resultSet.getInt("lodging -> '$.endDate'"),
                                resultSet.getDouble("lodging -> '$.pricePerDay'"),
                                resultSet.getInt("lodging -> '$.capacity'"),
                                resultSet.getString("lodging -> '$.location'")
                        ),
                        null));
            }

        } catch (Exception ex) { ex.printStackTrace(); }
    }
    void updateDestinations(){
        destinationList = new ArrayList<>();
        try {

            statement = conn.prepareStatement("""
                    SELECT
                          ID,
                          Destination -> '$.name',
                          Destination -> '$.startDate',
                          Destination -> '$.endDate',
                          Destination -> '$.price'
                      FROM Destinations;
                            """);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                destinationList.add(new Destination(
                        resultSet.getString("Destination -> '$.name'"),
                        resultSet.getInt("Destination -> '$.startDate'"),
                        resultSet.getInt("Destination -> '$.endDate'"),
                        resultSet.getDouble("Destination -> '$.price'")
                ));
            }

        } catch (Exception ex) { ex.printStackTrace(); }
    }
    void updateLodgings(){
        lodgingList = new ArrayList<>();
        try {

            statement = conn.prepareStatement("""
                    SELECT\s
                          ID,
                          Lodging -> '$.name',
                          Lodging -> '$.startDate',
                          Lodging -> '$.endDate',
                          Lodging -> '$.pricePerDay',
                          Lodging -> '$.capacity',
                          Lodging -> '$.location'
                      FROM Lodgings;
                            """);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                lodgingList.add(new Lodging(
                        resultSet.getString("Lodging -> '$.name'"),
                        resultSet.getInt("Lodging -> '$.startDate'"),
                        resultSet.getInt("Lodging -> '$.endDate'"),
                        resultSet.getDouble("Lodging -> '$.pricePerDay'"),
                        resultSet.getInt("Lodging -> '$.capacity'"),
                        resultSet.getString("Lodging -> '$.location'")

                ));
            }

        } catch (Exception ex) { ex.printStackTrace(); }
    }
    void updateActivities(){
        activityList = new ArrayList<>();
        try {
            statement = conn.prepareStatement("""
                    SELECT\s
                          ID,
                          Activity -> '$.name',
                          Activity -> '$.startDate',
                          Activity -> '$.endDate',
                          Activity -> '$.price',
                          Activity -> '$.location'
                      FROM Activities;
                            """);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                activityList.add(new Activity(
                        resultSet.getString("Activity -> '$.name'"),
                        resultSet.getInt("Activity -> '$.startDate'"),
                        resultSet.getInt("Activity -> '$.endDate'"),
                        resultSet.getDouble("Activity -> '$.price'"),
                        resultSet.getString("Activity -> '$.location'")

                ));
            }

        } catch (Exception ex) { ex.printStackTrace(); }
    }

    // CREATION FUNCTIONS
    public void createDestination(String name, int startDate, int endDate, double price){
        //Converting the date of today into an int
        String nowDateString = LocalDate.now().toString();
        String[] nowArr = nowDateString.split("-");
        int now = parseInt(nowArr[0].concat(nowArr[1]).concat(nowArr[2]));

        //NULLCHECKING THE NAME
        if (name == null ||name.equals("")){
            System.out.println("Please provide a name for the destination");
            return;
        }
        //CHECKING
        else if(startDate < now || startDate > endDate){
            System.out.println("The dates are illogical, either the start is before today or the end is before the start");
            return;}
        else{
            try {
                statement = conn.prepareStatement("""
                            INSERT INTO Destinations (Destination) VALUES ('
                            {
                             "name" : "%s",
                             "startDate" : %s,
                             "endDate" : %s,
                             "price" : %s
                            }
                            ')
                            """.formatted(name, startDate, endDate,price));
                statement.executeUpdate();
                System.out.println("Destination added to the database");
            } catch (Exception ex) { ex.printStackTrace(); }
        }
    }
    public void createLodging(String name, int startDate, int endDate, double pricePerDay, int capacity, String location){
        try {
            statement = conn.prepareStatement("""
                            INSERT INTO Lodgings (Lodging) VALUES ('
                            {
                             "name" : "%s",
                             "startDate" : %s,
                             "endDate" : %s,
                             "pricePerDay" : %s,
                             "capacity" : %s,
                             "location" : "%s"
                            }
                            ')
                            """.formatted(name, startDate,endDate,pricePerDay,capacity,location));

            statement.executeUpdate();
            System.out.println("Lodging added to the database");
        } catch (Exception ex) { ex.printStackTrace(); }
    }
    public void createActivity(String name, int startDate, int endDate, double price, String location){
        try {
            statement = conn.prepareStatement("""
                            INSERT INTO Activities (Activity) VALUES ('
                            {
                             "name" : "%s",
                             "startDate" : %s,
                             "endDate" : %s,
                             "price" : %s,
                             "location" : "%s"
                            }
                            ')
                            """.formatted(name, startDate, endDate,price, location));
            statement.executeUpdate();
            System.out.println("Activity added to the database");
        } catch (Exception ex) { ex.printStackTrace(); }
    }
    public void createPackage(String name, Destination destination, Activity activity, Lodging lodging) {
        try {
            statement = conn.prepareStatement("""
                    INSERT INTO HolidayMaker.Packages (
                    name, destination, activity, lodging )
                    VALUES(
                    '%s',
                    '%s',
                    '%s',
                    '%s'
                    );
                    """.formatted(name, destination, activity, lodging));
            statement.executeUpdate();
            System.out.println("Package added to Database");
        } catch (Exception ex) { ex.printStackTrace(); }
    }
}