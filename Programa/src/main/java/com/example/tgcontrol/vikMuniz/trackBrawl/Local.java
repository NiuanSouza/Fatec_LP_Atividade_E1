package com.example.tgcontrol.vikMuniz.trackBrawl;

public class Local {
    public int latitude;
    public int longitude;
    public int altitude;

    public String calculateLocal(int x, int y, int z) {
        this.latitude = x;
        this.longitude = y;
        this.altitude = z;
        return "Local definido nas coordenadas -> Lat: " + this.latitude + ", Long: " + this.longitude + ", Alt: " + this.altitude + "m";
    }
}