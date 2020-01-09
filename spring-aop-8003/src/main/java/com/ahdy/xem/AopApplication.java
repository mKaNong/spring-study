package com.ahdy.xem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AopApplication.class);
        application.run(args);
    }

}
