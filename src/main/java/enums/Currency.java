package enums;

public enum Currency {

    DOLLARS("Ticket price is in Dollars");

    private final String displayName;

    Currency(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
