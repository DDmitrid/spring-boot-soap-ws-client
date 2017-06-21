package com.webapp.config;

public enum IPServiceInfo {
    END_POINT_ADDRESS("http://www.buzzbuzzhome.com/GeoLocation/GeoLocation.asmx"),
    GET_USER_LOCATION_HEADER("http://buzzbuzhome.com/GetUserLocation");

    private String value;

    IPServiceInfo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

}
