package com.lina.consumoapis;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activity_save extends AppCompatActivity {
    EditText nameempleado, salario, edad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_save);
        nameempleado = findViewById(R.id.nameEmpleado);
        salario = findViewById(R.id.salarioEmpleado);
        edad = findViewById(R.id.edadEmpleado);
    }
}