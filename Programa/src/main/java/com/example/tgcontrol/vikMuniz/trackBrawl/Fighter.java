package com.example.tgcontrol.vikMuniz.trackBrawl;

public class Fighter {
    public String fighterName;
    public int age;
    public double weight;

    public String apresetention()
    {
        String apresentation =  ("Lutador: Nome " + this.fighterName + ", Idade: " + this.age + " anos, Peso: " + this.weight + "kg.");
        return apresentation;
    }
}