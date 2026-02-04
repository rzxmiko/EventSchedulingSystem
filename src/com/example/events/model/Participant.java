package com.example.events.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "participants")
public class Participant extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int age;

    public Participant() {
        super(""); // Пустой конструктор для Hibernate
    }

    public Participant(String name, int age) {
        super(name);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return super.toString() + ", Age: " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Participant that = (Participant) o;
        return age == that.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), age);
    }
}