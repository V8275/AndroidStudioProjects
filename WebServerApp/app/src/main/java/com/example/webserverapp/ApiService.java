package com.example.webserverapp;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Body;
import retrofit2.http.Path;

import java.util.List;

public interface ApiService {
    String BASE_URL = "http://192.168.31.95:5000/";

    @GET("api/Cruises")
    Call<List<Cruise>> getCruises();

    @POST("api/Cruises")
    Call<Cruise> addCruise(@Body Cruise cruise);

    @DELETE("api/Cruises/{id}")
    Call<Void> deleteCruise(@Path("id") int id);

    @GET("api/Routes")
    Call<List<Route>> getRoutes();

    @POST("api/Routes")
    Call<Route> addRoute(@Body Route route);

    @DELETE("api/Routes/{id}")
    Call<Void> deleteRoute(@Path("id") int id);

    @GET("api/CruiseRoutes")
    Call<List<CruiseRoute>> getCruiseRoutes();
}