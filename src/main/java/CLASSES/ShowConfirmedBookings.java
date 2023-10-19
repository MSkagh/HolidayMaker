package CLASSES;

import menuSystem.menues.HandleBookings;

import java.util.List;

public class ShowConfirmedBookings {


    public static void showConfirmedBookings(){
     List<ConfirmBooking> list = HandleBookings.getInstance().confirmedBookingList();
     System.out.println(list);
    }


}
