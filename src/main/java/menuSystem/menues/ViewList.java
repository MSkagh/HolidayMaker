package menuSystem.menues;

import CLASSES.*;
import CLASSES.Package;
import databaseConnection.Database;
import menuSystem.Menu;
import menuSystem.MenuLine;

import java.util.ArrayList;
import java.util.List;

public class ViewList extends Menu{
    List<Package> packageList = db.getAllPackages();
    List<Destination> destinationList = db.getAllDestinations();
    List<Activity> activityList = db.getAllActivities();
    List<Lodging> lodgingList = db.getAllLodgings();

    @Override
    public void run() {
        menuTitle = "Package menu list";
        menuLines = List.of(
                new MenuLine(1, "View available complete packages ", () -> {for( Package p : packageList){
            System.out.println(p.getName());}}),
                new MenuLine(2, "View locations ", () -> {for( Destination d : destinationList){
                    System.out.println(d.getName());}}),
                new MenuLine(3, "View activities ", () -> {for( Activity a : activityList){
                    System.out.println(a.getName());}}),
                new MenuLine(4, "View lodgings ", () ->{for( Lodging l : lodgingList){
                    System.out.println(l.getName() + " | " + l.getLocation() );}}),
                new MenuLine(5, "Back ", () -> Menu.setState(new Booking())),
                new MenuLine(0, "Exit program", () -> System.exit(0)));
    }




}
