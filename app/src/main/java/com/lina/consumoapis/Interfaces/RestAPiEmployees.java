package com.lina.consumoapis.Interfaces;

import com.lina.consumoapis.model.Employees;
import com.lina.consumoapis.model.PostEmployee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestAPiEmployees {
    @GET("employees")
    Call<List<Employees>> getEmployees();

    @POST("create")
    Call<PostEmployee> createUser(@Body PostEmployee postEmployee);


}
