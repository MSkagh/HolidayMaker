package menuSystem.menues;

import CLASSES.ConfirmBooking;
import CLASSES.Package;
import databaseConnection.Database;
import menuSystem.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class HandleBookings {
    private Database db = new Database();

    private List<Package> packageList = db.getAllPackages();
    Scanner scanner = new Scanner(System.in);
    public static final HandleBookings instance = new HandleBookings();

    private static Package chosenPackage;

    List<ConfirmBooking> confirmedBookingList = new ArrayList<>();
    public static HandleBookings getInstance() {
        return instance;
    }

    public void selectPackage() {
        viewPackages();
    }

    public List<Package> getPackageList() {
        return packageList;
    }

    private void choice() {

        System.out.println("Select package");
        int packageChoice = scanner.nextInt();
        chosenPackage = loopThroughPackageList(packageChoice).get(0);
        confirmBooking();
    }

    public List<Package> loopThroughPackageList(int packageChoice) {
        List<Package> tempList = new ArrayList<>();
        for (Package p : packageList) {
            int packageId = p.getId();
            if (packageChoice == packageId) {
                System.out.println(p);
                tempList.add(p);
            }
        }
        return tempList;
    }

    public List<ConfirmBooking> confirmedBookingList() {
        List<ConfirmBooking> tempList = new ArrayList<>();
        for (ConfirmBooking c : confirmedBookingList) {
            tempList.add(c);
        }
        return tempList;
    }

    public ConfirmBooking bookingQuestions(){
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter email: ");
        String email = scanner.next();
        System.out.print("Enter phonenumber: ");
        String phonenumber = scanner.next();
        ConfirmBooking confirmedBooking = new ConfirmBooking(name, email, phonenumber, chosenPackage);
        System.out.print(confirmedBooking);
        db.createNewBooking(name, email, phonenumber,chosenPackage);
        confirmedBookingList.add(confirmedBooking);

        return confirmedBooking;
    }

    public void confirmBooking(){
        System.out.print("Are you really sure? (y/n)");
       String choice = scanner.next();

       if (choice.equals("y")){
           bookingQuestions();


       }else {
           Menu.setState(new Booking());

       }

    }
    private void viewPackages(){
        System.out.println(packageList);
        choice();
    }
    }

