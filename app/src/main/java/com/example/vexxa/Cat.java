package com.example.vexxa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Cat extends AppCompatActivity {
    private Button btnGuess;
    private Button btnGrammar;
    private Button btnBrain;
    private Button btnMini;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);



            btnGuess = findViewById(R.id.btnGuess);
            btnGrammar = findViewById(R.id.btnGrammar);
            btnBrain = findViewById(R.id.btnBrain);

            btnGuess.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Cat.this, General.class);
                    startActivity(intent);
                }
            });
            btnGrammar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Cat.this, Grammar.class);
                    startActivity(intent);
                }
            });
            btnBrain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Cat.this, brainTeaser.class);
                    startActivity(intent);
                }
            });
        /*btnBrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cat.this, GuessingGame.class);
                startActivity(intent);
            }
        });
        btnMini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cat.this, MiniGames.class);
                startActivity(intent);
            }
        });*/
    }
}