package com.devx.service.passon.devxpasson.configuration;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Iterator;

@Configuration
public class PassOnConfiguration {

    @Value("${passon.service.property.name}")
    private String PASSON_SERVICE_PROPERTY_FILE;

    @Bean
    public CompositeConfiguration getCompositeConfiguration() throws ConfigurationException {

        CompositeConfiguration compositeConfiguration = new CompositeConfiguration();
        compositeConfiguration.addConfiguration(new PropertiesConfiguration(PASSON_SERVICE_PROPERTY_FILE));
        return compositeConfiguration;
    }
}
