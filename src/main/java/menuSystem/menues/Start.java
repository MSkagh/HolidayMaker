package menuSystem.menues;

import menuSystem.Menu;
import menuSystem.MenuLine;

import java.util.List;

public class Start extends Menu {
    @Override
    public void run() {
        menuTitle = """
                +--------------------------------------------------------------------+
                  ||      ||  ||====  ||        ====    ===    ||       ||  ||====
                  ||      ||  ||      ||      ||      ||   ||  || || || ||  ||
                  ||  ||  ||  ||===   ||      ||      ||   ||  ||   ||  ||  ||===
                  ||  ||  ||  ||      ||      ||      ||   ||  ||       ||  ||
                    ||  ||    ||====  ||=====   ====    ===    ||       ||  ||====
                +--------------------------------------------------------------------+""";
        menuLines = List.of(
                new MenuLine(1, "Start", () -> Menu.setState(new MainMenu())),
                new MenuLine(0, "Exit program", () -> System.exit(0)));
    }
}
