package monaLisa;

public class Material {
    public String name;
    public int amount;
    public String consistency;

    public String getMaterial(String name, int amount, String consistency) {
        this.name = name;
        this.amount = amount;
        this.consistency = consistency;
        return "Material: " + this.name + ", Quantidade: " + this.amount + "g, Consistência: " + this.consistency;
    }
}