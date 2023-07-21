package com.example.vexxa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Filipino extends AppCompatActivity {
    private Button btnNangNg;
    private Button btnMunaMona;
    private Button btnKung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filipino);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnNangNg = findViewById(R.id.btnNangNg);
        btnNangNg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Filipino.this, NangNg.class));
            }
        });
        btnMunaMona = findViewById(R.id.btnMona);
        btnMunaMona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Filipino.this, MunaMona.class));
            }
        });
        btnKung = findViewById(R.id.btnKung);
        btnKung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Filipino.this, kungKong.class));
            }
        });
    }
}