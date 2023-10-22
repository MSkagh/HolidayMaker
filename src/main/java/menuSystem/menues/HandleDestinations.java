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
                new MenuLine(1, "View all Destinations", () -> {
                    for (Destination d : db.getAllDestinations()){
                        System.out.println("""
                    ID| %s: DESTINATION: %s,
                    """.formatted(d.getId(),d.getName())
                        );
                    }
                }),
                new MenuLine(2, "View details of a Destination", () -> System.out.println("NOT YET IMPLEMENTED") ),
                new MenuLine(3, "Change details of a Destination", () -> System.out.println("NOT YET IMPLEMENTED")),
                new MenuLine(3, "Delete a Destination from the system", () -> System.out.println("NOT YET IMPLEMENTED")),
                new MenuLine(0, "Exit program", () -> System.exit(0)))
        ;
    }
}
