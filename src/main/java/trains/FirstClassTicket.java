package trains;


public class FirstClassTicket implements TicketCount{

    private final int passengerCount;

    public FirstClassTicket(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    @Override
    public String toString() {
        return "FirstClassTicket, passengerCount=" + passengerCount;
    }


}