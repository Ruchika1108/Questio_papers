package com.example.aishwarya_basayye.questio_papers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectAction extends AppCompatActivity {
    Button b5;
    Button b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_action);
        b6=(Button)findViewById(R.id.Question);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(SelectAction.this,MainActivity.class);
                startActivity(intent);
            }
        });
        b5 = (Button)findViewById(R.id.Syllabus);
       b5.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent= new Intent(SelectAction.this,AllSyllabus.class);
        startActivity(intent);
    }
});


    }
}
