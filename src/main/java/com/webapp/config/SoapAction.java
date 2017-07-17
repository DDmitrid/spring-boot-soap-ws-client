package com.webapp.config;

public enum SoapAction {
    GET_GEO_LOCATIONS("http://buzzbuzhome.com/GetGeoLocations"),
    GET_LOCATIONS("http://buzzbuzhome.com/GetLocations"),
    GET_USER_LOCATION("http://buzzbuzhome.com/GetUserLocation");

    private String value;

    private SoapAction(String name) {
        this.value = name;
    }

    public String getValue() {
        return value;
    }
}
