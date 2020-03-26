package com.example.trafficcounter.controllers;

import com.example.trafficcounter.domain.requests.CreateEventRequest;
import com.example.trafficcounter.domain.responses.TrafficResponse;
import com.example.trafficcounter.services.TrafficService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/traffic")
public class TrafficEventController {

    private TrafficService trafficService;

    @PostMapping(path = "/event")
    public TrafficResponse createEvent(CreateEventRequest request) {
        return trafficService.createEvent(request.getPageIdentifier(), request.getUserIdentifier());
    }
}
