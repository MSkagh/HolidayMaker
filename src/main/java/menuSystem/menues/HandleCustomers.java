package menuSystem.menues;

import CLASSES.Customer;
import menuSystem.Menu;
import menuSystem.MenuLine;

import java.util.List;

public class HandleCustomers extends Menu {
    @Override
    public void run() {
        menuTitle = "Here you can handle all Customers currently in the system";
        menuLines = List.of(
                new MenuLine(1, "View all Customers", this::viewAll),
                new MenuLine(2, "View details of a Customer", () -> System.out.println("NOT YET IMPLEMENTED") ),
                new MenuLine(3, "Delete a Customer from the system", () -> System.out.println("NOT YET IMPLEMENTED")),
                new MenuLine(4, "Go back", () -> Menu.setState(new Booking())),
                new MenuLine(0, "Exit program", () -> System.exit(0)))
        ;
    }
    private void viewAll(){
        for (Customer c : db.getAllCustomer()){
            System.out.printf("""
                                CUSTOMER: %s,
                                %n""", c.getCustomerName());
        }
    }
}
