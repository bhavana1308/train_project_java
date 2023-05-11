package enums;

public enum Trains {

    PASSENGER_TRAIN("Passenger Train"), CARGO("Cargo Train"), HIGH_SPEED(
                "High-Speed Train"), LOW_SPEED("Low speed Train"), TANK_TRAIN("Tank Train");

        private final String displayName;

        Trains(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
}
