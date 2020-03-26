package com.example.trafficcounter.domain.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class TrafficEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userIdentifier;
    private String pageIdentifier;
    private LocalDateTime time;

    private TrafficEvent(String userIdentifier, String pageIdentifier) {
        this.userIdentifier = userIdentifier;
        this.pageIdentifier = pageIdentifier;
        this.time = LocalDateTime.now();
    }

    public static TrafficEvent create(String userIdentifier, String pageIdentifier) {
        return new TrafficEvent(userIdentifier, pageIdentifier);
    }

    public Long getId() {
        return id;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public String getPageIdentifier() {
        return pageIdentifier;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrafficEvent that = (TrafficEvent) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userIdentifier, that.userIdentifier) &&
                Objects.equals(pageIdentifier, that.pageIdentifier) &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userIdentifier, pageIdentifier, time);
    }

    @Override
    public String toString() {
        return "TrafficEvent{" +
                "id=" + id +
                ", userIdentifier='" + userIdentifier + '\'' +
                ", pageIdentifier='" + pageIdentifier + '\'' +
                ", time=" + time +
                '}';
    }
}
