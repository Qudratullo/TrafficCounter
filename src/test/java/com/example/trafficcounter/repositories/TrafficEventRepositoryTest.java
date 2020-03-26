package com.example.trafficcounter.repositories;

import com.example.trafficcounter.domain.models.TrafficEvent;
import com.example.trafficcounter.utils.Generator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TrafficEventRepositoryTest {
    @Autowired
    private TrafficEventRepository repository;

    @Test
    @Transactional
    void create() {
        LocalDateTime nowTime = LocalDateTime.now();
        TrafficEvent trafficEvent = TrafficEvent.create(Generator.randomString(), Generator.randomString());

        repository.saveAndFlush(trafficEvent);

        assertNotNull(trafficEvent.getId());
        Optional<TrafficEvent> optionalTrafficEvent = repository.findById(trafficEvent.getId());
        assertTrue(optionalTrafficEvent.isPresent());
        assertEquals(trafficEvent, optionalTrafficEvent.get());
        System.out.println(trafficEvent.getTime());
        assertTrue(nowTime.plusMinutes(1).isAfter(trafficEvent.getTime()));
    }
}