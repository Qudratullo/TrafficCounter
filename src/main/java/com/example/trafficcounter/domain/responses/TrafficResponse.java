package com.example.trafficcounter.domain.responses;

public class TrafficResponse {
    private Long visitorsCount;
    private Long uniqueVisitorsCount;

    private TrafficResponse(Long visitorsCount, Long uniqueVisitorsCount) {
        this.visitorsCount = visitorsCount;
        this.uniqueVisitorsCount = uniqueVisitorsCount;
    }

    public static TrafficResponse create(Long visitorsCount, Long uniqueVisitorsCount) {
        return new TrafficResponse(visitorsCount, uniqueVisitorsCount);
    }

    public Long getVisitorsCount() {
        return visitorsCount;
    }

    public Long getUniqueVisitorsCount() {
        return uniqueVisitorsCount;
    }
}
