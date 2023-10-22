package menuSystem.menues;

import CLASSES.Activity;
import CLASSES.ShowConfirmedBookings;
import menuSystem.Menu;
import menuSystem.MenuLine;

import java.time.LocalDate;
import java.util.List;

public class HandleActivities extends Menu {
    @Override
    public void run() {
        menuTitle = "Here you can handle all Activities currently in the system";
        menuLines = List.of(
                new MenuLine(1, "View all Activities", () -> {
                    for (Activity a : db.getAllActivities()) {
                        System.out.printf("""
                                ID| %s: ACTIVITY: %s,
                                %n""", a.getId(), a.getName());
                    }
                }),
                new MenuLine(2, "View details of an activity by ID", this::viewById),
                new MenuLine(3, "Change details of an activity by ID", () -> System.out.println("NOT YET IMPLEMENTED")),
                new MenuLine(3, "Delete an activity from the system", () -> System.out.println("NOT YET IMPLEMENTED")),
                new MenuLine(0, "Exit program", () -> System.exit(0)))
        ;
    }

    private void viewById(){
        System.out.println("Please enter ID of desired activity to view");
        int id = scanner.nextInt();
        List<Activity> aList = db.getAllActivities()
                .stream()
                .filter(activity -> activity.getId() == id)
                .toList();

        if(aList.size()<1){
            System.out.println("That id does not match anything in the database, please try again");
        }else {
            Activity a = aList.get(0);
            System.out.printf("""
                    +-------------------------------+
                    |Id: %s
                    |Name: %s
                    |Available at: %s
                    |Cost: %s kr
                    |Start at: %s
                    |Ends at: %s
                    +-------------------------------+
                    %n""", a.getId(),a.getName(),a.getLocation(),a.getPrice(),a.getStartDate(),a.getEndDate());
        }

    };

}
