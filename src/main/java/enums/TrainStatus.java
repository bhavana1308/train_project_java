package enums;

public enum TrainStatus {

    ARRIVED("arrived"),
    DEPARTED("departed");

    private final String trainStatus;

    TrainStatus(String trainStatus) {
        this.trainStatus = trainStatus;
    }

    public String getTrainStatus() {
        return trainStatus;
    }

    @Override
    public String toString() {
        return  "Train is "+ getTrainStatus()+" at the station.";
    }

}

