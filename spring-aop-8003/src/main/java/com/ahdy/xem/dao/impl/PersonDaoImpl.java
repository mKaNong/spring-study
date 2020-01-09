package com.ahdy.xem.dao.impl;

import com.ahdy.xem.dao.PersonDao;
import com.ahdy.xem.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {
    private static List<Person> list = new ArrayList<Person>();

    static {
        list.add(new Person("1", "ZhangSan", 18, "changsha"));
        list.add(new Person("2", "LiSi", 19, "nanjing"));
        list.add(new Person("3", "WangWu", 20, "beijing"));
    }

    @Override
    public List<Person> queryAll() {
        return list;
    }

    @Override
    public Person queryPersonById(String id) {
        for(Person p : list){
            if(id.equals(p.getId())){
                return p;
            }
        }
        return null;
    }
}
