package com.ahdy.xem.transaction.dao;

import com.ahdy.xem.transaction.bo.Person;

import java.util.List;

public interface PersonDao {

    public List<Person> queryAll();

    public Person queryById(String id);

    public int update(Person person);
    
}
