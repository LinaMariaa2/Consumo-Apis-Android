package com.lina.consumoapis.control;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.lina.consumoapis.Interfaces.RestApiEmployees;
import com.lina.consumoapis.R;
import com.lina.consumoapis.model.AdapterListEmployees;
import com.lina.consumoapis.model.Employees;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListActivity1 extends AppCompatActivity {
    private ListView lvLitas;
    private AdapterListEmployees adapterListEmployees;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list1);

        getSupportActionBar().hide();
        referent();
        getRequest();

    }
    private void referent() {

        lvLitas = findViewById(R.id.lv);

    }

    private void getRequest(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dummy.restapiexample.com/api/v1") // url de la api
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestApiEmployees restAPiEmployees = retrofit.create(RestApiEmployees.class);
        Call<List<Employees>> call = restAPiEmployees.getEmployees();
        call.enqueue(new Callback<List<Employees>>() {
            @Override
            public void onResponse(Call<List<Employees>> call, Response<List<Employees>> response) {
                if (!response.isSuccessful()) {
                    Log.e("error","no hay datos");
                    return;
                }
                adapterListEmployees = new AdapterListEmployees(ListActivity1.this, (ArrayList<Employees>) response.body());
                lvLitas.setAdapter(adapterListEmployees);
            }

            @Override
            public void onFailure(Call<List<Employees>> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }
}