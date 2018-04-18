package com.example.aishwarya_basayye.questio_papers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AllSyllabus extends AppCompatActivity {
    Button b1;
    Button b2, b3, b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_syllabus);
       b1=(Button)findViewById(R.id.FE);
       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(AllSyllabus.this,FESyllabus.class);
               startActivity(intent);

           }
       });
        b2=(Button)findViewById(R.id.SE);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AllSyllabus.this,SESyllabus.class);
                startActivity(intent);

            }
        });
        b3=(Button)findViewById(R.id.TE);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AllSyllabus.this,TESyllabus.class);
                startActivity(intent);

            }
        });
        b4=(Button)findViewById(R.id.BE);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AllSyllabus.this,BESyllabus.class);
                startActivity(intent);

            }
        });

    }
}