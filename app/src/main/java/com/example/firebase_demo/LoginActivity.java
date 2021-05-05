package com.example.firebase_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    
    private EditText name;
    private EditText email;
    private EditText passwd;
    private EditText mobile;

    private Button login;

    private FirebaseAuth auth;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        //mobile = findViewById(R.id.mobile);
        passwd = findViewById(R.id.password);


        login = findViewById(R.id.login);

        auth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Users");

                String txt_name = name.getText().toString();
                String txt_mobile = mobile.getText().toString();
                String txt_email = email.getText().toString();
                String txt_passwd = passwd.getText().toString();


                UserHelperClass helperClass = new UserHelperClass(txt_email,txt_passwd, txt_name, txt_mobile);
                reference.child(txt_mobile).setValue(helperClass);

                LoginUser(txt_email, txt_passwd, txt_name,txt_mobile);
            }
        });
    }
        
        private void LoginUser(String txt_email, String txt_passwd, String txt_name, String txt_mobile){
        auth.signInWithEmailAndPassword(txt_email,txt_passwd).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this, "Login Succssfull", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();

            }
        });

    }
}