package menuSystem.menues;

import CLASSES.Activity;
import CLASSES.Destination;
import CLASSES.Lodging;
import CLASSES.Package;
import menuSystem.Menu;
import menuSystem.MenuLine;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class HandlePackages extends Menu {
    @Override
    public void run() {
        menuTitle = "Here you can handle all Packages currently in the system";
        menuLines = List.of(
                new MenuLine(1, "View all Packages", HandlePackages::viewAll),
                new MenuLine(2, "View details of a Package", this::viewById),
                new MenuLine(3, "Add a Package", this::addPackage),
                new MenuLine(4, "Delete a Package from the system", this::deletePackageById),
                new MenuLine(5, "Go back", () -> Menu.setState(new MainMenu())),
                new MenuLine(0, "Exit program", () -> System.exit(0)))
        ;
    }
    public static void viewAll(){
        System.out.println();
        for (Package p : db.getAllPackages()){
            p.displayShortInfo();
        }
        System.out.println();
    }
    private void viewById(){
        System.out.println("Please enter ID of desired activity to view");
        int selectId = scanner.nextInt();
        db.getAllPackages().stream().filter(customer -> customer.getId() == selectId).forEach(Package::displayLongInfo);
    }
    public void addPackage (){
        System.out.println("What will the package be named:");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        for (Destination d: db.getAllDestinations() ){
            System.out.printf("id: %s | %s\n", d.getId(), d.getName());
        }
        System.out.println("Choose destination by id:");
        int dest = scanner.nextInt();
        List<Destination> filteredDestList = db.getAllDestinations().stream().filter(d -> d.getId() == dest).toList();
        Destination chosenDestination =  filteredDestList.get(0);

        System.out.println("Choose activity:");
        List<Activity> filteredActList = db.getAllActivities().stream().filter( a -> Objects.equals(a.getLocation(), chosenDestination.getName())).toList();

        for (Activity a: filteredActList ){
            System.out.printf("id: %s | %s\n", a.getId(), a.getName());
        }
        int actInt = scanner.nextInt();
        List<Activity> activitySingleton = filteredActList.stream().filter(d -> d.getId() == actInt).toList();
        Activity chosenActivity = activitySingleton.get(0);

        for (Lodging l: db.getAllLodgings().stream().filter(lodging -> lodging.getLocation().equals(chosenDestination.getName())).toList()){
            System.out.printf("id: %s | %s\n", l.getId(), l.getName());
        }
        System.out.println("Choose lodging by id:");
        int lodInt = scanner.nextInt();
        List<Lodging> lodgingSingleton = db.getAllLodgings().stream().filter(lodging -> lodging.getLocation().equals(chosenDestination.getName())).filter(d -> d.getId() == lodInt).toList();
        Lodging chosenLodging = lodgingSingleton.get(0);



       db.createPackage(name, chosenDestination, chosenActivity, chosenLodging);
    }
    private void deletePackageById(){
        System.out.println("Please enter id: ");
        int selectId = scanner.nextInt();
        db.deleteById(selectId, "Packages");
    }
}
