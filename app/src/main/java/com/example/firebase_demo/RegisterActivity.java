package com.example.firebase_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.SplittableRandom;

public class RegisterActivity extends AppCompatActivity {

    private EditText email;
    private EditText passwd;
    private Button register;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        passwd = findViewById(R.id.password);
        register = findViewById(R.id.register);

        auth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email = email.getText().toString();
                String txt_passwd = passwd.getText().toString();

             If(TextUtils.isEmpty(txt_email)) || (TextUtils.isEmpty(txt_passwd) {
                    Toast.makeText(RegisterActivity.this, "Empty Password", Toast.LENGTH_SHORT).show();

                }else if (txt_passwd.length() < 6) {

                 Toast.makeText(RegisterActivity.this, "Password too short", Toast.LENGTH_SHORT).show();
                }else {

                 registerUser(txt_email, txt_passwd);
                }

            }
        });

    }

    private void registerUser(String email, String passwd){
        auth.createUserWithEmailAndPassword(email, passwd).addOnCompleteListener(RegisterActivity.this, new, OnCompleteListener<AuthResult>(){)
    }
}