package com.ahdy.xem.service.impl;

import com.ahdy.xem.dao.PersonDao;
import com.ahdy.xem.entity.Person;
import com.ahdy.xem.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public List<Person> queryAllPerson() {
        return personDao.queryAll();
    }

    @Override
    public Person queryPersonById(String id) {
        Assert.notNull(id, "person's id must not be null!");
        return personDao.queryPersonById(id);
    }
}
