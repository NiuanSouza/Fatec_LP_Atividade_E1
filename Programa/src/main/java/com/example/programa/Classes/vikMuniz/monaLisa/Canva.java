package com.example.programa.Classes.vikMuniz.monaLisa;

public class Canva {
    private String background;
    private double height;
    private double width;

    public Canva(String background, double height, double width) {
        this.background = background;
        this.height = height;
        this.width = width;
    }

    public String getInfo() {
        return "Canva com fundo de " + this.background + ", Dimensões: " + this.height + "cm x " + this.width + "cm";
    }

    public String getBackground() { return background; }
    public double getHeight() { return height; }
    public double getWidth() { return width; }
}