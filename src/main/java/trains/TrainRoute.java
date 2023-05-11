package trains;

public class TrainRoute implements Route {

    protected int routeNumber;
    protected String startLocation;
    protected String endLocation;
    protected int duration;
    protected int numOfStops;

    public TrainRoute(int routeNumber, String startLocation, String endLocation, int duration, int numOfStops) {
        this.routeNumber = routeNumber;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.duration = duration;
        this.numOfStops = numOfStops;
    }

    @Override
    public String getStartLocation() {
        return startLocation;
    }

    @Override
    public String getEndLocation() {
        return endLocation;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    public String toString() {
        return "Number of stops=" + numOfStops +
                "\nRoute Number is =" + routeNumber;
    }
}
