package com.example.trafficcounter.domain.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class TrafficEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userIdentifier;
    private String pageIdentifier;

    @Column(columnDefinition = "DATETIME(6)")
    private LocalDateTime time;

    public static TrafficEvent create(String userIdentifier, String pageIdentifier) {
        TrafficEvent event = new TrafficEvent();
        event.userIdentifier = userIdentifier;
        event.pageIdentifier = pageIdentifier;
        event.time = LocalDateTime.now();

        return event;
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
                time.isEqual(that.time);
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
