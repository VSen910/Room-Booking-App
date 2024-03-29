package com.example.roombookingapp;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @POST("/login")
    Call<LoginResult> executeLogin(@Body HashMap<String, String> map);

    @POST("/register")
    Call<Void> executeRegister(@Body HashMap<String, String> map);

    @POST("/otp_verify")
    Call<String> executeOtpVerification();

    @POST("/add_user")
    Call<Void> executeAddUser();

    @POST("/add_booking")
    Call<Void> executeBookingAddition(@Body HashMap<String, String> map);

    @POST("/room_availability")
    Call<Void> executeRoomAvailability(@Body HashMap<String, String> map);

    @POST("/otp_forgetPass")
    Call<Void> executeOtpForgetPass(@Body HashMap<String, String> map);

    @POST("/change_pass")
    Call<Void> executeChangePass(@Body HashMap<String, String> map);

    @POST("/admin_pendingReq")
    Call<ArrayList<BookingDetails>> executeAdminPendingReq();

    @POST("/admin_reqDecline")
    Call<Void> executeAdminReqDecline(@Body HashMap<String, String> map);

    @POST("/admin_reqAccept")
    Call<Void> executeAdminReqAccept(@Body HashMap<String, String> map);

    @POST("/user_bookings")
    Call<ArrayList<BookingDetails>> executeUserBooking(@Body HashMap<String, String> map);

    @POST("/admin_history")
    Call<ArrayList<BookingDetails>> executeAdminHistory();

    @POST("/admin_login")
    Call<Void> executeAdminLogin(@Body HashMap<String, String> map);
}
