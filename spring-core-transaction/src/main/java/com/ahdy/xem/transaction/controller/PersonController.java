package com.ahdy.xem.transaction.controller;

import com.ahdy.xem.common.api.R;
import com.ahdy.xem.transaction.aspect.ApiLog;
import com.ahdy.xem.transaction.bo.Person;
import com.ahdy.xem.transaction.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("transaction")
public class PersonController {

    @Resource
    private PersonService personService;


    @RequestMapping("queryAllPerson")
    @ResponseBody
    @ApiLog(name = "queryAllPerson")
    public R queryAllPerson() {
        return R.data(personService.queryAll());
    }


    @RequestMapping("queryById/{id}")
    @ResponseBody
    @ApiLog(name = "queryById")
    public R queryById(@PathVariable String id) {
        return R.data(personService.queryById(id));
    }


    @RequestMapping("update")
    @ResponseBody
    @ApiLog(name = "update")
    public R update() {
        Person person = new Person();
        person.setId("123");
        person.setName("xem");
        person.setPhone("123456789");
        int update = personService.update(person);
        if(update == 1){
            return R.status(true);
        }
        return R.status(false);
    }

}
