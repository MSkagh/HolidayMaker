package menuSystem.menues;

import CLASSES.Activity;
import menuSystem.Menu;
import menuSystem.MenuLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandleActivities extends Menu {
    @Override
    public void run() {
        menuTitle = "<-Here you can handle all Activities currently in the system->";
        menuLines = List.of(
                new MenuLine(1, "View all Activities", this::viewAll),
                new MenuLine(2, "View details of an activity by ID", this::viewById),
                new MenuLine(3, "Change details of an activity by ID", this::updateActivityById),
                new MenuLine(4, "Add an activity to the system", this::addActivity),
                new MenuLine(5, "Delete an activity from the system", this::deleteActivityById),
                new MenuLine(6, "Go back", () -> Menu.setState(new MainMenu())),
                new MenuLine(0, "Exit program", () -> System.exit(0)))
        ;
    }
    private void viewAll(){
        System.out.println(" ");
        for (Activity a : db.getAllActivities()) {
            a.displayShortInfo();
        }
        System.out.println(" ");
    }
    private void viewById(){
        System.out.println("Please enter ID of desired activity to view");
        int selectId = scanner.nextInt();
        db.getAllActivities().stream().filter(customer -> customer.getId() == selectId).forEach(Activity::displayLongInfo);

    }
    private void updateActivityById(){
        System.out.println("Please enter id: ");
        int selectId = scanner.nextInt();
        System.out.println("""
                What would you like to change?
                name | price | startDate | endDate | location
                 """);
        String key = scanner.next();

        System.out.println(key);


        System.out.println("Please enter value: ");
        if(key.equals("price")){
            double value = scanner.nextDouble();
            System.out.println(value);

            db.updateById("Activities", "Activity", selectId, key, new ArrayList<>(List.of(value)));
        }else if(key.equals("startDate") || key.equals("endDate")){
             int value = scanner.nextInt();
             System.out.println(value);

            db.updateById("Activities", "Activity", selectId, key, new ArrayList<>(List.of(value)));
        }else{
            scanner = new Scanner(System.in);
            String value = scanner.nextLine();
            System.out.println(value);

            db.updateById("Activities", "Activity", selectId, key, new ArrayList<>(List.of(value)));
        }

    }

    private void addActivity() {
        Scanner activScanner = new Scanner(System.in);
        System.out.println("Please enter the name of the activity: ");
        String name = activScanner.nextLine();

        System.out.println("Please enter the location of the activity: ");
        String location = activScanner.nextLine();


        System.out.println("Please enter the start date of the activity: ");
        int startDate = activScanner.nextInt();

        System.out.println("Please enter the end date of the activity: ");
        int endDate = activScanner.nextInt();

        System.out.println("Please enter the price of the activity: ");
        double price = activScanner.nextDouble();

        db.createActivity(name, startDate, endDate, price, location);

    }

    private void deleteActivityById(){
        System.out.println("Please enter id: ");
        int selectId = scanner.nextInt();
        db.deleteById(selectId, "Activities");
    }

}
