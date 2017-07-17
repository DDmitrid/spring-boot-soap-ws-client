package com.webapp.services;

import com.webapp.config.ConnectionProperties;
import com.webapp.config.SoapAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;
import com.webapp.services.GetUserLocationResponse;
import com.webapp.services.GetUserLocation;

@Service
public class IPClientService extends WebServiceGatewaySupport {

    @Autowired
    public IPClientService(Jaxb2Marshaller jaxb2Marshaller, ConnectionProperties connectionProperties) {
        this.setMarshaller(jaxb2Marshaller);
        this.setUnmarshaller(jaxb2Marshaller);
        this.setDefaultUri(connectionProperties.getEndPointUrl());
    }

    public GetUserLocationResponse getUserLocationByIp(String ipAddress) {
        GetUserLocation userLocationRequest = new GetUserLocation();
        userLocationRequest.setIpAddress(ipAddress);
        return (GetUserLocationResponse) getWebServiceTemplate().marshalSendAndReceive(userLocationRequest,
                new WebServiceMessageCallback() {
                    public void doWithMessage(WebServiceMessage message)
                    {
                        // this header is added for compatibility with SOAP v1.1
                        ((SoapMessage)message).setSoapAction(SoapAction.GET_USER_LOCATION.getValue());
                    }
                });
    }

    public String getUserCountryNameByIp(String ipAddress) {
        return getUserLocationByIp(ipAddress)
                .getGetUserLocationResult()
                .getCountryName();
    }
}
