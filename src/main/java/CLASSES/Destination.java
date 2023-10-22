package CLASSES;

public class Destination {
    private int id;
    private String name;
    private int startDate;
    private int endDate;
    private double price;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
