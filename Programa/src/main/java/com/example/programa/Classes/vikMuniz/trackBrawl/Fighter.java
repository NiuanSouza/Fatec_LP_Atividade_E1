package com.example.programa.Classes.vikMuniz.trackBrawl;

public class Fighter {
    private String fighterName;
    private int age;
    private double weight;

    public Fighter(String fighterName, int age, double weight) {
        this.fighterName = fighterName;
        this.age = age;
        this.weight = weight;
    }

    public String apresetention() {
        return ("Lutador: Nome " + this.fighterName + ", Idade: " + this.age + " anos, Peso: " + this.weight + "kg.");
    }

    public String getFighterName() { return fighterName; }
    public int getAge() { return age; }
    public double getWeight() { return weight; }
}