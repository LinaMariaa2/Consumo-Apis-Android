package com.lina.consumoapis.Interfaces;

import com.lina.consumoapis.model.Employees;
import com.lina.consumoapis.model.PostEmployee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
//Interfaz de retrofit para consumir APIs REST
public interface RestApiEmployees {
    // definimos cada una de las rutas "el metodo"  el "endpoitn"
    @GET("employees")
    Call<List<Employees>> getEmployees();

    @POST("create")
    Call<PostEmployee> createUser(@Body PostEmployee postEmployee);


}
