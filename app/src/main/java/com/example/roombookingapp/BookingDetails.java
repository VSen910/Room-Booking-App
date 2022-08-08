package com.example.roombookingapp;

public class BookingDetails {
    private String name;
    private String email;
    private String phoneNumber;
    private String profession;
    private String roomNumber;
    private String date;
    private String timeSlot;
    private String purpose;

    public BookingDetails(String name, String email, String phoneNumber, String profession,
                          String roomNumber, String date, String timeSlot, String purpose) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.profession = profession;
        this.roomNumber = roomNumber;
        this.date = date;
        this.timeSlot = timeSlot;
        this.purpose = purpose;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getProfession() {
        return profession;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getDate() {
        return date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public String getPurpose() {
        return purpose;
    }
}
