package com.ahdy.xem.transaction.service;

import com.ahdy.xem.transaction.bo.Person;

import java.util.List;

public interface PersonService {
    public List<Person> queryAll();

    public Person queryById(String id);

    public int update(Person person);
}
