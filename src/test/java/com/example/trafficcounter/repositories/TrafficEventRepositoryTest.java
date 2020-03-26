package com.example.trafficcounter.repositories;

import com.example.trafficcounter.domain.models.TrafficEvent;
import com.example.trafficcounter.utils.Generator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrafficEventRepositoryTest {
    @Autowired
    private TrafficEventRepository repository;

    @Test
    void create() {
        TrafficEvent trafficEvent = TrafficEvent.create(Generator.randomString(), Generator.randomString());

        repository.save(trafficEvent);

        assertNotNull(trafficEvent.getId());
        Optional<TrafficEvent> optionalTrafficEvent = repository.findById(trafficEvent.getId());
        assertTrue(optionalTrafficEvent.isPresent());
        assertEquals(trafficEvent, optionalTrafficEvent.get());
    }
}