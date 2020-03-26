package com.example.trafficcounter.domain.requests;

public class CreateEventRequest {
    private String userIdentifier;
    private String pageIdentifier;

    private CreateEventRequest(String userIdentifier, String pageIdentifier) {
        this.userIdentifier = userIdentifier;
        this.pageIdentifier = pageIdentifier;
    }

    public static CreateEventRequest create(String userIdentifier, String pageIdentifier) {
        return new CreateEventRequest(userIdentifier, pageIdentifier);
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public String getPageIdentifier() {
        return pageIdentifier;
    }
}
