package com.ahdy.xem.Configuration;

import com.ahdy.xem.dao.PersonDao;
import com.ahdy.xem.dao.PersonDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class MyConfiguration {

    @Bean
    public PersonDao personDao(){
        System.out.println("DI person dao...");
        return new PersonDaoImpl();
    }

}
