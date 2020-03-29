package com.example.trafficcounter.services;

import com.example.trafficcounter.domain.models.TrafficEvent;
import com.example.trafficcounter.domain.responses.TrafficResponse;
import com.example.trafficcounter.repositories.TrafficEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class TrafficService {

    private TrafficEventRepository repository;

    @Autowired
    public TrafficService(TrafficEventRepository repository) {
        this.repository = repository;
    }

    public TrafficResponse createEvent(String pageIdentifier, String userIdentifier) {
        repository.save(TrafficEvent.create(userIdentifier, pageIdentifier));
        return buildTrafficResponse();
    }

    private TrafficResponse buildTrafficResponse() {
        LocalDateTime startTime = LocalDate.now().atStartOfDay();
        LocalDateTime endTime = LocalDate.now().plusDays(1).atStartOfDay();

        String statisticsString = repository.getStatistics(startTime, endTime);

        String[] strings = statisticsString.split(",");
        Long countEvents = Long.parseLong(strings[0]);
        Long countUsers = Long.parseLong(strings[1]);
        return TrafficResponse.create(countEvents, countUsers);
    }
}
