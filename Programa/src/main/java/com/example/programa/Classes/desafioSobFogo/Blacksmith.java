package com.example.programa.Classes.desafioSobFogo;

public class Blacksmith {

    private final String name;
    private final int age;
    private final String country;

    public Blacksmith(String name, int age, String country) {

        this.name = name.trim();
        this.age = age;
        this.country = country.trim();
    }

    public String introduce() {
        return "Olá! O ferreiro " + name + " (" + age + " anos) de " + country + " está pronto para forjar.";
    }

    public String forge(String itemName) {
        return name + " está forjando na bigorna com o calor da fornalha.";
    }

    public String repair(String toolName) {
        return name + " está consertando o(a) " + toolName + ". Parece novo em folha!";
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCountry() { return country; }

    @Override
    public String toString() {
        return "Ferreiro: " + name + " (" + age + " anos), País: " + country;
    }
}
