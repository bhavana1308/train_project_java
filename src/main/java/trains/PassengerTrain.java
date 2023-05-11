package trains;

import exception.InvalidPassengerException;


public class PassengerTrain extends Train {

    private static final int PASSENGER_WEIGHT = 80;
    private int passengerCount;

    public PassengerTrain(int initialWeight, int passengerCount,
                          String trainNumber) {
        super(initialWeight, trainNumber);
        this.passengerCount = passengerCount;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public int getPassengerCount(int passengerCount)
            throws InvalidPassengerException {
        // int passengerCount = 0;
        for (Train tc : trainTypes) {
            if (tc instanceof PassengerTrain)
                passengerCount += ((PassengerTrain) tc)
                        .getPassengerCount(passengerCount);
        }
        if (passengerCount < 0) {
            throw new InvalidPassengerException(
                    "Passenger count cannot be Negative");
        }
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public void start() {
        System.out.println("Passenger train Started at Station.");
    }

    @Override
    public void stop() {
        System.out.println("Passenger train reached station.");
    }

    @Override
    public int getTotalWeight() {
        return super.getTotalWeight() + (passengerCount * PASSENGER_WEIGHT);
    }

    @Override
    public String toString() {
        return getTrainNumber() + " is a " + getTrainCarType()
                + ", and it's initial weight " + getInitialWeight()
                + ". It's final Weight is " + getTotalWeight()
                + ". It contains " + passengerCount + " passengers.";
    }

}
