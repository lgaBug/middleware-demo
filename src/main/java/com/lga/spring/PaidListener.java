package com.lga.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class PaidListener implements ApplicationListener<PaidEvent> {

    @Override
    public void onApplicationEvent(PaidEvent event) {
        System.out.println("listener event = " + event);
    }
}
