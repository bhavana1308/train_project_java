package trains;

import java.util.Objects;

public class TicketDetails implements TicketPrint {

    private double passengerFare;
    private String fromStation;
    private String toStation;

    public TicketDetails(double tripFare, String fromStation, String toStation) {
        this.passengerFare = tripFare;
        this.fromStation = fromStation;
        this.toStation = toStation;
    }

    public double getPassengerFare() {
        return passengerFare;
    }

    public void setPassengerFare(double tripFare) {
        this.passengerFare = passengerFare;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }


    @Override
    public int hashCode() {
        return Objects.hash(passengerFare, fromStation, toStation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketDetails passenger = (TicketDetails) o;
        return Double.compare(passenger.passengerFare, passengerFare) == 0 &&
                Objects.equals(fromStation, passenger.fromStation) && Objects.equals(toStation, passenger.toStation);
    }

    @Override
    public void printTicket() {
        System.out.println(" Ticket Fare=" + passengerFare + ", From = "
                + fromStation + ", To = " + toStation);
    }
}

