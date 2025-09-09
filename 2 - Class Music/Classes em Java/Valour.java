package MusicClass;

public class Valour {
    private String emotion;
    private String action;
    private String destination;

    public Valour(String emotion, String action, String destination) {
        this.emotion = emotion;
        this.action = action;
        this.destination = destination;
    }

    public void liftSouls() {
        System.out.println("In " + emotion + ", we " + action + " our souls to " + destination + ".");
    }
}
