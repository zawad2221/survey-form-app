package com.example.survey;


import com.example.survey.model.Response;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

interface Api {

    @POST("saveResponse/")
    Call<Response> saveResponse(@Body Response response);
}