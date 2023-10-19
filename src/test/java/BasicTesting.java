import CLASSES.ConfirmBooking;
import CLASSES.Package;
import databaseConnection.Database;
import menuSystem.menues.HandleBookings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import java.util.ArrayList;
import java.util.Scanner;

public class BasicTesting {

    protected Database db;

    @BeforeEach
    void setUp(){
        this.db = new Database();
    }


    @Test
    void choice(){
        int exId = 2;
        int actualId = 2;

        Assertions.assertEquals(exId, HandleBookings.getInstance().loopThroughPackageList(actualId).get(0).getId() );

            }

    @Test
    void getAllPackages(){

        for (int i = 0; i < db.getAllPackages(). size(); i++){
            System.out.println(db.getAllPackages().get(i).toString());
        }
        Assertions.assertEquals(db.getAllPackages().get(0).getDestination().getName(), "Biryulëvo Zapadnoye");

    }

    @Test
    void createNewBooking(){
         db.createNewBooking("Test", "test", "222", HandleBookings.getInstance().loopThroughPackageList(2).get(0));
         ConfirmBooking testBooking = db.getBookings().get(db.getBookings().size() - 1);
         Assertions.assertEquals("Test", testBooking.getCustomerName());

    }

    @Test
    void checkConnection(){
        Assertions.assertNotNull(db);
    }
    @Test
    void hello(){
        String hello = "hello";
        Assertions.assertEquals(hello, "hello");
    }





}


