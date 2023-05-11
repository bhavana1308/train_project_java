package enums;

public enum TicketClass {

    FIRST_CLASS("First class Tickets"),
    REGULAR("Regular class Tickets");

    private final String ticketClass;

    TicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    public String getTicketClass() {
        return ticketClass;
    }

    @Override
    public String toString() {
        return "Passenger Train has " +getTicketClass();
    }

}
