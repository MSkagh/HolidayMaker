package menuSystem.menues;

import CLASSES.Destination;
import CLASSES.Lodging;
import menuSystem.Menu;
import menuSystem.MenuLine;

import java.util.List;

public class HandleLodgings extends Menu {
    @Override
    public void run() {
        menuTitle = "Here you can handle all Lodgings currently in the system";
        menuLines = List.of(
                new MenuLine(1, "View all Activities", this::viewAll),
                new MenuLine(2, "View details of a Lodging", this::viewById),
                new MenuLine(3, "Change details of a Lodging", () -> System.out.println("NOT YET IMPLEMENTED")),
                new MenuLine(4, "Delete a Lodging from the system", () -> System.out.println("NOT YET IMPLEMENTED")),
                new MenuLine(0, "Exit program", () -> System.exit(0)))
        ;
    }
    private void viewAll(){
        for (Lodging l : db.getAllLodgings()){
            System.out.printf("""
                    ID| %s: ACTIVITY: %s,
                    %n""", l.getId(),l.getName());
        }
    }
    private void viewById() {
        System.out.println("Please enter ID of desired activity to view");
        int id = scanner.nextInt();
        List<Lodging> aList = db.getAllLodgings()
                .stream()
                .filter(activity -> activity.getId() == id)
                .toList();

        if (aList.size() < 1) {
            System.out.println("That id does not match anything in the database, please try again");
        } else {
            Lodging d = aList.get(0);
            System.out.printf("""
                    +-------------------------------+
                    |Id: %s
                    |Name: %s
                    |Located in: %s
                    |Cost per day: %s kr
                    |Available from: %s
                    |Until: %s
                    +-------------------------------+
                    %n""", d.getId(), d.getName(),d.getLocation(), d.getPricePerDay(), d.getStartDate(), d.getEndDate());
        }
    }
}
