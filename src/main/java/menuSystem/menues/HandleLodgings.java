package menuSystem.menues;

import CLASSES.Lodging;
import menuSystem.Menu;
import menuSystem.MenuLine;

import java.util.List;

public class HandleLodgings extends Menu {
    @Override
    public void run() {
        menuTitle = "Here you can handle all Lodgings currently in the system";
        menuLines = List.of(
                new MenuLine(1, "View all Activities", () -> {
                    for (Lodging l : db.getAllLodgings()){
                        System.out.println("""
                    ID| %s: ACTIVITY: %s,
                    """.formatted(l.getId(),l.getName())
                        );
                    }
                }),
                new MenuLine(2, "View details of a Lodging", () -> System.out.println("NOT YET IMPLEMENTED") ),
                new MenuLine(3, "Change details of a Lodging", () -> System.out.println("NOT YET IMPLEMENTED")),
                new MenuLine(4, "Delete a Lodging from the system", () -> System.out.println("NOT YET IMPLEMENTED")),
                new MenuLine(0, "Exit program", () -> System.exit(0)))
        ;
    }
}
