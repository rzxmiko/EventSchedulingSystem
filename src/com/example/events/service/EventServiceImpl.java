package com.example.events.service;

import com.example.events.model.Event;
import com.example.events.repository.EventRepository;
import com.example.events.exception.EventNotFoundException;
import com.example.events.exception.InvalidEventDataException;
import com.example.events.factory.EventFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event saveEvent(Event event) {
        if (event.getTitle() == null || event.getTitle().isEmpty()) {
            throw new InvalidEventDataException("Event title cannot be empty!");
        }
        Event newEvent = EventFactory.createEvent(
                event.getTitle(),
                event.getPrice(),
                event.getEventDate(),
                event.getOrganizer()
        );
        return eventRepository.save(newEvent);
    }

    @Override
    public void deleteEvent(Long id) {
        if (!eventRepository.existsById(id)) {
            throw new EventNotFoundException(id);
        }
        eventRepository.deleteById(id);
    }

    @Override
    public Event updateEvent(Long id, Event updatedEvent) {
        return eventRepository.findById(id)
                .map(existingEvent -> {
                    existingEvent.setTitle(updatedEvent.getTitle());
                    existingEvent.setPrice(updatedEvent.getPrice());
                    existingEvent.setEventDate(updatedEvent.getEventDate());
                    return eventRepository.save(existingEvent);
                })
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    @Override
    public List<Event> filterByPrice(Double maxPrice) {
        return eventRepository.findAll().stream()
                .filter(e -> e.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }
}