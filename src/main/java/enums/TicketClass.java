package enums;

public enum TicketClass {

    FIRST_CLASS("First class Tickets"),
    REGULAR("Regular class Tickets");

    private final String displayName;

    TicketClass(String ticketClass) {
        this.displayName = ticketClass;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return "Passenger Train has " + getDisplayName();
    }

}
