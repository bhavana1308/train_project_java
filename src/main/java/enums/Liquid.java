package enums;

public enum Liquid {

    CHEMICAL("Chemical liquid"),
    PETROLEUM(" Petroleum liquid");

    private final String displayName;

    Liquid(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return  "Tank train has "+ getDisplayName();

    }

}
