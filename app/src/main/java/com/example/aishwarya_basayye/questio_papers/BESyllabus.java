package com.example.aishwarya_basayye.questio_papers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class BESyllabus extends AppCompatActivity {
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_besyllabus);
        pdfView=(PDFView)findViewById(R.id.pdfView);
        pdfView.fromAsset("becse.pdf").load();
    }
}
