package com.ahdy.xem.Configuration;

import com.ahdy.xem.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //PersonService bean = (PersonService)context.getBean("personService1");
        PersonService bean = (PersonService)context.getBean("personService2");
        System.out.println(bean.queryAll());
    }
}
