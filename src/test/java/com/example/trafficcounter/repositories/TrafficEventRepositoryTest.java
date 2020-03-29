package com.example.trafficcounter.repositories;

import com.example.trafficcounter.domain.models.TrafficEvent;
import com.example.trafficcounter.utils.Generator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TrafficEventRepositoryTest {
    @Autowired
    private TrafficEventRepository repository;

    @Test
    void create() {
        LocalDateTime nowTime = LocalDateTime.now();
        TrafficEvent trafficEvent = TrafficEvent.create(Generator.randomString(), Generator.randomString());

        repository.save(trafficEvent);

        assertNotNull(trafficEvent.getId());
        Optional<TrafficEvent> optionalTrafficEvent = repository.findById(trafficEvent.getId());
        assertTrue(optionalTrafficEvent.isPresent());
        assertEquals(trafficEvent, optionalTrafficEvent.get());
        System.out.println(trafficEvent.getTime());
        assertTrue(nowTime.plusMinutes(1).isAfter(trafficEvent.getTime()));
    }

    @Test
    void getStatistics() {
        String firstUserId = Generator.randomString();
        String secondUserId = Generator.randomString();
        String thirdUserId = Generator.randomString();
        createWithIdentifier(firstUserId);
        createWithIdentifier(firstUserId);
        createWithIdentifier(firstUserId);
        createWithIdentifier(secondUserId);
        createWithIdentifier(secondUserId);
        createWithIdentifier(thirdUserId);

        LocalDateTime startTime = LocalDate.now().atStartOfDay();
        LocalDateTime endTime = LocalDate.now().plusDays(1).atStartOfDay();

        String statisticsString = repository.getStatistics(startTime, endTime);
        String[] strings = statisticsString.split(",");
        Long countEvents = Long.parseLong(strings[0]);
        Long countUsers = Long.parseLong(strings[1]);

        assertEquals(6, countEvents);
        assertEquals(3, countUsers);
    }

    private TrafficEvent createWithIdentifier(String userIdentifier) {
        TrafficEvent trafficEvent = TrafficEvent.create(userIdentifier, Generator.randomString());
        repository.save(trafficEvent);
        return trafficEvent;
    }
}