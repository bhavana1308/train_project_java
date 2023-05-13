package trains;


import enums.*;
import exception.*;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import utils.CommonUtility;
import utils.FileReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Executor {

    public static final String INPUT_FILE = "src/main/resources/input.txt";
    public static final File OUTPUT_FILE = new File("src/main/resources/output.txt");
    final static List<String> TRAIN_STATIONS = Arrays.asList("New York", "Boston",
            "Texas", "Nevada", "Houston");
    final static String DASH_LINE = ("______________________________________");
    private static final Logger logger = LogManager.getLogger(Executor.class);

    public static void main(String[] args) throws IOException, InvalidPassengerException {

        int uniqueWordsCount = FileReader.getUniqueWordCountInFile(INPUT_FILE);
        FileUtils.writeStringToFile(OUTPUT_FILE, Integer.toString(uniqueWordsCount));

        TrainStatus arrival = TrainStatus.ARRIVED;
        TrainStatus departure = TrainStatus.DEPARTED;
        logger.info("=================="+Trains.PASSENGER_TRAIN.getDisplayName()+"=================");

        PassengerTrain passengerTrain1 = new PassengerTrain(1000, 75, "PA1234");
        logger.info(passengerTrain1);
        try {
            passengerTrain1.getPassengerCount(75);
        } catch (InvalidPassengerException e) {
            logger.error("Invalid Passenger count", e);
        }
        passengerTrain1.start();
        passengerTrain1.stop();

        PassengerTrain passengerTrain2 = new PassengerTrain(1200, 100,
                "PA5678");
        logger.info(passengerTrain2);
        try {
            passengerTrain2.getPassengerCount(100);
        } catch (InvalidPassengerException e) {
            logger.error("Invalid Passenger count", e);
        }
        passengerTrain2.start();
        passengerTrain2.stop();

        List<Train> passengerTrains = new ArrayList<>();
        passengerTrains.add(passengerTrain1);
        passengerTrains.add(passengerTrain2);

        ICustomFunctional<Train> pr = passengerTrain -> (passengerTrain.getInitialWeight() > 200 && passengerTrain.getTotalWeight() > 1000);
        for (Train passengerTrain : passengerTrains) {
            if (pr.test(passengerTrain)) {
                logger.info(passengerTrain.getTrainNumber() + " has required weight.");
            }
        }
        int totalNumberOfPassengers = passengerTrains.stream()
                .filter(train -> train instanceof PassengerTrain)
                .mapToInt(train -> ((PassengerTrain) train).getPassengerCount())
                .sum();
        logger.info("Total Number of Passengers are "+totalNumberOfPassengers+" from  "+passengerTrains.size() +" Passenger Trains.");
        logger.info("\n" + DASH_LINE);

        logger.info("=================="+Trains.CARGO.getDisplayName()+"==================");
        CargoTrain cargoTrain1 = new CargoTrain(1000, 1000, 300, "Ca1234");
        logger.info(cargoTrain1);
        cargoTrain1.start();
        cargoTrain1.loadCargo();
        cargoTrain1.stop();
        cargoTrain1.deliverCargo();
        try {
            cargoTrain1.getPackageCount(300);
        } catch (InvalidPackageException e) {
            logger.error("Invalid Package count", e);
        }

        CargoTrain cargoTrain2 = new CargoTrain(1000, 5000, 800, "Ca5678");
        logger.info(cargoTrain2);
        cargoTrain2.start();
        cargoTrain2.loadCargo();
        cargoTrain2.stop();
        cargoTrain2.deliverCargo();
        List<Train> cargoTrains = new ArrayList<>();
        cargoTrains.add(cargoTrain1);
        cargoTrains.add(cargoTrain2);

        ICustomFunctional<Train> cr = cargoTrain -> (cargoTrain.getInitialWeight() > 200 && cargoTrain.getTotalWeight() > 1000);
        for (Train cargoTrain : cargoTrains) {
            if (cr.test(cargoTrain)) {
                logger.info(cargoTrain.getTrainNumber() + " has required weight.");
            }
        }
        int totalCargoWeights = cargoTrains.stream().filter(train -> train instanceof CargoTrain)
                .mapToInt(train -> ((CargoTrain) train).getCargoWeight()).sum();
        logger.info("Total Cargo Weight is " + totalCargoWeights + " from " + cargoTrains.size() + " Cargo Trains");
        logger.info("\n" + DASH_LINE);

        logger.info("=================="+Trains.TANK_TRAIN.getDisplayName()+"==================");
        logger.info(arrival);
        TankTrain liquid1 = new TankTrain(2000, 5000, 300, 7000, "Tank1234");
        logger.info(liquid1);
        Liquid liquidType1 = Liquid.PETROLEUM;
        logger.info(liquidType1);

        TankTrain liquid2 = new TankTrain(3000, 5000, 300, 9000, "Tank9234");
        logger.info(liquid2);
        Liquid liquidType2 = Liquid.CHEMICAL;
        logger.info(liquidType2);
        List<Train> tankTrainList = new ArrayList<>();
        tankTrainList.add(liquid1);
        tankTrainList.add(liquid2);

        ICustomFunctional<TankTrain> tc = TankTrain -> (TankTrain.getLiquidCount() > 8000);
        for (Train tankTrain : tankTrainList) {
            if (tc.test((TankTrain) tankTrain)) {
                logger.info(tankTrain.getTrainNumber() + " has required weight liquid.");
            }
        }
        int totalLiquidUsed = tankTrainList.stream()
                .filter(train -> train instanceof TankTrain)
                .mapToInt(train -> ((TankTrain) train).getLiquidCount()).sum();
        logger.info("Total liquid in tank train is " + totalLiquidUsed + " cc.");

        CustomLinkedList<String> tankTrainStops = new CustomLinkedList<>();
        tankTrainStops.add("St.louis");
        tankTrainStops.add("Maryland");
        tankTrainStops.add("Alaska");
        logger.info("Tank Train stops are : ");
        tankTrainStops.print();
        logger.info("\n" + DASH_LINE);
        
        logger.info("=================="+Trains.HIGH_SPEED.getDisplayName()+"==================");
        logger.info(arrival);
        HighSpeedTrain hstrain = new HighSpeedTrain(300, 1000, 150, "Hs456");
        logger.info(hstrain);
        try {
            hstrain.getMaxSpeed(700);
        } catch (OverSpeedException e) {
            logger.error("High speed Train is overspeeding", e);
        }

        TrainRoute route = new TrainRoute(1234, "Chicago", "NewYork", 15, 5);
        CustomLinkedList<String> highSpeedTrainStops = new CustomLinkedList<>();
        highSpeedTrainStops.add("Dallas");
        highSpeedTrainStops.add("Miami");
        highSpeedTrainStops.add("Tampa");
        logger.info(route);
        logger.info("Train Start Location :" + route.getStartLocation());
        logger.info("Train end Location :" + route.getEndLocation());
        logger.info("Train Duration : " + route.getDuration() + "mins");
        logger.info("High speed Train stops are : ");
        highSpeedTrainStops.print();
        logger.info("\n" + DASH_LINE);

        logger.info("=================="+Trains.LOW_SPEED.getDisplayName()+"==================");
        logger.info(departure);
        LowSpeedTrain lstrain = new LowSpeedTrain(1000, 75, "LS123", 150);
        logger.info(lstrain);
        try {
            lstrain.getMaxSpeed(200);
        } catch (OverSpeedException e) {
            logger.error("Low Speed Train is overspeeding", e);
        }
        logger.info("\n" + DASH_LINE);


        TicketClass firstClass = TicketClass.FIRST_CLASS;
        logger.info(firstClass);

        TicketClass regular = TicketClass.REGULAR;
        logger.info(regular);

        FirstClassTicket ticket = new FirstClassTicket(40);
        logger.info("First Class Passengers: " + ticket.getPassengerCount());
        logger.info("\n" + DASH_LINE);

        logger.info(Currency.DOLLARS.getDisplayName());
        try {
            TicketFare fare = new RegularTicketFare();
            TicketDetails trip1 = new TicketDetails(
                    fare.calculateFare(CommonUtility.calculateDistance(
                            TRAIN_STATIONS.get(0), TRAIN_STATIONS.get(1))),
                    TRAIN_STATIONS.get(0), TRAIN_STATIONS.get(1));
            TicketDetails trip2 = new TicketDetails(
                    fare.calculateFare(CommonUtility.calculateDistance(
                            TRAIN_STATIONS.get(0), TRAIN_STATIONS.get(2))),
                    TRAIN_STATIONS.get(0), TRAIN_STATIONS.get(2));
            logger.info("Passenger trip fare " + trip1.getPassengerFare());
            trip1.printTicket();
            trip2.printTicket();

            List<TicketPrint> totalTickets = new ArrayList<>();
            totalTickets.add(trip1);
            totalTickets.add(trip2);

            double totalPassengerFare = totalTickets.stream()
                    .filter(train -> train instanceof TicketPrint)
                    .mapToDouble(train -> ((TicketDetails) train).getPassengerFare()).sum();
            logger.info("Total Passenger Fare " + totalPassengerFare + " from " + totalTickets.size() + " Trips.");

        } catch (DistanceCalculationException | InvalidStationException e) {
            e.printStackTrace();
            logger.debug("Distance calculation exception", e);

        }
        logger.info("\n" + DASH_LINE);

    }

}
