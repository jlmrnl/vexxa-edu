package com.example.vexxa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class English extends AppCompatActivity {
    private Button btnThereTheir;
    private Button btnYour;
    private Button btnHes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnThereTheir = findViewById(R.id.btnThereTheir);
        btnThereTheir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(English.this, mainThereTheir.class));
            }
        });
        btnYour = findViewById(R.id.btnYour);
        btnYour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(English.this, Your.class));
            }
        });
        btnHes = findViewById(R.id.btnHesHis);
        btnHes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(English.this, Heshis.class));
            }
        });
    }
}