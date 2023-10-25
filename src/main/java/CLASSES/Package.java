package CLASSES;

public class Package {
   private Destination destination;
   private Activity activity;
   private Lodging lodging;
   private double totalPrice;
   private int id;
   private String name;
   /*------------------------------------------------------------------
     ------------------------------CONSTRUCTOR-------------------------
     ------------------------------------------------------------------*/
   public Package(int id, String name, Destination destination, Activity activity, Lodging lodging) {
      this.id = id;
      this.name = name;
      this.destination = destination;
      this.activity = activity;
      this.lodging = lodging;


      setTotalPrice();
   }
public Package(){}
   /*------------------------------------------------------------------
     ------------------------------GETTERS-----------------------------
     ------------------------------------------------------------------*/
   public String getName() {
      return name;
   }
   public Destination getDestination() {
      return destination;
   }
   public Activity getActivity() {
      return activity;
   }
   public Lodging getLodging() {
      return lodging;
   }
   public double getTotalPrice() {
      return totalPrice;
   }
   public int getId() {
      return id;
   }
   /*------------------------------------------------------------------
     ------------------------------MISC--------------------------------
     ------------------------------------------------------------------*/
   public void setTotalPrice() {
      double activityCost = 0;
      activityCost += activity.getPrice();
      int differenceInDaysAtLodging = lodging.getEndDate() - lodging.getStartDate();
      double lodgingCost = differenceInDaysAtLodging * lodging.getPricePerDay();
      activityCost += lodgingCost;
      activityCost += destination.getPrice();
      this.totalPrice = activityCost;
   }
   public void displayShortInfo(){
      System.out.printf("""
                ID| %s | %s
                """, id,name);
   }
   public void displayLongInfo(){
      System.out.printf("""
                ID| %s | %s
                Destination: %s
                Activity: %s
                Lodging: %s
                Cost: %s
                Departure date: %s
                Return date: %s
                
                """, id,name, destination.getName(), activity.getName(), lodging.getName(), totalPrice, destination.getStartDate(), destination.getEndDate());
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


