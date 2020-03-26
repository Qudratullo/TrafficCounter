package com.example.trafficcounter.domain.requests;

public class CreateEventRequest {
    private String userIdentifier;
    private String pageIdentifier;

    public static CreateEventRequest create(String userIdentifier, String pageIdentifier) {
        CreateEventRequest request = new CreateEventRequest();
        request.pageIdentifier = pageIdentifier;
        request.userIdentifier = userIdentifier;
        return request;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public String getPageIdentifier() {
        return pageIdentifier;
    }
}
