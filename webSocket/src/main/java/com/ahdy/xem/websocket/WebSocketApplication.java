package com.ahdy.xem.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebSocketApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WebSocketApplication.class);
        application.run(args);
    }
}
