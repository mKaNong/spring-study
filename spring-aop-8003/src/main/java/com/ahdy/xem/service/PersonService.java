package com.ahdy.xem.service;

import com.ahdy.xem.entity.Person;

import java.util.List;

public interface PersonService {

    public List<Person> queryAllPerson();

    public Person queryPersonById(String id);

}
