package CLASSES;

public class ConfirmBooking {

    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;
    private Package customerPackage;

    public ConfirmBooking(String customerName, String customerEmail, String customerPhoneNumber, Package customerPackage) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerPackage = customerPackage;
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
