package menuSystem.menues;

import CLASSES.Destination;
import menuSystem.Menu;
import menuSystem.MenuLine;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class HandleDestinations extends Menu {
    @Override
    public void run() {
        menuTitle = "Here you can handle all Destinations currently in the system";
        menuLines = List.of(
                new MenuLine(1, "View all Destinations", this::viewAll),
                new MenuLine(2, "View details of a Destination", this::viewById),
                new MenuLine(3, "Change details of a Destination", () -> System.out.println("NOT IMPLEMENTED YET")),
                new MenuLine(4, "Add a Destination", this::addDestination),
                new MenuLine(5, "Delete a Destination from the system", this::deleteDestinationById),
                new MenuLine(6, "Go back", () -> Menu.setState(new MainMenu())),
                new MenuLine(0, "Exit program", () -> System.exit(0)))
        ;
    }

    private void viewAll() {
        for (Destination d : db.getAllDestinations()) {
            System.out.printf("""
                    ID| %s: DESTINATION: %s,
                    %n""", d.getId(), d.getName());
        }
    }

    private void viewById() {
        System.out.println("Please enter ID of desired activity to view");
        int id = scanner.nextInt();
        List<Destination> aList = db.getAllDestinations()
                .stream()
                .filter(activity -> activity.getId() == id)
                .toList();

        if (aList.size() < 1) {
            System.out.println("That id does not match anything in the database, please try again");
        } else {
            Destination d = aList.get(0);
            System.out.printf("""
                    +-------------------------------+
                    |Id: %s
                    |Name: %s
                    |Cost: %s kr
                    |Start at: %s
                    |Ends at: %s
                    +-------------------------------+
                    %n""", d.getId(), d.getName(), d.getPrice(), d.getStartDate(), d.getEndDate());
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
