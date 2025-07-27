package com.lina.consumoapis.control;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

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

    private ProgressDialog progressDialog; //Para tener una ventanita emergente


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        //Oculta la barra superior (ActionBar)

        referent(); // para conectar el ListView con su ID
        getRequest(); //para ir a buscar los datos de la API
    }
    private void referent() {
        lvLitas = findViewById(R.id.lv);
    }

    private void getRequest(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dummy.restapiexample.com/api/v1/") // url de la api
                .addConverterFactory(GsonConverterFactory.create()) // Usa GsonConverterFactory para convertir el JSON en objetos Java.
                .build(); // empieza a contruir

        RestApiEmployees restAPiEmployees = retrofit.create(RestApiEmployees.class);
        progressDialog = new ProgressDialog(ListActivity1.this);
        progressDialog.setMessage("Cargando empleados....");
        progressDialog.setCancelable(false);
        progressDialog.show();

        Call<List<Employees>> call = restAPiEmployees.getEmployees();
        call.enqueue(new Callback<List<Employees>>() {
            @Override
            public void onResponse(Call<List<Employees>> call, Response<List<Employees>> response) {
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }

                if (response.isSuccessful() && response.body() != null) {
                    List<Employees> empleados = response.body();
                    adapterListEmployees = new AdapterListEmployees(ListActivity1.this, new ArrayList<>(empleados));
                    lvLitas.setAdapter(adapterListEmployees);
                } else {
                    Toast.makeText(ListActivity1.this, "Error al obtener empleados", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Employees>> call, Throwable t) {
                if (progressDialog != null && progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                Toast.makeText(ListActivity1.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}