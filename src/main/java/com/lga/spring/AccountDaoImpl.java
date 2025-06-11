package com.lga.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class AccountDaoImpl implements AccountDao, InitializingBean, DisposableBean {

    @Override
    public String queryAccountName(String id) {
        return "lga";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("AccountDaoImpl init set after");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("AccountDaoImpl init set destroy");
    }
}
