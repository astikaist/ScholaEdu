package com.example.scholaedu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class pembayaran extends AppCompatActivity {
    TextView nama_, biaya_, keahlian_, toolbartext_;
    Spinner anggota, pembayaran;
    String anggota_nilai, pembayaran_nilai;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);
        Intent minat = getIntent();
        String nama = minat.getStringExtra("nama");
        String biaya = minat.getStringExtra("biaya");
        String keahlian = minat.getStringExtra("keahlian");

        toolbartext_=findViewById(R.id.toolbar_text_pembayaran);
        nama_ = findViewById(R.id.text_payment_nama);
        biaya_ = findViewById(R.id.text_payment_harga);
        keahlian_ = findViewById(R.id.text_payment_keahlian);

        anggota = findViewById(R.id.spinner_payment_anggota);
        pembayaran = findViewById(R.id.spinner_payment_metode);

        nama_.setText(nama);
        biaya_.setText(biaya);
        keahlian_.setText(keahlian);

        String [] values_anggota = {"1", "2", "3", "4"};
        String [] values_metode = {"Transfer Bank", "Gopay", "OVO", "LinkAja"};
        //spinner anggota
        ArrayAdapter<String> adapter_anggota = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, values_anggota);
        adapter_anggota.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        anggota.setAdapter(adapter_anggota);
        anggota.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        anggota_nilai = "1";
                        break;
                    case 1:
                        anggota_nilai = "2";
                        break;
                    case 2:
                        anggota_nilai = "3";
                        break;
                    case 3:
                        anggota_nilai = "4";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //spinner pembayaran
        ArrayAdapter<String> adapter_pembayaran = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, values_metode);
        adapter_pembayaran.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        pembayaran.setAdapter(adapter_pembayaran);
        pembayaran.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        pembayaran_nilai = "Transfer Bank";
                        break;
                    case 1:
                        pembayaran_nilai = "GoPay";
                        break;
                    case 2:
                        pembayaran_nilai = "OVO";
                        break;
                    case 3:
                        pembayaran_nilai = "LinkAja";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //button
        Button lanjut = findViewById(R.id.button_payment_pembayaran);
        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent out = new Intent(v.getContext(), confirmed.class);
                startActivity(out);
            }
        });



    }
}
