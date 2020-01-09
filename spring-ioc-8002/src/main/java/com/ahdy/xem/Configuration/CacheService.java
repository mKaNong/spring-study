package com.ahdy.xem.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CacheService {

    private String name;

    public String getCache(String msg) {
        return "return cache : " + msg;
    }
}
