package com.example.vexxa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    private Button btnReset;
    private EditText edtReset;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        edtReset = (EditText) findViewById(R.id.editxtReset);
        btnReset = (Button) findViewById(R.id.btnSend);

        auth = FirebaseAuth.getInstance();

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });


    }

    private void resetPassword() {
        String email = edtReset.getText().toString().trim();

        if(email.isEmpty()){
            edtReset.setError("Cannot be empty");
            edtReset.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edtReset.setError("Invalid email!");
            edtReset.requestFocus();
            return;
        }
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful()){
                    Toast.makeText(ForgotPassword.this, "check your email to reset password", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(ForgotPassword.this, Login.class));
                    onStop();
                }else{
                    Toast.makeText(ForgotPassword.this, "something went wrong, try again", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}