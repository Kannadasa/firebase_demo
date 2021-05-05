package com.example.firebase_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Question1Activity extends AppCompatActivity {
    
    private CheckBox yes1;
    private CheckBox no1;
    private Button back1;
    private Button next1;

    FirebaseDatabase rootnode;
    DatabaseReference reference;

    protected void onCreate(Bundle icicle){
        super.onCreate(icicle);
        setContentView(R.layout.activity_question1);

        yes1 = findViewById(R.id.yes1);
        no1 = findViewById(R.id.no1);
        back1 =findViewById(R.id.back1);
        next1=findViewById(R.id.next1);

      no1.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
              if (no1.isChecked()){

                  back1.setOnClickListener(new OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          startActivity(new Intent(Question1Activity.this, MainActivity.class));
                      }
                  });

              }
          }
      });

      yes1.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
              if (yes1.isChecked()){
                  next1.setOnClickListener(new OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          startActivity(new Intent(Question1Activity.this, Question2Activity.class));
                      }
                  });
              }
          }
      });
        
    }
}