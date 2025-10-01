package com.example.programa.desafioSobFogo;

public class Knife {

    private String material;
    private String handle;
    private String forgingMethod;

    public Knife(String material, String handle, String forgingMethod) {
        this.material = material;
        this.handle = handle;
        this.forgingMethod = forgingMethod;
    }

    public String cut() {
        return "A faca de " + material + " e cabo de " + handle + " está cortando com precisão!";
    }

    public String sharpen() {
        return "Afiando a lâmina... Faca pronta para o uso!";
    }

    public String displayInfo() {
        return "Faca: Material da Lâmina: " + material + ", Cabo: " + handle + ", Método de Forja: " + forgingMethod + ".";
    }
}