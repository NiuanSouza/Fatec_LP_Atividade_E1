package MusicClass;

public class Honour {
    private String virtue;
    private String expression;
    private String message;

    public Honour(String virtue, String expression, String message) {
        this.virtue = virtue;
        this.expression = expression;
        this.message = message;
    }

    public void singPraise() {
        System.out.println("In " + virtue + ", we " + expression + " " + message + ".");
    }
}

