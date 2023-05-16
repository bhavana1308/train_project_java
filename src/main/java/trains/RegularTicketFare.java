package trains;


public class RegularTicketFare extends TicketFare {

    public RegularTicketFare() {
        super(10.0, 0.5);
    }

    @Override
    public double calculateFare(double distance) {
        return baseFare + additionalFare * distance;
    }

}

