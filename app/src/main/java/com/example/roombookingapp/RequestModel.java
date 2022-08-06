package com.example.roombookingapp;

public class RequestModel {
    private String requestName;
    private String requestRoom;
    private String requestTime;
    private String requestDate;
    private String requestReason;
    private String requestPosition;

    public String getRequestName() {
        return requestName;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public String getRequestRoom() {
        return requestRoom;
    }

    public String getRequestPosition() {
        return requestPosition;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public String getRequestReason() {
        return requestReason;
    }

    public RequestModel(String requestName, String requestRoom, String requestTime, String requestDate, String requestReason, String requestPosition) {
        this.requestName = requestName;
        this.requestRoom = requestRoom;
        this.requestTime = requestTime;
        this.requestDate = requestDate;
        this.requestReason = requestReason;
        this.requestPosition = requestPosition;

    }
}
