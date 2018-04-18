package com.example.aishwarya_basayye.questio_papers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Integer[] imageIDs = {
            R.drawable.civil,
            R.drawable.cse1,
            R.drawable.mechanical,
            R.drawable.firstyear1,
            R.drawable.entc,

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id)
            {
                Intent intent = new Intent(MainActivity.this, Select_Year.class);
                startActivity(intent) ;
              /* switch (position)
               {
                   case 0:
                       Intent intent=new Intent(MainActivity.this,SESyllabus.class);
                       startActivity(intent);
               }*/


                /*Toast.makeText(getBaseContext(),
                "pic" + (position + 1) + " selected",Toast.LENGTH_SHORT).show();
                        Intent  intent = new Intent(MainActivity.this, Select_Action.class);
                startActivity(intent) ;*/
                ;

            }
        });
    }




    public class ImageAdapter extends BaseAdapter {
        private Context context;

        public ImageAdapter(Context c) {
            context = c;
        }

        //---returns the number of images---
        public int getCount() {
            return imageIDs.length;
        }

        //---returns the ID of an item---
        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        //---returns an ImageView view---
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;


            if (convertView == null) {
                imageView = new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(275, 275));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setPadding(10, 10, 10, 10);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(imageIDs[position]);
            return imageView;
        }


    }
}




