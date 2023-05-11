package trains;


import exception.OverSpeedException;

public interface SpeedLimit {

    double getMaxSpeed(double maxSpeed) throws OverSpeedException;
}
