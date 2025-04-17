package com.lga.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMain {


    public static void main(String[] args) {


        // 1. 创建基于注解的Spring IoC容器
        ApplicationContext context = new AnnotationConfigApplicationContext("com.lga.spring");

        // 2. 从容器中获取bean
        AccountService accountService = context.getBean(AccountService.class);

        // 3. 调用bean的方法
        System.out.println(accountService.queryAccountName("1"));


        PropertiesConfig propertiesConfig = context.getBean(PropertiesConfig.class);
        System.out.println(propertiesConfig.getUsername());

    }
}
