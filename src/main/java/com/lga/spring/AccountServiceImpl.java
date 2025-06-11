package com.lga.spring;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService, InitializingBean, DisposableBean {

    @Getter
    @Setter
    private String name;

    @Autowired
    private AccountDao accountDao;


    @Autowired
    private ApplicationEventPublisher publisher;




    public AccountServiceImpl() {
        System.out.println("AccountServiceImpl init");
    }


    @Override
    public String queryAccountName(String id) {
        return "lga";
    }



    @Override
    public void destroy() throws Exception {
        System.out.println("name = " + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");

        PaidEvent paidEvent = new PaidEvent(this);
        paidEvent.setUserId("lga");
        paidEvent.setOrderId("123");
        publisher.publishEvent(paidEvent);
        System.out.println("paidEvent = " + paidEvent);




    }
}
