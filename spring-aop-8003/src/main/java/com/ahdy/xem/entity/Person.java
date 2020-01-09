package com.ahdy.xem.entity;

import java.io.Serializable;

public class Person implements Serializable {
    private String id;

    private String name;

    private int age;

    private String area;

    public Person(){}

    public Person(String id, String name, int age, String area){
        this.id = id;
        this.name = name;
        this.age = age;
        this.area = area;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id= '" + id + '\'' +
                ", name= '" + name + '\'' +
                ", age= " + age +
                ", area= '" + area + '\'' +
                '}';
    }
}
