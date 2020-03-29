package com.example.trafficcounter;

import com.example.trafficcounter.controllers.TrafficEventController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrafficCounterApplicationTests {

	@Autowired
	private TrafficEventController controller;

	@Test
	void contextLoads() {
		assertNotNull(controller);
	}

}
