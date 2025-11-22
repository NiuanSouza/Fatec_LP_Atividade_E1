package com.example.programa.Classes.MusicClass;

public class Power {
    private int id;
    private String strength;
    private String identity;
    private String symbol;
    private String symbolReturn;

    public Power(String strength, String identity, String symbol) {
        this.strength = strength;
        this.identity = identity;
        this.symbol = symbol;
    }

    public Power(int id, String strength, String identity, String symbol) {
        this.id = id;
        this.strength = strength;
        this.identity = identity;
        this.symbol = symbol;
    }

    public String declareLineage() {
        symbolReturn = ("In " + strength + ", " + identity + " of " + symbol + ".");
        return symbolReturn;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getStrength() { return strength; }
    public String getIdentity() { return identity; }
    public String getSymbol() { return symbol; }

    public void setStrength(String strength) { this.strength = strength; }
    public void setIdentity(String identity) { this.identity = identity; }
    public void setSymbol(String symbol) { this.symbol = symbol; }
}