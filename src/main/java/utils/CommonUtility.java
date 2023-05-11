package utils;

import exception.DistanceCalculationException;
import exception.InvalidStationException;

import java.util.List;

public class CommonUtility {

    private static final List<String> TRAIN_STATIONS = List.of("New York",
            "Boston", "Texas", "Nevada", "Houston");

    public static double calculateDistance(String departureStation,
                                           String arrivalStation) throws DistanceCalculationException, InvalidStationException {
        return Math.abs(getStationIndex(departureStation)
                - getStationIndex(arrivalStation));
    }

    private static int getStationIndex(String station) throws InvalidStationException {
        if (!TRAIN_STATIONS.contains(station)) {
            throw new InvalidStationException("Invalid Station : " + station);
        }
        return TRAIN_STATIONS.indexOf(station);
    }
}
