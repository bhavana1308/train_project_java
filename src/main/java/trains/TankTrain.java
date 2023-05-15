package trains;

public class TankTrain extends CargoTrain {

    protected int liquidCount;

    public TankTrain(int initialWeight, int cargoWeight, int packageCount, int liquidCount, String trainNumber) {
        super(initialWeight, cargoWeight, packageCount, trainNumber);
        this.liquidCount = liquidCount;
    }

    public int getLiquidCount() {
        return liquidCount;
    }

    public String toString() {
        return getTrainNumber()+" has liquid of " + liquidCount + "cc";

    }
}
