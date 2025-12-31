package com.example.contactcrud.service;

import com.example.contactcrud.entity.Event;
import com.example.contactcrud.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // Add Event
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    // Get all Events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Get Event by id
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    // Delete Event
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    // Update Event
    public Event updateEvent(Long id, Event newEvent) {
        Event existingEvent = eventRepository.findById(id).orElse(null);

        if (existingEvent != null) {
            existingEvent.setName(newEvent.getName());
            existingEvent.setLocation(newEvent.getLocation());
            existingEvent.setDate(newEvent.getDate());
            existingEvent.setContactNumber(newEvent.getContactNumber());
            return eventRepository.save(existingEvent);
        }
        return null;
    }
}

