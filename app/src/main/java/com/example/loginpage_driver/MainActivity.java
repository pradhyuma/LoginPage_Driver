package com.example.loginpage_driver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button SignUp, SignIn;
    FirebaseAuth mFireBaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFireBaseAuth = FirebaseAuth.getInstance();
        SignUp = findViewById(R.id.SignUp);
        SignUp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               Intent SignUp= new Intent(MainActivity.this, SignUpActivity.class);
               startActivity(SignUp);
            }


        });

        SignIn = findViewById(R.id.SignInBtn);
        SignIn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               Intent SignIn= new Intent(MainActivity.this, SignInActivity.class);
               startActivity(SignIn);
            }


        });
    }
}
