package trains;

import exception.OverSpeedException;


public class HighSpeedTrain extends PassengerTrain implements SpeedLimit {

    protected double maxSpeed;

    public HighSpeedTrain(double maxSpeed, int initialWeight, int passengerCount, String trainNumber) {
        super(initialWeight, passengerCount, trainNumber);
        this.maxSpeed = maxSpeed;
    }

    public double getMaxSpeed(double maxSpeed) throws OverSpeedException {
        if (maxSpeed > 300) {
            throw new OverSpeedException("High speed Train is Overspeeding..");
        }
        return maxSpeed;
    }

    @Override
    public String toString() {
        return "High Speed Train maximum speed is " + maxSpeed+ "kmph\n";
    }


}
