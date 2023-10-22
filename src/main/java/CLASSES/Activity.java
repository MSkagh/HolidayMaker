package CLASSES;

public class Activity {
    private int id;
    private String name;
    private int startDate;
    private int endDate;
    private double price;
    private String location;
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
    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
                """.formatted(name,startDate,endDate,price,location);
    }
}
