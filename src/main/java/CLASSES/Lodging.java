package CLASSES;

import util.Parser;

import java.time.LocalDate;

public class Lodging {
    private int id;
    private final String name;
    private final int startDate;
    private final int endDate;
    private final double pricePerDay;
    private final int capacity;
    private final String location;
    /*------------------------------------------------------------------
      ------------------------------CONSTRUCTOR-------------------------
      ------------------------------------------------------------------*/
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
    /*------------------------------------------------------------------
      ------------------------------GETTERS-----------------------------
      ------------------------------------------------------------------*/
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
    public double getPricePerDay() {
        return pricePerDay;
    }
    public String getLocation() {
        return location;
    }

    /*-----------------------------------------------------------------
      ------------------------------Misc-------------------------------
      -----------------------------------------------------------------*/
    public void displayShortInfo(){
        System.out.printf("""
                ID| %s | %s
                """, id,name);
    }
    public void displayLongInfo(){
        LocalDate startDateParser = Parser.intParseToDate(startDate);
        LocalDate endDateParser = Parser.intParseToDate(endDate);
        System.out.printf("""
                   ID| %s | %s
                   --------------------------------
                   Starts at: %s
                   Ends at: %s
                   Cost per day: %s
                   Can house up to %s custards
                   --------------------------------
                   
                """ ,id, name, startDateParser,endDateParser, pricePerDay, capacity);
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
