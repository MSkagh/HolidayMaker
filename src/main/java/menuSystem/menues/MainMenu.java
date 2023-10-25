package menuSystem.menues;


import menuSystem.Menu;
import menuSystem.MenuLine;

import java.util.List;

public class MainMenu extends Menu {
    @Override
    public void run() {
        menuTitle = "<--Main menu-->";
        menuLines = List.of(
                new MenuLine(1, "Handle Orders", () -> Menu.setState(new HandleOrders())),
                new MenuLine(2, "Handle Packages", () -> Menu.setState(new HandlePackages()) ),
                new MenuLine(3, "Handle Destinations", () -> Menu.setState(new HandleDestinations())),
                new MenuLine(4, "Handle Activities", () -> Menu.setState(new HandleActivities())),
                new MenuLine(5, "Handle Lodgings", () -> Menu.setState(new HandleLodgings())),
                new MenuLine(0, "Exit program", () -> System.exit(0)))
        ;
    }
}
