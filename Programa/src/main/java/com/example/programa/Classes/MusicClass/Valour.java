package com.example.programa.Classes.MusicClass;

public class Valour {
    private int id;
    private String emotion;
    private String action;
    private String destination;
    private String valourReturn;

    public Valour(String emotion, String action, String destination) {
        this.emotion = emotion;
        this.action = action;
        this.destination = destination;
    }

    public Valour(int id, String emotion, String action, String destination) {
        this.id = id;
        this.emotion = emotion;
        this.action = action;
        this.destination = destination;
    }

    public String liftSouls() {
        valourReturn = ("In " + emotion + ", we " + action + " our souls to " + destination + ".");
        return valourReturn;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEmotion() { return emotion; }
    public String getAction() { return action; }
    public String getDestination() { return destination; }

    public void setEmotion(String emotion) { this.emotion = emotion; }
    public void setAction(String action) { this.action = action; }
    public void setDestination(String destination) { this.destination = destination; }
}