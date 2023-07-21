package com.example.vexxa;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.text.BreakIterator;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Register extends AppCompatActivity {
    EditText edtNR;
    EditText edtEmail;
    EditText edtPass;
    EditText edtConfPass;
    Button btnSignUp;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        edtNR = findViewById(R.id.edtextNameReg);
        edtEmail = findViewById(R.id.editTextEmailAddress);
        edtPass = findViewById(R.id.editTextPass);
        edtConfPass = findViewById(R.id.editTextConPass);
        btnSignUp = findViewById(R.id.btnSignUp);
        mAuth = FirebaseAuth.getInstance();

        btnSignUp.setOnClickListener(view -> {
            createUser();
        });
    }

    private void createUser() {
        String Email = edtEmail.getText().toString();
        String Password = edtPass.getText().toString();
        String confirmPass = edtConfPass.getText().toString();

        if (TextUtils.isEmpty(Email)) {
            edtEmail.setError("This cannot be empty");
            edtEmail.requestFocus();
        } else if (TextUtils.isEmpty(Password)) {
            edtPass.setError("This cannot be empty");
            edtPass.requestFocus();
        } else if (confirmPass != null && !confirmPass.equals(Password)) { //password validator
            edtConfPass.setError("Password is not match");
            edtConfPass.requestFocus();
        } else if (Password.length() < 6) { //password validator
            edtPass.setError("must be at least 6 characters");
            edtPass.requestFocus();
        }else {
            mAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(Register.this, "User registered Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register.this, Login.class));
                        finish();
                    } else {
                        Toast.makeText(Register.this, "Registration Error!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}