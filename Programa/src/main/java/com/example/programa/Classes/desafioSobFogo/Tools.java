package com.example.programa.Classes.desafioSobFogo;

public class Tools {

    private final String name;
    private final String function;
    private double durability;
    private static final double WEAR_AMOUNT = 5.5;

    public Tools(String name, String function, double durability) {
        this.name = name.trim();
        this.function = function.trim();
        this.durability = durability;
    }

    public String use() {
        if (durability > 0) {
            decreaseDurability(WEAR_AMOUNT);
            return "Usando a ferramenta: " + name + ". Durabilidade atual: " + String.format("%.1f", durability) + "%.";
        } else {
            return "A ferramenta " + name + " quebrou e não pode mais ser usada.";
        }
    }

    public void decreaseDurability(double amount) {
        durability -= amount;
        if (durability < 0) {
            durability = 0;
        }
    }

    public void restoreDurability() {
        durability = 100.0;
    }

    public String getName() { return name; }
    public double getDurability() { return durability; }
    public String getFunction() { return function; }

    @Override
    public String toString() {
        return "Ferramenta: " + name + " | Função: " + function + " | Durabilidade: " + String.format("%.1f", durability) + "%";
    }
}
