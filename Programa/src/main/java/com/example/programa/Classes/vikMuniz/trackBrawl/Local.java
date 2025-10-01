package com.example.programa.Classes.vikMuniz.trackBrawl;

public class Local {
    private int latitude;
    private int longitude;
    private int altitude;

    public Local(int latitude, int longitude, int altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public String getInfo() {
        return "Local definido nas coordenadas -> Lat: " + this.latitude + ", Long: " + this.longitude + ", Alt: " + this.altitude + "m";
    }

    public int getLatitude() { return latitude; }
    public int getLongitude() { return longitude; }
    public int getAltitude() { return altitude; }
}