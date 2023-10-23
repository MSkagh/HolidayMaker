package CLASSES;

public class Customer {

    private int id;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;
    private int packageId;

    private boolean isPayed;

    public Customer(int id, String customerName, String customerEmail, String customerPhoneNumber, int packageId, boolean isPayed) {
        this.id = id;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNumber = customerPhoneNumber;
        this.packageId = packageId;
        this.isPayed = isPayed;
    }

    public int getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        return "Customer: " + '\n' +
                "customerName: '" + customerName + '\n' +
                ", customerEmail: '" + customerEmail + '\n' +
                ", customerPhoneNumber: '" + customerPhoneNumber + '\n' +
                ", customerPackage: " + packageId + '\n' +
                ", isPayed: " + isPayed + '\''
                ;
    }
}
