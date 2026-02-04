package com.example.events.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
    private String name;

    public Person() {}
    public Person(String name) { this.name = name; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}