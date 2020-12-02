package com.example.scholaedu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class activity_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //SharedPreferences prefs = this.getSharedPreferences("Schola_Google_Login", Context.MODE_PRIVATE);
        /*
        if (prefs.getBoolean("hasLogin", true)){
            Toast.makeText(Homescreen.this,"Welcome To Schola" ,Toast.LENGTH_SHORT).show();
        } else {
            makesignin();
        }
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int waktu_splash = 4000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(activity_home.this, Homescreen.class);
                startActivity(home);
                finish();
            }
        }, waktu_splash);
    }
}