package com.example.events.service;
import com.example.events.model.Event;
import java.util.List;
public interface EventService {
    List<Event> getAllEvents();
    Event saveEvent(Event event);
    void deleteEvent(Long id);
    Event updateEvent(Long id, Event updatedEvent);
    List<Event> filterByPrice(Double maxPrice);
}
