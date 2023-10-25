package CLASSES;

public class Activity {
    private int id;
    private final String name;
    private final int startDate;
    private final int endDate;
    private final double price;
    private final String location;
    /*-----------------------------------------------------------------
    ------------------------------Constructors-------------------------
    ------------------------------------------------------------------*/
    public Activity(String name, int startDate, int endDate, double price, String location) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.location = location;
    }
    public Activity(int id, String name, int startDate, int endDate, double price, String location) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.location = location;
    }
    /*-----------------------------------------------------------------
    ------------------------------GETTERS------------------------------
    ------------------------------------------------------------------*/
    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }
     public double getPrice() {
        return price;
    }
    public String getLocation() {
        return location;
    }
    /*-----------------------------------------------------------------
    ------------------------------MISC---------------------------------
    ------------------------------------------------------------------*/
    public void displayShortInfo(){
        System.out.printf("""
                ID| %s | %s
                """, id,name);
    }
    public void displayLongInfo(){
        System.out.printf("""
                   ID| %s | %s
                   --------------------------------
                   Starts at: %s
                   Ends at: %s
                   Cost: %s
                   Available at: %s
                   --------------------------------
                   
                """ ,id, name, startDate,endDate, price, location);
    }
    @Override
    public String toString() {
        return """
                {"name":%s,
                "startDate": %s,
                "endDate": %s,
                "price": %s,
                "location": %s
                }
                """.formatted(name,startDate,endDate,price, location);
    }
}
