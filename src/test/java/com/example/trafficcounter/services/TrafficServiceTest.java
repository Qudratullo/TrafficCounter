package com.example.trafficcounter.services;

import com.example.trafficcounter.domain.responses.TrafficResponse;
import com.example.trafficcounter.utils.Generator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrafficServiceTest {

    @Autowired
    private TrafficService trafficService;

    @Test
    void createEvent() {
        String userIdentifier = Generator.randomString();
        trafficService.createEvent(Generator.randomString(), userIdentifier);
        trafficService.createEvent(Generator.randomString(), Generator.randomString());
        TrafficResponse event = trafficService.createEvent(Generator.randomString(), userIdentifier);

        assertNotNull(event);
        assertEquals(2, event.getVisitorsCount());
        assertEquals(3, event.getVisitsCount());
    }
}