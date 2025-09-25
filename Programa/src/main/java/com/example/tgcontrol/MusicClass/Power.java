package com.example.tgcontrol.MusicClass;

public class Power {
    private String strength;
    private String identity;
    private String symbol;
    private String symbolReturn;

    public Power(String strength, String identity, String symbol) {
        this.strength = strength;
        this.identity = identity;
        this.symbol = symbol;
    }

    public String declareLineage() {

        symbolReturn = ("In " + strength + ", " + identity + " of " + symbol + ".");
        return symbolReturn;
    }
}
