package databaseConnection;

import CLASSES.Activity;
import CLASSES.Destination;
import CLASSES.Lodging;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DatabaseTest {

    protected Database db = new Database();

    @BeforeEach
    void setUp(){
        this.db = new Database();
    }


    @Test
    void checkConnection(){
        Assertions.assertNotNull(db);
    }
    @Test
    void getAllPackages() {
        System.out.println("Started");
        for (int i = 0; i < db.getAllPackages().size(); i++){
            System.out.println(db.getAllPackages().get(i).toString());
        }
        System.out.println("Ended");
    }

    @Test
    void createDestination() {
        int originalSize = db.getAllDestinations().size();
        db.createDestination("Kina", 20231224, 20231230, 15000);
        db.updateDestinations();
        Assertions.assertEquals(db.getAllDestinations().size(), originalSize+1);
    }

    @Test
    void createLodging() {
        int originalSize = db.getAllLodgings().size();
        db.createLodging("Johnnys Härliga Håla", 20240312, 20240319, 1200, 4, "Kalmar");
        db.updateLodgings();
        Assertions.assertEquals(db.getAllLodgings().size(), originalSize+1);
    }

    @Test
    void createActivity() {
        int originalSize = db.getAllActivities().size();
        db.createActivity("Search for Sugarman", 20240312, 20240319, 499.99, "Kalmar");
        db.updateActivities();
        Assertions.assertEquals(db.getAllActivities().size(), originalSize+1);
    }

    @Test
    void createPackage() {
        Lodging lodging =db.getAllLodgings().get(0);
        Activity activity = db.getAllActivities().get(0);
        Destination destination = db.getAllDestinations().get(0);
        int originalSize = db.getAllPackages().size();
        db.createPackage("Leta efter en legend med mysiga Johnny i Kalmar", destination,activity,lodging);
        db.updatePackages();
        Assertions.assertEquals(db.getAllPackages().size(), originalSize+1);
    }
}