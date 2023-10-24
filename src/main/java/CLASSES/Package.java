package CLASSES;

import java.util.ArrayList;
import java.util.List;

public class Package {
   private Destination destination;
   private Activity activity;
   private Lodging lodging;

   private double totalPrice;
   private int id;
   private String name;
   public Package(int id, String name, Destination destination, Activity activity, Lodging lodging) {
      this.id = id;
      this.name = name;
      this.destination = destination;
      this.activity = activity;
      this.lodging = lodging;


      setTotalPrice();
   }
public Package(){}
   public String getName() {
      return name;
   }

   public Destination getDestination() {
      return destination;
   }

   public double getTotalPrice() {
      return totalPrice;
   }

   public void setTotalPrice() {
      double activityCost = 0;
      activityCost += activity.getPrice();
      int differenceInDaysAtLodging = lodging.getEndDate() - lodging.getStartDate();
      double lodgingCost = differenceInDaysAtLodging * lodging.getPricePerDay();
      activityCost += lodgingCost;
      activityCost += destination.getPrice();
      this.totalPrice = activityCost;
   }

   public int getId() {
      return id;
   }

   @Override
   public String toString() {
      return  id +"."  +
              " Package: " +
              "destination: " + destination +
              ", activityList: " + activity +
              ", lodging: " + lodging +
              ", totalPrice: " + totalPrice +
               " \n";
   }
}


