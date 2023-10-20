package menuSystem.menues;

import CLASSES.ShowConfirmedBookings;
import databaseConnection.Database;
import menuSystem.Menu;
import menuSystem.MenuLine;

import java.util.List;

public class Booking extends Menu {
    @Override
    public void run() {
        menuTitle = "Bookings menu";
        menuLines = List.of(
                new MenuLine(1, "Start", () -> Menu.setState(new Start())),
                new MenuLine(2, "View all packages", () -> HandleBookings.getInstance().selectPackage() ),
                new MenuLine(3, "View bookings", () -> ShowConfirmedBookings.getInstance().showConfirmedBookings()),
                new MenuLine(0, "Exit program", () -> System.exit(0)))
        ;
    }
}
