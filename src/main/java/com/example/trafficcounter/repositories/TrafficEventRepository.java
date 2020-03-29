package com.example.trafficcounter.repositories;

import com.example.trafficcounter.domain.models.TrafficEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface TrafficEventRepository extends JpaRepository<TrafficEvent, Long> {

    @Query("SELECT COUNT(e.id), COUNT (DISTINCT e.userIdentifier) FROM TrafficEvent e WHERE e.time >= :start AND e.time < :end")
    String getStatistics(LocalDateTime start, LocalDateTime end);
}
