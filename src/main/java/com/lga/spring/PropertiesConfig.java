package com.lga.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class PropertiesConfig {

    @Autowired
    private Environment env;


    public String getUsername() {
        return env.getProperty("db.username");
    }

}
