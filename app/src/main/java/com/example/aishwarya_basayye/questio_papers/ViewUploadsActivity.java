package com.example.aishwarya_basayye.questio_papers;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewUploadsActivity extends AppCompatActivity {
    ListView listView;

    //database reference to get uploads data
    DatabaseReference mDatabaseReference;

    //list to store uploads data
    List<Upload> uploadList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_uploads);

        uploadList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listview);


        //adding a clicklistener on listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //getting the upload
                Upload upload = uploadList.get(i);

                //Opening the upload file in browser using the upload url
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(upload.getUrl()));
                startActivity(intent);
            }
        });


        //getting the database reference
        mDatabaseReference = FirebaseDatabase.getInstance().getReference(Constants.DATABASE_PATH_UPLOADS);

        //retrieving upload data from firebase database
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Upload upload = postSnapshot.getValue(Upload.class);
                    uploadList.add(upload);
                }

                String[] uploads = new String[uploadList.size()];

                for (int i = 0; i < uploads.length; i++) {
                    uploads[i] = uploadList.get(i).getName();
                }

                //displaying it to list
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, uploads);
                listView.setAdapter(adapter);
                this.registerForContextMenu(listView);


            }

            private void registerForContextMenu(ListView listView) {
            }


            public  void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo)
            {
                this.onCreateContextMenu(menu,view,menuInfo);
                menu.setHeaderTitle("Select the Action");
                menu.add(0,view.getId(),0,"Download");
                menu.add(0,view.getId(),0,"View");
                menu.add(0,view.getId(),0,"Delete");

            }
            public boolean onContextItemSelected(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                int itemPosition=info.position;
                Uri uri;
                int selected=0;
                switch (item.getItemId()){
                    case 0: Toast.makeText(getApplicationContext(), "Downloading", Toast.LENGTH_LONG).show();
                    break;
                    case 1: Toast.makeText(getApplicationContext(), "View", Toast.LENGTH_LONG).show();
                    break;
                    case 3: Toast.makeText(getApplicationContext(), "Delete", Toast.LENGTH_LONG).show();
                }


                /*if (item.getTitle() == "Download") {
                    Toast.makeText(getApplicationContext(), "Downloading", Toast.LENGTH_LONG).show();
                } else if (item.getTitle() == "View") {
                    Toast.makeText(getApplicationContext(), "View", Toast.LENGTH_LONG).show();
                } else if (item.getTitle() == "Delete") {
                    Toast.makeText(getApplicationContext(), "Delete", Toast.LENGTH_LONG).show();
                } else {
                    return false;
                }*/
                return ViewUploadsActivity.super.onContextItemSelected(item);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }});

    }
    }



