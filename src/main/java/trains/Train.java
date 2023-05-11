package trains;


import java.util.ArrayList;
import java.util.Collection;

public abstract class Train {

    protected Collection<Train> trainTypes;
    private int initialWeight;
    private final String trainNumber;

    public Train(int initialWeight, String trainNumber) {
        trainTypes = new ArrayList<Train>();
        this.initialWeight = initialWeight;
        this.trainNumber = trainNumber;
    }

    public int getInitialWeight() {
        return initialWeight;
    }

    public void setInitialWeight(int initialWeight) {
        this.initialWeight = initialWeight;
    }

    public boolean contains(Train tc) {
        return trainTypes.contains(tc);
    }

    public int getTotalWeight() {
        int totalWeight = 0;
        for (Train tc : trainTypes) {
            totalWeight += tc.getTotalWeight();
        }
        return totalWeight;
    }

    protected String getTrainCarType() {
        return "train car";
    }

    protected String getTrainNumber() {
        return trainNumber;
    }

    public abstract void start();

    public abstract void stop();

}




