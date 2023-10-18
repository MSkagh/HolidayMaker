package CLASSES;

public class Activity {
    private String name;
    private int startDate;
    private int endDate;
    private double price;
    private String destinations;

    public Activity(String name, int startDate, int endDate, double price, String destinations) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.destinations = destinations;
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

    public String getDestinations() {
        return destinations;
    }

    public void setDestinations(String destinations) {
        this.destinations = destinations;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", destinations='" + destinations + '\'' +
                '}';
    }
}
