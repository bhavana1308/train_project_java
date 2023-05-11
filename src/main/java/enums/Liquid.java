package enums;

public enum Liquid {

    CHEMICAL("Chemical liquid"),
    PETROLEUM(" Petroleum liquid");

    private final String liquidType;

    Liquid(String liquidType) {
        this.liquidType = liquidType;
    }

    public String getLiquidType() {
        return liquidType;
    }

    @Override
    public String toString() {
        return  "Tank train has "+ getLiquidType();

    }

}
