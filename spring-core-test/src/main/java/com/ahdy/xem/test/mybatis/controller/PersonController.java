package com.ahdy.xem.test.mybatis.controller;

import com.ahdy.xem.test.mybatis.bo.Person;
import com.ahdy.xem.test.mybatis.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("queryAll")
    public List<Person> queryAllPerson() {
        System.out.println("queryAllPerson ... ");
        return personService.queryAllPerson();
    }

}
