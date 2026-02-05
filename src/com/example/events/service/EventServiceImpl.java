package com.example.events.service;
import com.example.events.factory.EventFactory;
import com.example.events.model.Event;
import com.example.events.repository.EventRepository;
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
        Event newEvent = EventFactory.createEvent(
                event.getTitle(),
                event.getPrice(),
                event.getOrganizer()
        );
        return eventRepository.save(newEvent);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public Event updateEvent(Long id, Event updatedEvent) {
        return eventRepository.findById(id)
                .map(existingEvent -> {
                    if (updatedEvent.getTitle() != null) existingEvent.setTitle(updatedEvent.getTitle());
                    if (updatedEvent.getPrice() != null) existingEvent.setPrice(updatedEvent.getPrice());
                    return eventRepository.save(existingEvent);
                })
                .orElseThrow(() -> new RuntimeException("Event not found with id " + id));
    }

    @Override
    public List<Event> filterByPrice(Double maxPrice) {
        return eventRepository.findAll().stream()
                .filter(e -> e.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }
}