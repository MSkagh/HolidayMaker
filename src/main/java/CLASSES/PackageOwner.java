package CLASSES;

public class PackageOwner {
    private Package travelPackage;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

    private int amountOfTravellers;

    public PackageOwner(Package travelPackage, String name, String email, String phoneNumber, String address, int amountOfTravellers) {
        this.travelPackage = travelPackage;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.amountOfTravellers = amountOfTravellers;
    }

    public Package getTravelPackage() {
        return travelPackage;
    }

    public void setTravelPackage(Package travelPackage) {
        this.travelPackage = travelPackage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAmountOfTravellers() {
        return amountOfTravellers;
    }

    public void setAmountOfTravellers(int amountOfTravellers) {
        this.amountOfTravellers = amountOfTravellers;
    }
}
