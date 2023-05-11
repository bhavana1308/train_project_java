package trains;

public abstract class TicketFare {

    protected double baseFare;
    protected double additionalFare;

    public TicketFare(double baseFare, double additionalFare) {
        this.baseFare = baseFare;
        this.additionalFare = additionalFare;
    }

    public abstract double calculateFare(double distance);

}
