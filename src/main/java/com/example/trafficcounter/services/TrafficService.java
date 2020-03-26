package com.example.trafficcounter.services;

import com.example.trafficcounter.domain.models.TrafficEvent;
import com.example.trafficcounter.domain.responses.TrafficResponse;
import com.example.trafficcounter.repositories.TrafficEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrafficService {

    private TrafficEventRepository repository;

    @Autowired
    public TrafficService(TrafficEventRepository repository) {
        this.repository = repository;
    }

    public TrafficResponse createEvent(String pageIdentifier, String userIdentifier) {
        repository.save(TrafficEvent.create(userIdentifier, pageIdentifier));
        return TrafficResponse.create(121L, 32L);
    }
}
