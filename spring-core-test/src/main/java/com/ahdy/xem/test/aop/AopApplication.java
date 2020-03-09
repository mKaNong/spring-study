package com.ahdy.xem.test.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ahdy.xem.test.aop")
public class AopApplication {
    public static void main(String[] args) {
        new SpringApplication(AopApplication.class).run(args);
    }
}
