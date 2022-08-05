package com.example.roombookingapp;

public class RequestModel {
    String requestName;
    String requestRoom;
    String requestTime;
    String requestDay;
    String requestReason;
    String requestPosition;

    public String getRequestName() {
        return requestName;
    }

    public String getRequestDay() {
        return requestDay;
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

    public RequestModel(String requestName, String requestRoom, String requestTime, String requestDay, String requestReason, String requestPosition) {
        this.requestName = requestName;
        this.requestRoom = requestRoom;
        this.requestTime = requestTime;
        this.requestDay = requestDay;
        this.requestReason = requestReason;
        this.requestPosition = requestPosition;

    }
}
