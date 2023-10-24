package CLASSES;

public class Orders {

    private int id;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;
    private int packageId;
    private Package poop;
    private String extra;

    private boolean isPayed;

    public Orders(int id, String customerName, String customerEmail, String customerPhoneNumber, boolean isPayed, Package p, String extra) {
        this.id = id;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNumber = customerPhoneNumber;
        this.isPayed = isPayed;
        this.poop = p;
        this.extra = extra;


    }

    public String getExtra() {
        return extra;
    }

    public Package getPoop() {
        return poop;
    }

    public boolean isPayed() {
        return isPayed;
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
