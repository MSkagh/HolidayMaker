package CLASSES;

public class Destination {
    private int id;
    private final String name;
    private final int startDate;
    private final int endDate;
    private final double price;
    /*-----------------------------------------------------------------
      ------------------------------Constructor------------------------
      -----------------------------------------------------------------*/
    public Destination(String name, int startDate, int endDate, double price) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }
    public Destination(int id, String name, int startDate, int endDate, double price) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }
    /*-----------------------------------------------------------------
      ------------------------------GETTERS----------------------------
      -----------------------------------------------------------------*/
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getStartDate() {
        return startDate;
    }
    public int getEndDate() {
        return endDate;
    }
    public double getPrice() {
        return price;
    }
    /*-----------------------------------------------------------------
      ------------------------------MISC-------------------------------
      -----------------------------------------------------------------*/
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
                   --------------------------------
                   
                """ ,id, name, startDate,endDate, price);
    }

    @Override
    public String toString() {
        return """
                {"name" : %s,
                "startDate" : %s,
                "endDate" : %s,
                "price" : %s}
                """.formatted(name,startDate,endDate,price);
    }
}
