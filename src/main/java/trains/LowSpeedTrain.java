package trains;

import exception.OverSpeedException;

public class LowSpeedTrain extends PassengerTrain implements SpeedLimit {

    protected double maxSpeed;

    public LowSpeedTrain(int initialWeight, int passengerCount, String trainNumber, double maxSpeed) {
        super(initialWeight, passengerCount, trainNumber);
        this.maxSpeed = maxSpeed;
    }

    public double getMaxSpeed(double maxSpeed) throws OverSpeedException {
        if (maxSpeed > 150) {
            throw new OverSpeedException("Low speed Train is Overspeeding..");
        }
        return maxSpeed;
    }

    @Override
    public String toString() {
        return "Low Speed Train maximum speed is " + maxSpeed + "kmph\n";

    }


}
