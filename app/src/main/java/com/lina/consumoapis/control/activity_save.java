package com.lina.consumoapis.control;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.lina.consumoapis.Interfaces.RestApiEmployees;
import com.lina.consumoapis.R;
import com.lina.consumoapis.model.PostEmployee;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activity_save extends AppCompatActivity {
    private EditText editName, editSalary, editAge;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        initViews(); //configura los elementos de la vista
    }

    private void initViews() {
        editName = findViewById(R.id.nameEmpleado);
        editSalary = findViewById(R.id.salarioEmpleado);
        editAge = findViewById(R.id.edadEmpleado);
        btnSave = findViewById(R.id.btnguardar);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editName.getText().toString().isEmpty() &&
                        !editSalary.getText().toString().isEmpty() &&
                        !editAge.getText().toString().isEmpty()) {
                    requesPost();
                } else {
                    Toast.makeText(activity_save.this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //metodo envia los datos al servidor
    private void requesPost() {

        PostEmployee postEmployee = new PostEmployee();
        //Se llenan los campos con lo que esribio el user
        postEmployee.setName(editName.getText().toString());
        postEmployee.setSalary(Double.parseDouble(editSalary.getText().toString()));
        postEmployee.setAge(Integer.parseInt(editAge.getText().toString()));

        // Aquí se crea un cliente de Retrofit que se conectará a esa URL base.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dummy.restapiexample.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create()) // convertir de objeto java a json
                .build();

        RestApiEmployees restApiEmployees = retrofit.create(RestApiEmployees.class);
        Call<PostEmployee> call = restApiEmployees.createUser(postEmployee);
        call.enqueue(new Callback<PostEmployee>() {
            @Override
            public void onResponse(Call<PostEmployee> call, Response<PostEmployee> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(activity_save.this, "No se insertaron los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(activity_save.this, "Se inserto correctamnete el nuevo empleado", Toast.LENGTH_SHORT).show();
                    clear();
                }
            }
            @Override
            public void onFailure(Call<PostEmployee> call, Throwable t) {
                Log.e("ErrorApi", t.getMessage());
            }
        });
    }
    //limpia los campos despues de guardar la dat
    private void clear() {
        editName.setText("");
        editSalary.setText("");
        editAge.setText("");
    }
}