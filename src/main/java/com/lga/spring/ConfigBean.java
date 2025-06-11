package com.lga.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean {




    @Bean
    public AccountService accountService() {
        return new AccountServiceImpl();
    }
}
