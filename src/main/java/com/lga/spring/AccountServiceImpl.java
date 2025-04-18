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
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService, InitializingBean, DisposableBean {

    @Getter
    @Setter
    private String name;

    @Autowired
    private AccountDao accountDao;


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
    }
}
