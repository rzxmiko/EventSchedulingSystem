package com.example.events.model;

import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;

    public Event() {}
    public Event(String title, Double price, Organizer organizer) {
        this.title = title;
        this.price = price;
        this.organizer = organizer;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Organizer getOrganizer() { return organizer; }
    public void setOrganizer(Organizer organizer) { this.organizer = organizer; }
}