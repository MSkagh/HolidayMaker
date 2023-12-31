package menuSystem.menues;

import CLASSES.Lodging;
import menuSystem.Menu;
import menuSystem.MenuLine;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandleLodgings extends Menu {
    @Override
    public void run() {
        menuTitle = "<--Here you can handle all Lodgings currently in the system-->";
        menuLines = List.of(
                new MenuLine(1, "View all Activities", this::viewAll),
                new MenuLine(2, "View details of a Lodging", this::viewById),
                new MenuLine(3, "Change details of a Lodging", this::updateLodgingById),
                new MenuLine(4, "Add a Lodging from the system", this::addLodging),
                new MenuLine(5, "Delete a Lodging from the system", this::deleteLodgingById),
                new MenuLine(6, "Go back", () -> Menu.setState(new MainMenu())),
                new MenuLine(0, "Exit program", () -> System.exit(0)))
        ;
    }
    private void viewAll(){
        System.out.println();
        for (Lodging l : db.getAllLodgings()){
          l.displayShortInfo();
        }
        System.out.println();
    }
    private void viewById() {
        System.out.println("Please enter ID of desired activity to view");
        int selectId = scanner.nextInt();
        db.getAllLodgings().stream().filter(customer -> customer.getId() == selectId).forEach(Lodging::displayLongInfo);
    }

    private void updateLodgingById(){
        System.out.println("Please enter id: ");
        int selectId = scanner.nextInt();
        System.out.println("""
                What would you like to change?
                name | pricePerDay | startDate | endDate | location | capacity
                 """);
        String key = scanner.next();
        System.out.println("Please enter value: ");
        switch (key) {
            case "pricePerDay" -> {
                double value = scanner.nextDouble();
                db.updateById("Lodgings", "Lodging", selectId, key, new ArrayList<>(List.of(value)));
            }
            case "startDate", "endDate", "capacity" -> {
                int value = scanner.nextInt();
                db.updateById("Lodgings", "Lodging", selectId, key, new ArrayList<>(List.of(value)));
            }
            case "name", "location" -> {
                scanner = new Scanner(System.in);
                String value = scanner.nextLine();
                db.updateById("Lodgings", "Lodging", selectId, key, new ArrayList<>(List.of(value)));
            }
            default -> System.out.println("No such value");
        }
    }

    private void addLodging() {
       Scanner testScanner = new Scanner(System.in);
        System.out.println("Please enter the name of the lodging: ");
        String name = testScanner.nextLine();

        System.out.println("Please enter the location of the lodging: ");
        String location = testScanner.nextLine();

        System.out.println("Please enter the start date of the lodging: ");
        int startDate = testScanner.nextInt();

        System.out.println("Please enter the end date of the lodging: ");
        int endDate = testScanner.nextInt();

        System.out.println("Please enter the price of the lodging: ");
        double pricePerDay = testScanner.nextDouble();

        System.out.println("Please enter the capacity of the lodging: ");
        int capacity = testScanner.nextInt();




        db.createLodging(name, startDate, endDate, pricePerDay, capacity, location);

    }

    private void deleteLodgingById(){
        System.out.println("Please enter id: ");
        int selectId = scanner.nextInt();
        db.deleteById(selectId, "Lodgings");
    }
}
