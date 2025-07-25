package com.lina.consumoapis.control;

import android.app.ActivityOptions;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.lina.consumoapis.R;

public class MainActivity extends AppCompatActivity {
    private Button btnListar, btnGuardar;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        referent();

    }

    private void referent() {

        btnGuardar = findViewById(R.id.btnGuardar);
        btnListar = findViewById(R.id.btnListar);
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent = new Intent(MainActivity.this, ListActivity.class);
                ActivityOptions options = null;
                Pair[] pairs = new Pair[2];

                pairs[0] = new Pair<View, String>(btnListar, "btnTransicion");
                pairs[1] = new Pair<View, String>(btnGuardar, "btnTransicion2");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                }

                startActivity(intent, options.toBundle());
            }
        });


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent = new Intent(MainActivity.this, activity_save.class);

                ActivityOptions options = null;
                Pair[] pairs = new Pair[2];

                pairs[0] = new Pair<View, String>(btnListar, "btnTransicion");
                pairs[1] = new Pair<View, String>(btnGuardar, "btnTransicion2");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                }

                startActivity(intent, options.toBundle());
            }
        });

    }

}