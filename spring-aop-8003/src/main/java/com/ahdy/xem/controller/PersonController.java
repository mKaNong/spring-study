package com.ahdy.xem.controller;

import com.ahdy.xem.annotation.WebLog;
import com.ahdy.xem.entity.Person;
import com.ahdy.xem.log.LogFactory;
import com.ahdy.xem.service.PersonService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("queryAll")
    @WebLog(name = "查询所有", intoDb = false)
    public List<Person> queryAllPerson(){
        return personService.queryAllPerson();
    }

    @RequestMapping("queryPersonById/{id}")
    @WebLog(name = "根据Id查询", intoDb = false)
    public Person queryPersonById(@PathVariable String id){
        return personService.queryPersonById(id);
    }

}
