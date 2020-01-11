package com.ahdy.xem.test.log;

import com.ahdy.xem.log.LogFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ahdy.xem.test.log"})
public class Application {

    private static Logger log = LogFactory.getBusLogger();

    public static void main(String[] args) {
        log.debug("bus log....123");
        SpringApplication application = new SpringApplication(Application.class);
        application.run(args);
        log.debug("spring boot start success!");
    }
}
