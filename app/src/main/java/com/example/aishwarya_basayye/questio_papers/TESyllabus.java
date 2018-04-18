package com.example.aishwarya_basayye.questio_papers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class TESyllabus extends AppCompatActivity {
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tesyllabus);
        pdfView=(PDFView)findViewById(R.id.pdfView);
        pdfView.fromAsset("tecse.pdf").load();

    }
}
