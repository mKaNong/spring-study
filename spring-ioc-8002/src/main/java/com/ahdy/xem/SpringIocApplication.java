package com.ahdy.xem;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SpringBootApplication
public class SpringIocApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringIocApplication.class);
        application.run(args);
    }

    /*@PostConstruct
    public void refresh(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("refresh ...");
    }*/

}
