package com.example.tgcontrol.desafioSobFogo;

public class Blacksmith {

    private String name;
    private int age;
    private String country;

    public Blacksmith(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String introduce() {
        return "Olá! O ferreiro " + name + " (" + age + " anos) de " + country + " está pronto para forjar.";
    }

    public String forge(String itemName) {
        return name + " está forjando um(a) " + itemName + " na bigorna com o calor da fornalha.";
    }

    public String repair(String toolName) {
        return name + " está consertando o(a) " + toolName + ". Parece novo em folha!";
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCountry() { return country; }
}