package com.example.loginpage_driver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    EditText FirstName, LastName, EmailId, Password, PhoneNum;
    Button SignUp;
    TextView TxtSignIn;
    FirebaseAuth mFirebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mFirebaseAuth = FirebaseAuth.getInstance();
        FirstName = findViewById(R.id.editText);
        LastName = findViewById(R.id.editText2);
        EmailId = findViewById(R.id.editText3);
        PhoneNum = findViewById(R.id.editText4);
        Password = findViewById(R.id.editText5);
        SignUp = findViewById(R.id.SignUpBtn1);
        TxtSignIn= findViewById(R.id.textView2);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = FirstName.getText().toString();
                String lastname = LastName.getText().toString();
                String email = EmailId.getText().toString();
                String phonenum = PhoneNum.getText().toString();
                String password = Password.getText().toString();
                if (firstname.isEmpty()) {
                    FirstName.setError("Please enter the First Name");
                    FirstName.requestFocus();
                    } else if (lastname.isEmpty()) {
                    LastName.setError("Please enter the Last Name");
                    LastName.requestFocus();
                     } else if (email.isEmpty()) {
                    EmailId.setError("Please enter the Email Id");
                    EmailId.requestFocus();
                     }   else if (phonenum.isEmpty()) {
                    PhoneNum.setError("Please enter the Phone number");
                    PhoneNum.requestFocus();
                     } else if (password.isEmpty()) {
                    Password.setError("Please enter the Password");
                    Password.requestFocus();

                     }

                    mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful())
                            {

                                Toast.makeText(SignUpActivity.this, "Sign-Up Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUpActivity.this, HomeActivity.class));
                                finish();
                            }
                            else {
                                Toast.makeText(SignUpActivity.this, "Sign-Up Un-Successful", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }




        });

        TxtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SignInTxt = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(SignInTxt);
            }
        });

    }
}