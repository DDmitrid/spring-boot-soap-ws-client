package com.webapp.config;

import com.webapp.services.IPClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.webapp.services");
        return marshaller;
    }

    @Bean
    public IPClientService ipClient(Jaxb2Marshaller marshaller) {
        IPClientService client = new IPClientService();
        client.setDefaultUri(IPServiceInfo.END_POINT_ADDRESS.getValue());
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
