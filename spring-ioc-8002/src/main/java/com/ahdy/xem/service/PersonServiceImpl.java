package com.ahdy.xem.service;

import com.ahdy.xem.Configuration.CacheService;
import com.ahdy.xem.dao.PersonDao;
import com.ahdy.xem.dao.PersonDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service("personService")
public class PersonServiceImpl implements PersonService {
    //@Autowired
    private PersonDao personDao;
    // 构造器注入
    public PersonServiceImpl(PersonDao personDao){
        this.personDao = personDao;
    }

    public PersonServiceImpl(){}
    // setter注入
    public void setPersonDao(PersonDao personDao){
        this.personDao = personDao;
    }



    @Override
    public String queryAll() {
        return personDao.queryAll();
    }

    public String query(){
        return "PersonServiceImpl query";
    }
}
