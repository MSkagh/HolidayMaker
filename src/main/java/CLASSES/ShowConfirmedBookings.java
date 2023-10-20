package CLASSES;

import databaseConnection.Database;
import menuSystem.menues.HandleBookings;

import java.util.List;

public class ShowConfirmedBookings {

   private final Database db = new Database();
private static final ShowConfirmedBookings instance = new ShowConfirmedBookings();

    public static ShowConfirmedBookings getInstance() {
        return instance;
    }
    public void showConfirmedBookings(){
        /*List<ConfirmBooking> list = db.getBookings();*/
     /*List<ConfirmBooking> list = HandleBookings.getInstance().confirmedBookingList();*/
     /*System.out.println(list);*/
    }


}
