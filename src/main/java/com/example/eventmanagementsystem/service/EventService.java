package com.example.eventmanagementsystem.service;



import com.example.eventmanagementsystem.dto.EventDto;
import com.example.eventmanagementsystem.dto.EventMapper;
import com.example.eventmanagementsystem.entity.Event;
import com.example.eventmanagementsystem.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<EventDto> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(EventMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<EventDto> getEventById(Long id) {
        return eventRepository.findById(id)
                .map(EventMapper::toDto);
    }

    public EventDto createEvent(EventDto eventDto) {
        Event event = EventMapper.toEntity(eventDto);
        Event savedEvent = eventRepository.save(event);
        return EventMapper.toDto(savedEvent);
    }

    public EventDto updateEvent(Long id, EventDto eventDetails) {
        Event event = eventRepository.findById(id).orElseThrow();
        event.setName(eventDetails.getName());
        event.setDescription(eventDetails.getDescription());
        event.setLocation(eventDetails.getLocation());
        event.setStartDate(eventDetails.getStartDate());
        event.setEndDate(eventDetails.getEndDate());
        event.setCapacity(eventDetails.getCapacity());
        Event updatedEvent = eventRepository.save(event);
        return EventMapper.toDto(updatedEvent);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
