package com.example.scholaedu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class tentang extends AppCompatActivity {
    private TextView toolbarText_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tentang);
        toolbarText_=findViewById(R.id.toolbar_text_tentang);

    }
}
