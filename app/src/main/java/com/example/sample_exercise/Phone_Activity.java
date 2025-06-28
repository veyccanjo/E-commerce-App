package com.example.sample_exercise;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;


public class Phone_Activity extends AppCompatActivity {
    private EditText phoneEditText, otpEditText;
    private Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        phoneEditText = findViewById(R.id.phonetext);
        otpEditText = findViewById(R.id.password);
        signin = findViewById(R.id.signin);

        signin.setOnClickListener(v ->{
            String phone = phoneEditText.getText().toString();
            String password = otpEditText.getText().toString();
            String psuedomail=phone+"@app.com";


        FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(psuedomail, password)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(this,SecondActivity.class));
                    }else{
                        Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();

                    }
                });

        });
    }





}
