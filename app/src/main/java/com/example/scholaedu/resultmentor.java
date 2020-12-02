package com.example.scholaedu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class resultmentor extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter_akademik;
    private ArrayList<Mahasiswa> mahasiswaArrayList;
    private DatabaseReference mDatabase;
    private TextView toolbarText_;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultmentor);
        toolbarText_=findViewById(R.id.toolbar_text_pencarian_mentor);
        Intent gonew = getIntent();
        String jenjang = gonew.getStringExtra("jenjang");

        String kelas = gonew.getStringExtra("kelas");
        final String mode = gonew.getStringExtra("mode");

        final String pelajaran = gonew.getStringExtra("pelajaran");
        final String lokasi = gonew.getStringExtra("lokasi");

        String path = "operation/akademik/";
        path = path + jenjang + "/" + kelas;

        Toast.makeText(this, path, Toast.LENGTH_SHORT).show();

        mDatabase = FirebaseDatabase.getInstance().getReference(path);

        mahasiswaArrayList = new ArrayList<>();
        if (lokasi.equalsIgnoreCase("Tidak ada lokasi")) {
            ValueEventListener valueEventListener = new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        for (DataSnapshot ds : snapshot.getChildren()) {
                            String speciality = ds.child("Speciality").getValue(String.class);
                            String biaya = ds.child(mode).getValue(String.class);
                            if (speciality.equalsIgnoreCase(pelajaran)) {
                                String nama = ds.child("Name").getValue(String.class);
                                mahasiswaArrayList.add(new Mahasiswa(nama, speciality, biaya));
                                adapter_akademik.notifyDataSetChanged();
                                //Toast.makeText(getApplicationContext(),"fund", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        Intent out = new Intent(getApplicationContext(), NotFound_backup.class);
                        startActivity(out);
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getApplicationContext(),"eror", Toast.LENGTH_SHORT).show();

                }
            };
            mDatabase.addListenerForSingleValueEvent(valueEventListener);
        } else {
            ValueEventListener valueEventListener = new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        for (DataSnapshot ds : snapshot.getChildren()) {
                            String lokasi_ = ds.child("Lokasi").getValue(String.class);
                            String speciality = ds.child("Speciality").getValue(String.class);
                            String biaya = ds.child(mode).getValue(String.class);
                            if (lokasi_.equalsIgnoreCase(lokasi) ) {
                                if (speciality.equalsIgnoreCase(pelajaran)) {
                                    String nama = ds.child("Name").getValue(String.class);
                                    mahasiswaArrayList.add(new Mahasiswa(nama, speciality, biaya));
                                    adapter_akademik.notifyDataSetChanged();
                                }
                            } else {
                                Intent out = new Intent(getApplicationContext(), NotFound_backup.class);
                                startActivity(out);
                            }
                        }
                    } else {
                        Intent out = new Intent(getApplicationContext(), NotFound_backup.class);
                        startActivity(out);
                        finish();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getApplicationContext(),"eror", Toast.LENGTH_SHORT).show();
                }
            };
            mDatabase.addListenerForSingleValueEvent(valueEventListener);
        }


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        adapter_akademik = new MahasiswaAdapter(mahasiswaArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(resultmentor.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter_akademik);



    }

}
