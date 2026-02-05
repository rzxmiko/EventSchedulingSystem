package com.example.events.factory;

import com.example.events.model.Event;
import com.example.events.model.Organizer;

public class EventFactory {

    public static Event createEvent(String title, Double price, Organizer organizer) {
        return Event.builder()
                .title(title)
                .price(price)
                .organizer(organizer)
                .build();
    }
}