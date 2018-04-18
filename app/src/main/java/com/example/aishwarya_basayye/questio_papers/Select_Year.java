package com.example.aishwarya_basayye.questio_papers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Select_Year extends AppCompatActivity {
   // TextView textView;
    //TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__year);
        Intent intent=new Intent(Select_Year.this,Firebase.class);
        startActivity(intent);
      /*  textView1=(TextView)findViewById(R.id.TE);
        textView = (TextView) findViewById(R.id.SE);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Select_Year.this,SESyllabus.class);
                startActivity(intent);
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Select_Year.this,TESyllabus.class);
                startActivity(intent);

            }
        });*/
    }
    public void click(View view)
    {
        Intent intent = null;
        switch (view.getId()){
            case R.id.SE:
            intent =new Intent(this,Firebase.class);
            break;
            case R.id.TE:
                intent =new Intent(this,Firebase.class);
                break;
            case R.id.BE:
                intent =new Intent(this,Firebase.class);
                break;

        }
        startActivity(intent);
    }
    }

