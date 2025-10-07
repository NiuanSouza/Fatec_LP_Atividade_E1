package com.example.programa.Classes.desafioSobFogo;

public class Knife {

    private final String material;
    private final String handle;
    private final String forgingMethod;

    public Knife(String material, String handle, String forgingMethod) {
        this.material = material.trim();
        this.handle = handle.trim();
        this.forgingMethod = forgingMethod.trim();
    }

    public String cut() {
        return "A faca de " + this.material + " está cortando com precisão!";
    }

    public String sharpen() {
        return "Afiando a lâmina de " + material + "... Faca pronta para o uso!";
    }

    public String displayInfo() {
        return "Faca:\n- Material da Lâmina: " + material +
                "\n- Cabo: " + handle +
                "\n- Método de Forja: " + forgingMethod;
    }

    public String getMaterial() { return material; }
    public String getHandle() { return handle; }
    public String getForgingMethod() { return forgingMethod; }

    @Override
    public String toString() {
        return displayInfo();
    }
}
