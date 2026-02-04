package com.example.events.service;

import com.example.events.model.Event;
import com.example.events.repository.EventRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // Метод для получения всех событий
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // НОВЫЙ МЕТОД: Сохранение события
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
    public Event updateEvent(Long id, Event updatedEvent) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id " + id));

        if (updatedEvent.getTitle() != null) {
            existingEvent.setTitle(updatedEvent.getTitle());
        }
        if (updatedEvent.getPrice() != null) {
            existingEvent.setPrice(updatedEvent.getPrice());
        }

        return eventRepository.save(existingEvent);
    }
}