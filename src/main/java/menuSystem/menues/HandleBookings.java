package menuSystem.menues;

import databaseConnection.Database;


public class HandleBookings {
    private Database db = new Database();
    public static final HandleBookings instance = new HandleBookings();



    public static HandleBookings getInstance(){
        return instance;
    }

    public void viewPackages(){

        System.out.println(db.getAllPackages());
    }


    }

