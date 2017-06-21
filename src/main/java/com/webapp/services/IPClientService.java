package com.webapp.services;

import com.webapp.config.IPServiceInfo;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;
import com.webapp.services.GetUserLocationResponse;
import com.webapp.services.GetUserLocation;

public class IPClientService extends WebServiceGatewaySupport {
    public GetUserLocationResponse getUserLocationByIp(String ipAddress) {
        GetUserLocation userLocationRequest = new GetUserLocation();
        userLocationRequest.setIpAddress(ipAddress);
        return (GetUserLocationResponse) getWebServiceTemplate().marshalSendAndReceive(userLocationRequest,
                new WebServiceMessageCallback() {
                    public void doWithMessage(WebServiceMessage message)
                    {
                        // this header is added for compatibility with SOAP v1.1
                        ((SoapMessage)message).setSoapAction(IPServiceInfo.GET_USER_LOCATION_HEADER.getValue());
                    }
                });
    }

    public String getUserCountryNameByIp(String ipAddress) {
        return getUserLocationByIp(ipAddress)
                .getGetUserLocationResult()
                .getCountryName();
    }
}
