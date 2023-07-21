package com.example.vexxa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class about extends AppCompatActivity {
    TextView txtAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        txtAbout = findViewById(R.id.txtAbout);
        txtAbout.setText("The world of TECHNOLOGY is now more useful and more accessible as the time goes by; more people would like to use the application like this to learn different kinds of lessons. " +
                "\n\nThe application has the type that children can enjoy. Instead of playing mobile games, they can play as they learn. " +
                "\n\nThe CONCCEPT of this application to keep the knowledge fresh and most people use gadget for gaming instead of learning without excitement but now this application is here not just to learn but to enjoy playing and learning. " +
                "\n\nLearners BENEFIT from varied exposure to the tasks. That's why 'The Team' help and offer different kinds of LEARNING EXPERIENCES to keep them motivated and explore more.\n" +
                "\n2BSIT-09\nGroup 4");
    }
}