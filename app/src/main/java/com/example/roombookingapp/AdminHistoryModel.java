package com.example.roombookingapp;

import java.sql.Time;

public class AdminHistoryModel {
    private String historyName;
    private String historyRoom;
    private String historyTime;
    private String historyDate;
    private String historyReason;
    private String historyPosition;
    private String historyStatus;
    private String historyEmail;
    private String historyPhone;


    public String getHistoryName() {
        return historyName;
    }

    public String getHistoryRoom() {
        return historyRoom;
    }

    public String getHistoryTime() {
        return historyTime;
    }

    public String getHistoryDate() {
        return historyDate;
    }

    public String getHistoryReason() {
        return historyReason;
    }

    public String getHistoryPosition() {
        return historyPosition;
    }

    public String getHistoryStatus() {
        return historyStatus;
    }

    public String getHistoryEmail() {
        return historyEmail;
    }

    public String getHistoryPhone() {
        return historyPhone;
    }


    public AdminHistoryModel(String historyName, String historyRoom, String historyTime, String historyDate, String historyReason, String historyPosition, String historyStatus, String historyEmail, String historyPhone) {
        this.historyName = historyName;
        this.historyRoom = historyRoom;
        this.historyTime = historyTime;
        this.historyDate = historyDate;
        this.historyReason = historyReason;
        this.historyPosition = historyPosition;
        this.historyStatus = historyStatus;
        this.historyEmail = historyEmail;
        this.historyPhone = historyPhone;
    }
}