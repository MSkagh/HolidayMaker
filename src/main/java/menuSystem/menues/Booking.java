package menuSystem.menues;


import menuSystem.Menu;
import menuSystem.MenuLine;

import java.util.List;

public class Booking extends Menu {
    @Override
    public void run() {
        menuTitle = "Bookings menu";
        menuLines = List.of(
                new MenuLine(1, "Handle Packages", () -> Menu.setState(new HandlePackages()) ),
                new MenuLine(2, "Handle Destinations", () -> Menu.setState(new HandleDestinations())),
                new MenuLine(3, "Handle Activities", () -> Menu.setState(new HandleActivities())),
                new MenuLine(4, "Handle Lodgings", () -> Menu.setState(new HandleLodgings())),
                new MenuLine(5, "Handle Customers", () -> Menu.setState(new HandleCustomers())),
                new MenuLine(0, "Exit program", () -> System.exit(0)))
        ;
    }
}
