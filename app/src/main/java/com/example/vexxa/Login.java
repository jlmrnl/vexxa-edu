package com.example.vexxa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {
    EditText edtEmailLog;
    EditText edtPassLog;
    Button btnLogin;
    TextView txtReset;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtEmailLog = findViewById(R.id.editxtEmailLog);
        edtPassLog = findViewById(R.id.editxtPassLog);
        btnLogin = findViewById(R.id.btnLog);
        txtReset = findViewById(R.id.txtReset);
        mAuth = FirebaseAuth.getInstance();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        txtReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, ForgotPassword.class));
                onPause();
            }
        });
        btnLogin.setOnClickListener(view -> {
            loginUser();
        });
    }

    private void loginUser() {
        Intent mainMenu = new Intent(Login.this, mainMenu.class);
        String Email = edtEmailLog.getText().toString();
        String Password = edtPassLog.getText().toString();

        if (TextUtils.isEmpty(Email)) {
            edtEmailLog.setError("Email cannot be empty");
            edtEmailLog.requestFocus();
        } else if (TextUtils.isEmpty(Password)) {
            edtPassLog.setError("Password cannot be empty");
            edtPassLog.requestFocus();
        } else {
            mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(Login.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(mainMenu);
                        onDestroy();
                    } else {
                        Toast.makeText(Login.this, "Login Error!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

    }
}