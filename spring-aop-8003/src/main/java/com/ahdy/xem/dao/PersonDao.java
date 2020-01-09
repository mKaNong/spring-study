package com.ahdy.xem.dao;

import com.ahdy.xem.entity.Person;

import java.util.List;

public interface PersonDao {

    public List<Person> queryAll();

    public Person queryPersonById(String id);

}
