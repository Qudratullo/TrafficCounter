package com.example.trafficcounter.repositories;

import com.example.trafficcounter.domain.models.TrafficEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrafficEventRepository extends JpaRepository<TrafficEvent, Long> {
}
