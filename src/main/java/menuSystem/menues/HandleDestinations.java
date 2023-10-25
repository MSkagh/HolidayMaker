package menuSystem.menues;


import CLASSES.Destination;
import menuSystem.Menu;
import menuSystem.MenuLine;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandleDestinations extends Menu {
    @Override
    public void run() {
        menuTitle = "<--Here you can handle all Destinations currently in the system-->";
        menuLines = List.of(
                new MenuLine(1, "View all Destinations", this::viewAll),
                new MenuLine(2, "View details of a Destination", this::viewById),
                new MenuLine(3, "Change details of a Destination", this::updateDestinationById),
                new MenuLine(4, "Add a Destination", this::addDestination),
                new MenuLine(5, "Delete a Destination from the system", this::deleteDestinationById),
                new MenuLine(6, "Go back", () -> Menu.setState(new MainMenu())),
                new MenuLine(0, "Exit program", () -> System.exit(0)))
        ;
    }

    private void viewAll() {
        System.out.println();
        for (Destination d : db.getAllDestinations()) {
            d.displayShortInfo();
        }
        System.out.println();
    }

    private void viewById() {
        System.out.println("Please enter ID of the desired destination to view");
        int selectId = scanner.nextInt();
        db.getAllDestinations().stream().filter(customer -> customer.getId() == selectId).forEach(Destination::displayLongInfo);
    }

    private void updateDestinationById(){
        System.out.println("Please enter id: ");
        int selectId = scanner.nextInt();
        System.out.println("""
                What would you like to change?
                name | price | startDate | endDate
                 """);
        String key = scanner.next();
        System.out.println("Please enter value: ");
        switch (key) {
            case "price" -> {
                double value = scanner.nextDouble();
                db.updateById("Destinations", "Destination", selectId, key, new ArrayList<>(List.of(value)));
            }
            case "startDate", "endDate" -> {
                int value = scanner.nextInt();
                db.updateById("Destinations", "Destination", selectId, key, new ArrayList<>(List.of(value)));
            }
            case "name" -> {
                scanner = new Scanner(System.in);
                String value = scanner.nextLine();
                db.updateById("Destinations", "Destination", selectId, key, new ArrayList<>(List.of(value)));
            }
            default -> System.out.println("No such value");
        }

    }

    private void addDestination() {
        Scanner destScanner = new Scanner(System.in);
        System.out.println("Please enter the name of the destination: ");
        String name = destScanner.next();

        System.out.println("Please enter the start date of the destination: ");
        int startDate = destScanner.nextInt();

        System.out.println("Please enter the end date of the destination: ");
        int endDate = destScanner.nextInt();

        System.out.println("Please enter the price of the destination: ");
        double price = destScanner.nextDouble();

        db.createDestination(name, startDate, endDate, price);

    }
    private void deleteDestinationById(){
        System.out.println("Please enter id: ");
        int selectId = scanner.nextInt();
        db.deleteById(selectId, "Destinations");
    }
}
