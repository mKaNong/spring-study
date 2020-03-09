package com.xem.ahdy.mybatis.mybatis.service.impl;

import com.xem.ahdy.mybatis.mybatis.bo.Person;
import com.xem.ahdy.mybatis.mybatis.dao.PersonDao;
import com.xem.ahdy.mybatis.mybatis.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public List<Person> queryAllPerson() {
        return personDao.queryAll();
    }
}
