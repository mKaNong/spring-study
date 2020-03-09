package com.ahdy.xem.transaction.service.impl;

import com.ahdy.xem.transaction.bo.Person;
import com.ahdy.xem.transaction.dao.PersonDao;
import com.ahdy.xem.transaction.service.PersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonDao personDao;

    @Override
    public List<Person> queryAll() {
        return personDao.queryAll();
    }

    @Override
    public Person queryById(String id) {
        return personDao.queryById(id);
    }

    @Override
    public int update(Person person) {
        return personDao.update(person);
    }
}
