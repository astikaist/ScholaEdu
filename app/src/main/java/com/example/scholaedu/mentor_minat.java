package com.example.scholaedu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import static android.view.View.VISIBLE;
import static android.view.View.INVISIBLE;

public class mentor_minat extends Fragment {
    String kategori_, model_belajar_, lokasi_minat_, cek_active;
    private TextView lokasi_text_minat;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.mentor_minat, container, false);
        //spinner
        Spinner spinner_kategori = (Spinner) view.findViewById(R.id.spinner_kategori);
        final Spinner spinner_model_belajar = (Spinner) view.findViewById(R.id.spinner_model_belajar);
        final Spinner spinner_lokasi_minat = (Spinner) view.findViewById(R.id.spinner_lokasi_minat);
        //button
        Button find_mentor_minat = (Button) view.findViewById(R.id.mentor_minat);
        //textview
        lokasi_text_minat = (TextView) view.findViewById(R.id.lokasi_minat_text);
        //kategori
        String [] values_kategori =
                {"Musik","Olahraga"};

        String [] values_model_belajar =
                {"Tatap Muka","Video Conference"};

        String [] values_lokasi_minat =
                {"Solo","Yogya", "Boyolali"};


        ArrayAdapter<String> adapter_model_belajar_minat = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, values_lokasi_minat);
        adapter_model_belajar_minat.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner_lokasi_minat.setAdapter(adapter_model_belajar_minat);
        spinner_lokasi_minat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        lokasi_minat_ = "Solo";
                        break;
                    case 1:
                        lokasi_minat_ = "Yogya";
                        break;
                    case 2:
                        lokasi_minat_ = "Boyolali";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //spinner kategori
        ArrayAdapter<String> adapter_kategori = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, values_kategori);
        adapter_kategori.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner_kategori.setAdapter(adapter_kategori);
        spinner_kategori.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        kategori_ = "musik";
                        break;
                    case 1:
                        kategori_ = "olahraga";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //spinner model belajar
        ArrayAdapter<String> adapter_model_belajar = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, values_model_belajar);
        adapter_model_belajar.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner_model_belajar.setAdapter(adapter_model_belajar);
        spinner_model_belajar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        lokasi_text_minat.setVisibility(VISIBLE);
                        spinner_lokasi_minat.setVisibility(VISIBLE);
                        cek_active = "on";
                        model_belajar_ = "Tatap Muka";
                        break;

                    case 1:
                        cek_active = "off";
                        lokasi_text_minat.setVisibility(INVISIBLE);
                        spinner_lokasi_minat.setVisibility(INVISIBLE);
                        model_belajar_ = "Video Conference";
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        find_mentor_minat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_minat = new Intent(getActivity(), result_mentor_minat.class);
                go_minat.putExtra("kategori", kategori_);
                go_minat.putExtra("model belajar", model_belajar_);
                if (cek_active == "on") {
                    go_minat.putExtra("lokasi", lokasi_minat_);
                } else {
                    go_minat.putExtra("lokasi", "lokasi tidak dipilih");
                }
                startActivity(go_minat);
            }
        });
        return view;
    }
}
