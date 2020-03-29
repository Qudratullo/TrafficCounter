package com.example.trafficcounter.domain.responses;

public class TrafficResponse {
    private Long visitsCount;
    private Long visitorsCount;

    public static TrafficResponse create(Long visitsCount, Long visitorsCount) {
        TrafficResponse response = new TrafficResponse();
        response.visitsCount = visitsCount;
        response.visitorsCount = visitorsCount;
        return response;
    }

    public Long getVisitsCount() {
        return visitsCount;
    }

    public Long getVisitorsCount() {
        return visitorsCount;
    }
}
