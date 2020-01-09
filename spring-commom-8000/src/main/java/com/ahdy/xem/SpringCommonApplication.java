package com.ahdy.xem;

import com.ahdy.xem.log.LogFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringCommonApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringCommonApplication.class);
        application.run(args);
    }
}
