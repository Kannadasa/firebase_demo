package com.example.firebase_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Question2Activity extends AppCompatActivity {
    
    Button back2, next2;
    
    CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;

    FirebaseDatabase rootnode;
    DatabaseReference reference;
    painScale pain;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        reference = rootnode.getInstance().getReference().child("answers");

        pain = new painScale();

        back2 = findViewById(R.id.back2);
        next2=findViewById(R.id.next2);

        c1=findViewById(R.id.one);
        c2=findViewById(R.id.two);
        c3=findViewById(R.id.three);
        c4=findViewById(R.id.four);
        c5=findViewById(R.id.five);
        c6=findViewById(R.id.six);
        c7=findViewById(R.id.seven);
        c8=findViewById(R.id.eight);
        c9=findViewById(R.id.nine);
        c10=findViewById(R.id.ten);

        String pain1 ="1";
        String pain2 ="2";
        String pain3 ="3";
        String pain4 ="4";
        String pain5 ="5";
        String pain6 ="6";
        String pain7 ="7";
        String pain8 ="8";
        String pain9 ="9";
        String pain10 ="10";

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){
                    i = (int)snapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(c1.isChecked()){

                    pain.setPainscalelevel(pain1);
                    reference.child(String.valueOf(i+1)).setValue(pain);
                    reference.child(String.valueOf(findViewById(R.id.login))).setValue(pain);

                }
                else {

                    ///
                }

                if(c2.isChecked()){

                    pain.setPainscalelevel(pain2);
                    reference.child(String.valueOf(i+1)).setValue(pain);

                }
                else {

                    ///
                }

                if(c3.isChecked()){

                    pain.setPainscalelevel(pain3);
                    reference.child(String.valueOf(i+1)).setValue(pain);

                }
                else {

                    ///
                }

                if(c4.isChecked()){

                    pain.setPainscalelevel(pain4);
                    reference.child(String.valueOf(i+1)).setValue(pain);

                }
                else {

                    ///
                }

                if(c5.isChecked()){

                    pain.setPainscalelevel(pain5);
                    reference.child(String.valueOf(i+1)).setValue(pain);

                }
                else {

                    ///
                }if(c5.isChecked()){

                    pain.setPainscalelevel(pain6);
                    reference.child(String.valueOf(i+1)).setValue(pain);

                }
                else {

                    ///
                }

                if(c6.isChecked()){

                    pain.setPainscalelevel(pain7);
                    reference.child(String.valueOf(i+1)).setValue(pain);

                }
                else {

                    ///
                }

                if(c7.isChecked()){

                    pain.setPainscalelevel(pain7);
                    reference.child(String.valueOf(i+1)).setValue(pain);

                }
                else {

                    ///
                }

                if(c8.isChecked()){

                    pain.setPainscalelevel(pain8);
                    reference.child(String.valueOf(i+1)).setValue(pain);

                }
                else {

                    ///
                }

                if(c9.isChecked()){

                    pain.setPainscalelevel(pain9);
                    reference.child(String.valueOf(i+1)).setValue(pain);

                }
                else {

                    ///
                }

                if(c10.isChecked()){

                    pain.setPainscalelevel(pain10);
                    reference.child(String.valueOf(i+1)).setValue(pain);

                }
                else {

                    ///
                }


            }
        });


    }
}