package com.ahdy.xem.transaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.ahdy.xem.*.dao"})
public class TransactionApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(TransactionApplication.class);
        application.run(args);
    }
}
