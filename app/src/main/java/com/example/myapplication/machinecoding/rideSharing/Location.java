package com.example.myapplication.machinecoding.rideSharing;

public class Location {
    private double latitude;
    private double longitude;

    public Location(double pLatitude, double pLongitude) {
        this.latitude = pLatitude;
        this.longitude = pLongitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}



