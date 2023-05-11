package trains;

import exception.InvalidPackageException;


public class CargoTrain extends Train implements Cargo {

    private final int cargoWeight;
    protected int packageCount;


    public CargoTrain(int initialWeight, int cargoWeight, int packageCount,
                      String trainNumber) {
        super(initialWeight, trainNumber);
        this.cargoWeight = cargoWeight;
        this.packageCount = packageCount;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public int getPackageCount(int packageCount)
            throws InvalidPackageException {
        for (Train tc : trainTypes) {
            if (tc instanceof CargoTrain)
                packageCount += ((CargoTrain) tc).getPackageCount(300);
        }
        if (packageCount < 0) {
            throw new InvalidPackageException(
                    "Train Package count is invalid..");
        }
        return packageCount;
    }

    public int getPackageCount() {
        return packageCount;
    }

    public void setPackageCount(int packageCount) {
        this.packageCount = packageCount;
    }

    @Override
    public void loadCargo() {
        System.out.println("Cargo is loading into the train");
    }

    @Override
    public void deliverCargo() {
        System.out.println("Cargo is delivering into the station");
    }

    @Override
    public void start() {
        System.out.println("Cargo train Started at station.");
    }

    @Override
    public void stop() {
        System.out.println("Cargo train reached station.");
    }

    @Override
    public int getTotalWeight() {
        return super.getTotalWeight() + cargoWeight;
    }

    @Override
    public String toString() {
        return getTrainNumber() + " is a " + getTrainCarType()
                + ", and it's initial weight " + getInitialWeight() + " kg."
                + " Cargo weighs " + getTotalWeight() + " kg" + "\nCargo has "
                + packageCount + " packages.";
    }
}

