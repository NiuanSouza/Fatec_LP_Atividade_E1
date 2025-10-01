package com.example.programa.Classes.MusicClass;

public class Valour {
    private String emotion;
    private String action;
    private String destination;
    private String valourReturn;

    public Valour(String emotion, String action, String destination) {
        this.emotion = emotion;
        this.action = action;
        this.destination = destination;
    }

    public String liftSouls() {
        valourReturn = ("In " + emotion + ", we " + action + " our souls to " + destination + ".");
        return valourReturn;
    }
}
