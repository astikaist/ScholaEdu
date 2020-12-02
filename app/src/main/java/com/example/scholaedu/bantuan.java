package com.example.scholaedu;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class bantuan extends AppCompatActivity {
    private TextView toolbarText_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bantuan);
        toolbarText_ = findViewById(R.id.toolbar_text_help);

    }
}
