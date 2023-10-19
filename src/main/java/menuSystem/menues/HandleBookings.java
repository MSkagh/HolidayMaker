package menuSystem.menues;

import CLASSES.Package;
import databaseConnection.Database;
import menuSystem.Menu;

import java.util.List;
import java.util.Scanner;


public class HandleBookings {
    private Database db = new Database();

    private List<Package> packageList = db.getAllPackages();
    Scanner scanner = new Scanner(System.in);
    public static final HandleBookings instance = new HandleBookings();



    public static HandleBookings getInstance(){
        return instance;
    }

    public void selectPackage(){
        viewPackages();
    }

    private void choice(){
        System.out.println("Select package");
        int packageChoice = scanner.nextInt();

        for (Package p : packageList){
          int packageId = p.getId();
            if (packageChoice == packageId) {
                System.out.println(p);
            }
        }

    }

    private void viewPackages(){
        System.out.println(packageList);
        choice();
    }

    }

