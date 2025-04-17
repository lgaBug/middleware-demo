package com.lga.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition accountService = beanFactory.getBeanDefinition("accountServiceImpl");
        accountService.getPropertyValues().addPropertyValue("name", "wl");
        System.out.println("postProcessBeanFactory");
    }
}
