package menuSystem.menues;

import CLASSES.Orders;
import menuSystem.Menu;
import menuSystem.MenuLine;
import java.util.List;
import java.util.Scanner;

public class HandleOrders extends Menu {
    @Override
    public void run() {
        menuTitle = "<--Here you can handle all Orders  currently in the system-->";
        menuLines = List.of(
                new MenuLine(1, "View all Orders", this::viewAll),
                new MenuLine(2, "View details of a Order", this::viewDetails ),
                new MenuLine(3, "Delete a Order from the system", this::deleteOrderById),
                new MenuLine(4, "Add Order", this::addOrder),
                new MenuLine(5, "Accept customers payment", this::acceptCustomersPayById),
                new MenuLine(6, "Go back", () -> Menu.setState(new MainMenu())),
                new MenuLine(0, "Exit program", () -> System.exit(0)))
        ;
    }
    private void viewAll(){
        System.out.println();
        db.getAllCustomer().forEach(Orders::displayShortInfo);
        System.out.println();
    }
    private void viewDetails(){
        System.out.println("Select the customers id");
        int selectId = scanner.nextInt();
        db.getAllCustomer().stream().filter(customer -> customer.getId() == selectId).forEach(Orders::displayLongInfo);
    }

    private void addOrder() {
        Scanner custScanner = new Scanner(System.in);
        System.out.println("Please enter the name of the Customer: ");
        String name = custScanner.nextLine();

        System.out.println("Please enter the email of the Customer: ");
        String email = custScanner.nextLine();

        System.out.println("Please enter the phone number of the Customer: ");
        String phoneNumber = custScanner.nextLine();

        HandlePackages.viewAll();
        System.out.println("Please enter the PACKAGE IDENTIFICATION:");
        int packageId = custScanner.nextInt();

        custScanner = new Scanner(System.in);
        System.out.println("Please enter extra requests from the Customer: ");
        String extra = custScanner.nextLine();

        db.createOrder(name, email, phoneNumber, packageId, extra);

    }
    private void deleteOrderById(){
        System.out.println("Please enter id: ");
        int selectId = scanner.nextInt();
        db.deleteById(selectId, "Orders");
    }

    private void acceptCustomersPayById(){
        System.out.println("Enter the order id: ");
        int selectId = scanner.nextInt();
        db.updateOrderById(selectId);
    }
}
