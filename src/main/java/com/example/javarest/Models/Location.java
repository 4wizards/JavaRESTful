package com.example.javarest.Models;

public class Location {
    String longitude;
    String latitude;
    String locationName;

    public Location(String longitude, String latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.locationName = locationName;
    }


    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}