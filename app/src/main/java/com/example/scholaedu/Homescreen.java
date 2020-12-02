package com.example.scholaedu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Homescreen extends AppCompatActivity {
    public static final String PREFERENCE_NAME = "Schola_Google_Login";
    private SharedPreferences sharedpreferences;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        sharedpreferences = this.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        if (sharedpreferences.getBoolean("hasLogin", true)){
            //Toast.makeText(Homescreen.this,"Welcome To Schola For " ,Toast.LENGTH_SHORT).show();
        } else {
            Intent home = new Intent(Homescreen.this, MainActivity.class);
            startActivity(home);
            finish();
        }

        loadFragment (new FindMentorFragment_1());
        bottomNavigationView = findViewById(R.id.bn_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.ic_find_mentor :
                        fragment = new FindMentorFragment_1();
                        break;
//                    case R.id.ic_group_discussion :
//                        fragment = new GrupFragment();
//                        break;
                    case R.id.ic_profile :
                        fragment = new ProfileFragment();
                        break;
                }
                return loadFragment(fragment);
            }
        });
    }
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_q, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}