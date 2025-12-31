package com.example.contactcrud.controller;

import com.example.contactcrud.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventUIController {

    private final EventService eventService;

    public EventUIController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "events";   // events.html
    }
}
