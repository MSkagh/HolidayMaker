package menuSystem.menues;

import CLASSES.Customer;
import menuSystem.Menu;
import menuSystem.MenuLine;

import java.util.ArrayList;
import java.util.List;

public class HandleCustomers extends Menu {
    @Override
    public void run() {
        menuTitle = "Here you can handle all Customers currently in the system";
        menuLines = List.of(
                new MenuLine(1, "View all Customers", this::viewAll),
                new MenuLine(2, "View details of a Customer", this::viewDetails ),
                new MenuLine(3, "Delete a Customer from the system", this::deleteCustomerById),
                new MenuLine(4, "Accept customers payment", this::acceptCustomersPayById),
                new MenuLine(5, "Go back", () -> Menu.setState(new Booking())),
                new MenuLine(0, "Exit program", () -> System.exit(0)))
        ;
    }
    private void viewAll(){
        for (Customer c : db.getAllCustomer()){
            System.out.printf("""
                                 ID: %s
                                CUSTOMER: %s,
                                %n""", c.getId(), c.getCustomerName());
        }
    }
    private void viewDetails(){
        System.out.println("Select the customers id");
        int selectId = scanner.nextInt();
        List<Customer> tempList = db.getAllCustomer();

        tempList.stream().filter(customer -> customer.getId() == selectId)
                .forEach(System.out::println);
    }

    private void deleteCustomerById(){
        System.out.println("Please enter id: ");
        int selectId = scanner.nextInt();
        db.deleteById(selectId, "Customers");
    }

    private void acceptCustomersPayById(){
        System.out.println("Enter customers id: ");
        int selectId = scanner.nextInt();
        db.updateCustomerById(selectId);
    }
}
