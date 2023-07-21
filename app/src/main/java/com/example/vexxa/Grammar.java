package com.example.vexxa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Grammar extends AppCompatActivity {
    private Button btnFilipino;
    private Button btnEnglish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnFilipino = findViewById(R.id.btnFilipino);
        btnEnglish = findViewById(R.id.btnEnglish);

        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Grammar.this, English.class);
                startActivity(intent);
                onPause();
            }
        });
        btnFilipino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Grammar.this, Filipino.class);
                startActivity(intent);
                onPause();
            }
        });
    }
}