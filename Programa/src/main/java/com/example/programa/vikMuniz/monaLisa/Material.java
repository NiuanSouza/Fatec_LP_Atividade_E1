package com.example.programa.vikMuniz.monaLisa;

public class Material {
    private String name;
    private int amount;
    private String consistency;

    public Material(String name, int amount, String consistency) {
        this.name = name;
        this.amount = amount;
        this.consistency = consistency;
    }

    public String getInfo() {
        return "Material: " + this.name + ", Quantidade: " + this.amount + "g, Consistência: " + this.consistency;
    }

    public String getName() { return name; }
    public int getAmount() { return amount; }
    public String getConsistency() { return consistency; }
}