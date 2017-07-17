package com.webapp.config;

import com.webapp.services.IPClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {
    @Value("${ws.endpoint_url}")
    private String endPointUrl;

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.webapp.services");
        return marshaller;
    }

    @Bean
    public ConnectionProperties connectionProperties() {
        return new ConnectionProperties(endPointUrl);
    }
}
