package com.example.events.model;

import javax.persistence.*;
import java.util.Objects;

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
        setPrice(price);
        this.organizer = organizer;
    }

    public static EventBuilder builder() {
        return new EventBuilder();
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Double getPrice() { return price; }

    public void setPrice(Double price) {
        if (price != null && price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    public Organizer getOrganizer() { return organizer; }
    public void setOrganizer(Organizer organizer) { this.organizer = organizer; }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static class EventBuilder {
        private String title;
        private Double price;
        private Organizer organizer;

        public EventBuilder title(String title) {
            this.title = title;
            return this;
        }

        public EventBuilder price(Double price) {
            this.price = price;
            return this;
        }

        public EventBuilder organizer(Organizer organizer) {
            this.organizer = organizer;
            return this;
        }

        public Event build() {
            return new Event(title, price, organizer);
        }
    }
}