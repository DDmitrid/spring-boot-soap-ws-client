package com.webapp.config;

public class ConnectionProperties {
    private String endPointUrl;

    public ConnectionProperties(String endPointUrl) {
        this.endPointUrl = endPointUrl;
    }

    public String getEndPointUrl() {
        return endPointUrl;
    }
}
