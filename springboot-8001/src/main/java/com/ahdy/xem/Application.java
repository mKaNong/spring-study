package com.ahdy.xem;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

@SpringBootApplication
public class Application {

    // ------------------------------------------
    //  start SpringBoot
    // ------------------------------------------
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        // 使用application，用户可以自定义
        application.run(args);
    }
}
