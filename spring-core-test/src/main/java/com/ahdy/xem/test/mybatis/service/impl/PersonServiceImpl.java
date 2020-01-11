package com.ahdy.xem.test.mybatis.service.impl;

import com.ahdy.xem.test.mybatis.bo.Person;
import com.ahdy.xem.test.mybatis.dao.PersonDao;
import com.ahdy.xem.test.mybatis.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao dao;

    @Override
    public List<Person> queryAllPerson() {
        return dao.queryAll();
    }
}
