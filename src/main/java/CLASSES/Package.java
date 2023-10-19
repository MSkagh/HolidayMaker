package CLASSES;

import java.util.ArrayList;
import java.util.List;

public class Package {
   public String name;
   private Destination destination;
   private Activity activity;
   private Lodging lodging;
   private Extras extras;
   private double totalPrice;

   public Package(String name, Destination destination, Activity activity, Lodging lodging, Extras extras) {
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

   @Override
   public String toString() {
      if (getDestination() != null && activity != null && lodging != null) {
         return "Destination: " + destination.getName() +
                 " | Activities: " + activity.getName() +
                 " | Lodging: " + lodging.getName();
      }
      return "The package " + getName() + " is incomplete";
   }
}


