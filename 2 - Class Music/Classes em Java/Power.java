package MusicClass;

public class Power {
    private String strength;
    private String identity;
    private String symbol;

    public Power(String strength, String identity, String symbol) {
        this.strength = strength;
        this.identity = identity;
        this.symbol = symbol;
    }

    public void declareLineage() {
        System.out.println("In " + strength + ", " + identity + " of " + symbol + ".");
    }
}
