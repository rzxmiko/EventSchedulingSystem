package com.example.events.model;

import javax.persistence.*;

@Entity
@Table(name = "organizers")
public class Organizer extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int experience;

    public Organizer() { super(""); }
    public Organizer(String name, int experience) {
        super(name);
        this.experience = experience;
    }

    public Long getId() { return id; }
    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }
}