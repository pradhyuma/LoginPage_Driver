package com.example.loginpage_driver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity {
    EditText EmailId, Password;
    Button SignInBtn;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mFirebaseAuth= FirebaseAuth.getInstance();
        EmailId= findViewById(R.id.editText3);
        Password= findViewById(R.id.editText5);
        SignInBtn= findViewById(R.id.SignInBtn1);


        SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailid= EmailId.getText().toString();
                String password= Password.getText().toString();
                if(emailid.isEmpty())
                {
                    EmailId.setError("Please enter Email-Id");
                    EmailId.requestFocus();

                }
                    else if(password.isEmpty())
                    {
                    Password.setError("Please Enter the password");
                    Password.requestFocus();
                    }

                else
                {
                    mAuthStateListener = new FirebaseAuth.AuthStateListener() {
                        @Override
                        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                            FirebaseUser mFirebaseUser= mFirebaseAuth.getCurrentUser();

                            if(mFirebaseUser != null){
                                Intent homepage= new Intent(SignInActivity.this, HomeActivity.class);
                                startActivity(homepage);
                            }
                            else{
                                Toast.makeText(SignInActivity.this, "User not found", Toast.LENGTH_SHORT).show();
                            }
                        }
                    };




                }

            }
        });



    }
}
