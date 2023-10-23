package menuSystem.menues;

import CLASSES.Destination;
import menuSystem.Menu;
import menuSystem.MenuLine;

import java.util.List;

public class HandleDestinations extends Menu {
    @Override
    public void run() {
        menuTitle = "Here you can handle all Destinations currently in the system";
        menuLines = List.of(
                new MenuLine(1, "View all Destinations", this::viewAll),
                new MenuLine(2, "View details of a Destination", this::viewById),
                new MenuLine(3, "Change details of a Destination", () -> System.out.println("NOT YET IMPLEMENTED")),
                new MenuLine(4, "Delete a Destination from the system", this::deleteDestinationById),
                new MenuLine(5, "Go back", () -> Menu.setState(new Booking())),
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
    private void deleteDestinationById(){
        System.out.println("Please enter id: ");
        int selectId = scanner.nextInt();
        db.deleteById(selectId, "Destinations");
    }
}
