package CLASSES;

import java.util.ArrayList;
import java.util.List;

public class Package {
   private Destination destination;
   private Activity activity;
   private Lodging lodging;
   private Extras extras;
   private double totalPrice;
   private int id;
   private String name;
   public Package(int id, String name, Destination destination, Activity activity, Lodging lodging, Extras extras) {
      this.id = id;
      this.name = name;
      this.destination = destination;
      this.activity = activity;
      this.lodging = lodging;
      this.extras = extras;
   }

   public String getName() {
      return name;
   }

   public Destination getDestination() {
      return destination;
   }

   public void setDestination(Destination destination) {
      this.destination = destination;
   }

   public Activity getActivityList() {
      return activity;
   }

   public void setActivityList(Activity activity) {
      this.activity = activity;
   }

   public Lodging getLodging() {
      return lodging;
   }

   public void setLodging(Lodging lodging) {
      this.lodging = lodging;
   }

   public Extras getExtras() {
      return extras;
   }

   public void setExtras(Extras extras) {
      this.extras = extras;
   }

   public double getTotalPrice() {
      return totalPrice;
   }

   public void setTotalPrice() {
      double activityCost = 0;

      activityCost += activity.getPrice();

      int differenceInDaysAtLodging = lodging.getEndDate() - lodging.getStartDate();
      double lodgingCost = differenceInDaysAtLodging * lodging.getPricePerDay();

      this.totalPrice = lodgingCost + this.extras.getPrice() + activityCost;
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
              ", extras: " + extras +
              ", totalPrice: " + totalPrice +
               " \n";
   }
}


