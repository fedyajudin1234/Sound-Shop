package com.example.voice_shop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInMenu extends AppCompatActivity {
    private static final String TAG = "LogInMenu";
    private FirebaseAuth auth;
    private EditText editTextEmailLogIn;
    private EditText editTextPasswordLogIn;
    private EditText editTextConfirmPasswordLogIn;
    private TextView textViewLogIn;
    private Button buttonSignUp;
    private boolean logInActive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_menu);
        setTitle("Log In");
        auth = FirebaseAuth.getInstance();
        editTextEmailLogIn = findViewById(R.id.editTextEmailLogIn);
        editTextPasswordLogIn = findViewById(R.id.editTextPasswordLogIn);
        editTextConfirmPasswordLogIn = findViewById(R.id.editTextConfirmPasswordLogIn);
        textViewLogIn = findViewById(R.id.textViewLogIn);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpUser(editTextEmailLogIn.getText().toString().trim(),editTextPasswordLogIn.getText().toString().trim());
            }
        });
        if(auth.getCurrentUser() != null){
            startActivity(new Intent(LogInMenu.this,MainActivity.class));
        }
        
    }

    private void signUpUser(String email, String password) {
        if (logInActive) {
            if(editTextPasswordLogIn.getText().toString().trim().length() < 6) {
                Toast.makeText(this, "Password ought to be at least 6 characters", Toast.LENGTH_SHORT).show();
            }else if(editTextEmailLogIn.getText().toString().trim().equals("")) {
                Toast.makeText(this, "Enter your email address", Toast.LENGTH_SHORT).show();
            }else{
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = auth.getCurrentUser();
                                    startActivity(new Intent(LogInMenu.this,MainActivity.class));
                                } else {
                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(LogInMenu.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        }else{
            if(editTextPasswordLogIn.getText().toString().trim().equals(editTextConfirmPasswordLogIn.getText().toString().trim())){
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = auth.getCurrentUser();
                                    startActivity(new Intent(LogInMenu.this,MainActivity.class));
                                } else {
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(LogInMenu.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }else if(editTextPasswordLogIn.getText().toString().trim().length() < 6){
                Toast.makeText(this,"Password ought to be at least 6 characters",Toast.LENGTH_SHORT).show();
            }else if(editTextConfirmPasswordLogIn.getText().toString().trim().length() < 6){
                Toast.makeText(this,"Confirm password ought to be at least 6 characters",Toast.LENGTH_SHORT).show();
            }else if(editTextEmailLogIn.getText().toString().trim().equals("")){
                Toast.makeText(this,"Enter your email address",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Passwords aren't equal",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void logInMode(View view) {
        if(logInActive){
            logInActive = false;
            buttonSignUp.setText("Sign Up");
            textViewLogIn.setText("Or want to log in");
            editTextConfirmPasswordLogIn.setVisibility(View.VISIBLE);
        }else{
            logInActive = true;
            buttonSignUp.setText("Log In");
            textViewLogIn.setText("Or want to sign up");
            editTextConfirmPasswordLogIn.setVisibility(View.GONE);
        }
    }
}