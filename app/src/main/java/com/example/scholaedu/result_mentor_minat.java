package com.example.scholaedu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class result_mentor_minat extends AppCompatActivity {
    ArrayList<String> nama_t=new ArrayList<String>();
    ArrayList<String> biaya_t=new ArrayList<String>();
    ArrayList<String> kategori_t=new ArrayList<String>();

    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    ArrayList<Mahasiswa> mahasiswaArrayList;

    private TextView GetNIM, GetNama, GetJurusan, toolbarText_;
    private FirebaseAuth auth;
    private String GetUserID;

    private DatabaseReference mDatabase;

    GridView grid_minat;
    //Tutor_Minat_Adapter costumAdapter;
    ArrayList<String> nama_p = new ArrayList<String>();
    ArrayList<String> biaya_p = new ArrayList<String>();
    ArrayList<String> kategori_p = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_mentor_minat);
        toolbarText_=findViewById(R.id.toolbar_text_pencarian_mentor_minat);
        Intent minat = getIntent();
        String kategori = minat.getStringExtra("kategori");
        String mode = minat.getStringExtra("model belajar");
        final String lokasi = minat.getStringExtra("lokasi");

        //Toast.makeText(this,  kategori , Toast.LENGTH_SHORT).show();
        String path = "operation/minat/";
        path = path + kategori;
        mDatabase = FirebaseDatabase.getInstance().getReference(path);


        auth = FirebaseAuth.getInstance();

        //Mendapatkan User ID dari akun yang terautentikasi
        FirebaseUser user = auth.getCurrentUser();
        GetUserID = user.getUid();

        mahasiswaArrayList = new ArrayList<>();
        if (lokasi.equalsIgnoreCase("lokasi tidak dipilih")) {
            ValueEventListener valueEventListener = new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        for (DataSnapshot ds : snapshot.getChildren()) {
                            String kategori = ds.child("Kategori").getValue(String.class);
                            String biaya_video_conference = ds.child("Video Call").getValue(String.class);
                            String nama = ds.child("Name").getValue(String.class);
                            mahasiswaArrayList.add(new Mahasiswa(nama, kategori, biaya_video_conference));
                            Toast.makeText(getApplicationContext(),biaya_video_conference, Toast.LENGTH_SHORT).show();
                            adapter.notifyDataSetChanged();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(),"kosong", Toast.LENGTH_SHORT).show();
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
                            if (lokasi_.equalsIgnoreCase(lokasi)) {
                                String kategori = ds.child("Kategori").getValue(String.class);
                                String biaya_tatap_muka = ds.child("Tatap Muka").getValue(String.class);
                                String nama = ds.child("Name").getValue(String.class);
                                mahasiswaArrayList.add(new Mahasiswa(nama, kategori, biaya_tatap_muka));
                                adapter.notifyDataSetChanged();
                            }  else {
                                Intent out = new Intent(getApplicationContext(), NotFound.class);
                                startActivity(out);
                            }
                        }
                    } else {

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

        adapter = new MahasiswaAdapter(mahasiswaArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(result_mentor_minat.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

    }



}
