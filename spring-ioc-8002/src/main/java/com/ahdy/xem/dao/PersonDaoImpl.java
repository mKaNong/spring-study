package com.ahdy.xem.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
public class PersonDaoImpl implements com.ahdy.xem.dao.PersonDao {
    @Override
    public String queryAll() {
        return "query all person from db";
    }
}
