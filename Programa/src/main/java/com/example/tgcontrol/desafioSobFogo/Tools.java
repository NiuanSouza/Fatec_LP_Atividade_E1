package com.example.tgcontrol.desafioSobFogo;

public class Tools {

    private String name;
    private String function;
    private double durability;

    public Tools(String name, String function, double durability) {
        this.name = name;
        this.function = function;
        this.durability = durability;
    }

    public String use() {
        if (durability > 0) {
            this.durability -= 5.5;
            if (this.durability < 0) {
                this.durability = 0;
            }
            return "Usando a ferramenta: " + name + ". Durabilidade atual: " + String.format("%.1f", durability) + "%.";
        } else {
            return "A ferramenta " + name + " quebrou e não pode mais ser usada.";
        }
    }

    public void restoreDurability() {
        this.durability = 100.0;
    }

    public String getName() { return name; }
    public double getDurability() { return durability; }
    public String getFunction() { return function; }
}