package menuSystem.menues;

import CLASSES.Activity;

import CLASSES.Package;
import menuSystem.Menu;
import menuSystem.MenuLine;

import java.util.List;

public class HandlePackages extends Menu {
    @Override
    public void run() {
        menuTitle = "Here you can handle all Packages currently in the system";
        menuLines = List.of(
                new MenuLine(1, "View all Packages", () -> {
                    for (Package p : db.getAllPackages()){
                        System.out.println("""
                    ID| %s: ACTIVITY: %s,
                    """.formatted(p.getId(),p.getName())
                        );
                    }
                }),
                new MenuLine(2, "View details of a Package", () -> System.out.println("NOT YET IMPLEMENTED") ),
                new MenuLine(3, "Change details of a Package", () -> System.out.println("NOT YET IMPLEMENTED")),
                new MenuLine(3, "Delete a Package from the system", () -> System.out.println("NOT YET IMPLEMENTED")),
                new MenuLine(0, "Exit program", () -> System.exit(0)))
        ;
    }
}
