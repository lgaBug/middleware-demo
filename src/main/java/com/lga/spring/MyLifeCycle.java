package com.lga.spring;

import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;


@Component
public class MyLifeCycle implements Lifecycle {

    @Override
    public void start() {
        System.out.println("my life cycle start");
    }

    @Override
    public void stop() {
        System.out.println("my life cycle stop");
    }

    @Override
    public boolean isRunning() {
        System.out.println("my life cycle isRunning");
        return true;
    }
}
