package menuSystem;

import databaseConnection.Database;
import menuSystem.menues.Start;
import java.util.List;
import java.util.Scanner;

public abstract class Menu implements State {

    protected static Database db = new Database();
    protected static Scanner scanner = new Scanner(System.in);
    protected static List<MenuLine> menuLines;
    protected static String menuTitle;
    private static State state = new Start();


    public static void setState(State state){
        Menu.state = state;
    }

    public static void start() {

        state.run();
        Menu.db.updateDatabase();
        show();
        int choice = scanner.nextInt();
        menuLines.forEach(menuLine -> {
            if (menuLine.getIndex() == choice) menuLine.run();
        });
    }
    protected static void show(){
        System.out.println(menuTitle);
        menuLines.forEach(System.out::println);
    }
}
