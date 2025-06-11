package com.lga.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private AbstractApplicationContext applicationContext;

    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public String notifyEvent(){
        applicationContext.start();
        return "ok";
    };
}
