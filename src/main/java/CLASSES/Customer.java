package CLASSES;

public class Customer {

    private int id;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;
    private int packageId;

    public Customer(int id, String customerName, String customerEmail, String customerPhoneNumber, int packageId) {
        this.id = id;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNumber = customerPhoneNumber;
        this.packageId = packageId;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        return "ConfirmBooking" +
                "customerName: '" + customerName + '\'' +
                ", customerEmail: '" + customerEmail + '\'' +
                ", customerPhoneNumber: '" + customerPhoneNumber + '\'' +
                ", customerPackage: " + customerPackage
                ;
    }
}
