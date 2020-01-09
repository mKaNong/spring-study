package com.ahdy.xem.controller;

import com.ahdy.xem.service.PersonService;
import com.ahdy.xem.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("spring")
public class PersonController {
    //private PersonService personService = new PersonServiceImpl();

    @Autowired
    private PersonService personService;

    @RequestMapping("ioc")
    public String query() {
        return personService.queryAll();
    }

}
