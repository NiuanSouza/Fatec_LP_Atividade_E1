package monaLisa;

public class Canva {
    public String background;
    public double height;
    public double width;

    public String getCanva(String background, double height, double width) {
        this.background = background;
        this.height = height;
        this.width = width;
        return "Canva com fundo de " + this.background + ", Dimensões: " + this.height + "cm x " + this.width + "cm";
    }
}