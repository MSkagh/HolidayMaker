package CLASSES;

public class Orders {

    private final int id;
    private final String customerName;
    private final String customerEmail;
    private final String customerPhoneNumber;
    private final Package poop;
    private final String extra;
    private final boolean isPayed;
    /*------------------------------------------------------------------
      ------------------------------CONSTRUCTOR-------------------------
      ------------------------------------------------------------------*/
    public Orders(int id, String customerName, String customerEmail, String customerPhoneNumber, boolean isPayed, Package p, String extra) {
        this.id = id;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNumber = customerPhoneNumber;
        this.isPayed = isPayed;
        this.poop = p;
        this.extra = extra;
    }
    /*------------------------------------------------------------------
      ------------------------------GETTERS-----------------------------
      ------------------------------------------------------------------*/
    public int getId() {
        return id;
    }

    /*------------------------------------------------------------------
      ------------------------------MISC--------------------------------
      ------------------------------------------------------------------*/
    public void displayShortInfo(){
        System.out.printf("""
                ID| %s | %s  | Has cleared all debts: %s
                """, id,customerName,isPayed);
    }
    public void displayLongInfo(){
        if (poop !=null) {
            System.out.printf("""
                       ID| %s | %s  |Has paid: %s
                       --------------------------------
                       Contact information
                       Phone Number: %s
                       Email: %s
                       --------------------------------
                       Booking details
                       Package: %s
                       Destination: %s
                       Activity: %s
                       Lodging: %s
                       Departure date: %s
                       Return date: %s
                       --------------------------------
                       Additional comments:
                       %s
                       
                    """, id, customerName, isPayed, customerPhoneNumber, customerEmail, poop.getName(), poop.getDestination().getName(), poop.getActivity().getName(), poop.getLodging().getName(), poop.getDestination().getStartDate(), poop.getDestination().getEndDate(), extra);
        }else {
            System.out.println("Ops, something broke in the database. Code monkeys are on the job");
        }
    }
    @Override
    public String toString() {
        return "Customer: " + '\n' +
                "customerName: '" + customerName + '\n' +
                ", customerEmail: '" + customerEmail + '\n' +
                ", customerPhoneNumber: '" + customerPhoneNumber + '\n' +
                ", isPayed: " + isPayed + '\''
                ;
    }
}
