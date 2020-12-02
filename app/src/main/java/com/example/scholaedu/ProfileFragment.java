package com.example.scholaedu;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class ProfileFragment extends Fragment {
    private TextView nama_, email_, toolbarText_;
    private Toolbar toolbar;
    public static final String PREFERENCE_NAME = "Schola_Google_Login";
    private SharedPreferences sharedpreferences;
    private String nama, email;
    private Button sign_out, tentang, bantuan, pengaturan;
    private GoogleSignInClient mGoogleSignInClient;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.profile, container, false);

        toolbarText_ = view.findViewById(R.id.toolbar_text_profile);
        nama_ = view.findViewById(R.id.user);
        email_ = view.findViewById(R.id.email);
        tentang = view.findViewById(R.id.Tentang);
        bantuan = view.findViewById(R.id.Bantuan);
        pengaturan = view.findViewById(R.id.Pengaturan);
        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tentang_ = new Intent(getActivity(), tentang.class);
                startActivity(tentang_);
            }
        });
        bantuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tentang_ = new Intent(getActivity(), bantuan.class);
                startActivity(tentang_);
            }
        });
        pengaturan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tentang_ = new Intent(getActivity(), pengaturan.class);
                startActivity(tentang_);
            }
        });
        sharedpreferences = this.getActivity().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        nama = sharedpreferences.getString("name", "");
        email = sharedpreferences.getString("email", "");
        sign_out=view.findViewById(R.id.keluar);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(getContext(),gso);
        sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGoogleSignInClient.signOut();
                delpref();
                Toast.makeText(getActivity(),"You are Logged Out",Toast.LENGTH_SHORT).show();
                sign_out.setVisibility(View.INVISIBLE);
                Intent home = new Intent(getActivity(), MainActivity.class);
                startActivity(home);
            }
        });
        nama_.setText(nama);
        email_.setText(email);
        return view;
    }

    private void delpref(){
        sharedpreferences = this.getActivity().getSharedPreferences("Schola_Google_Login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedpreferences.edit();
        editor.putBoolean("hasLogin", false);
        editor.apply();
    }
}
