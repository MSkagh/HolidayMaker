package CLASSES;

public class Lodging {
    private int id;
    private String name;
    private int startDate;
    private int endDate;
    private double pricePerDay;
    private int capacity;
    private String location;

    public Lodging(String name, int startDate, int endDate, double pricePerDay, int capacity, String location) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pricePerDay = pricePerDay;
        this.capacity = capacity;
        this.location = location;
    }
    public Lodging(int id, String name, int startDate, int endDate, double pricePerDay, int capacity, String location) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.pricePerDay = pricePerDay;
        this.capacity = capacity;
        this.location = location;
    }

    public int getId() {
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

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return  """
                {"name": %s,
                "startDate" : %s,
                "endDate" : %s,
                "pricePerDay" : %s,
                "capacity" : %s,
                "location" : %s}
                """.formatted(name,startDate,endDate,pricePerDay,capacity,location);
    }
}
