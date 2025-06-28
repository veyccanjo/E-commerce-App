package com.example.sample_exercise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class RegisterUser extends AppCompatActivity {

    TextInputEditText emailText;
    TextInputEditText passwordText;
    Button registerButton;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_user);
        emailText=findViewById(R.id.email);
        passwordText=findViewById(R.id.password);
        registerButton=findViewById(R.id.registerbtn);
        mAuth=FirebaseAuth.getInstance();
        registerButton.setOnClickListener(v -> {
            String email=emailText.getText().toString();
            String password=passwordText.getText().toString();
            registerUser(email,password);

            // Hide the keyboard after registration
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            View view = getCurrentFocus();
            if (view != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }

        });
    }
    public void registerUser(String email,String password){
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(this,MainActivity.class));
                        finish();
                    }else {
                        Exception exception = task.getException();
                        if (exception instanceof FirebaseAuthUserCollisionException) {
                            Toast.makeText(this, "User already exists", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(this, MainActivity.class));
                            finish();
                        } else {
                            Toast.makeText(this, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}