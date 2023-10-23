package menuSystem.menues;

import CLASSES.Activity;
import menuSystem.Menu;
import menuSystem.MenuLine;

import java.util.ArrayList;
import java.util.List;

public class HandleActivities extends Menu {
    @Override
    public void run() {
        menuTitle = "Here you can handle all Activities currently in the system";
        menuLines = List.of(
                new MenuLine(1, "View all Activities", this::viewAll),
                new MenuLine(2, "View details of an activity by ID", this::viewById),
                new MenuLine(3, "Change details of an activity by ID", this::updateActivityById),
                new MenuLine(4, "Add an activity to the system", () -> System.out.println("NOT YET IMPLEMENTED")),
                new MenuLine(5, "Delete an activity from the system", this::deleteActivityById),
                new MenuLine(6, "Go back", () -> Menu.setState(new Booking())),
                new MenuLine(0, "Exit program", () -> System.exit(0)))
        ;
    }
    private void viewAll(){
        for (Activity a : db.getAllActivities()) {
            System.out.printf("""
                                ID| %s: ACTIVITY: %s,
                                %n""", a.getId(), a.getName());
        }
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

    }
    private void updateActivityById(){
        System.out.println("Please enter id: ");
        int selectId = scanner.nextInt();
        System.out.println("""
                What would you like to change?
                name | price | startDate | endDate | location 
                 """);
        String key = scanner.nextLine();
        scanner.next();
        System.out.println("Please enter value: ");
        if(key.equals("price")){
            double value = scanner.nextDouble();
            db.updateById("Activities", "Activity", selectId, key, new ArrayList<>(List.of(value)));
        }else if(key.equals("startDate") || key.equals("endDate")){
             int value = scanner.nextInt();
            db.updateById("Activities", "Activity", selectId, key, new ArrayList<>(List.of(value)));
        }else{
            String value = scanner.nextLine();
            db.updateById("Activities", "Activity", selectId, key, new ArrayList<>(List.of(value)));
        }

    }

    private void deleteActivityById(){
        System.out.println("Please enter id: ");
        int selectId = scanner.nextInt();
        db.deleteById(selectId, "Activities");
    }

}
