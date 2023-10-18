package CLASSES;

import java.util.ArrayList;
import java.util.List;

public class Package {
   private Destination destination;
   private List<Activity> activityList = new ArrayList<>();
   private Lodging lodging;
   private Extras extras;

   public Package(Destination destination, List<Activity> activityList, Lodging lodging, Extras extras) {
      this.destination = destination;
      this.activityList = activityList;
      this.lodging = lodging;
      this.extras = extras;
   }

   public Destination getDestination() {
      return destination;
   }

   public void setDestination(Destination destination) {
      this.destination = destination;
   }

   public List<Activity> getActivityList() {
      return activityList;
   }

   public void setActivityList(List<Activity> activityList) {
      this.activityList = activityList;
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
}


