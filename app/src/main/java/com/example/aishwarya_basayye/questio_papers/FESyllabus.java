package com.example.aishwarya_basayye.questio_papers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class FESyllabus extends AppCompatActivity {
    PDFView pdfView ,pdfView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fesyllabus);
        pdfView=(PDFView)findViewById(R.id.pdfView);
        pdfView.fromAsset("FESyllabusSEM1.pdf").load();
        pdfView1=(PDFView)findViewById(R.id.pdfView1);
        pdfView1.fromAsset("FESyllabusSEM2.pdf").load();

    }
}
