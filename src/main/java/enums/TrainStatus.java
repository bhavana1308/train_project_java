package enums;

public enum TrainStatus {

    ARRIVED("arrived"),
    DEPARTED("departed");

    private final String displayName;

    TrainStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }

    @Override
    public String toString() {
        return  "Train is "+ getDisplayName()+" at the station.";
    }

}

