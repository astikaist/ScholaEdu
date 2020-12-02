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

public class mentor_akademik extends Fragment {
    String jenjang_, kelas_, mode_, pelajaran_, lokasi_, cek_active, kelas_temp, pelajaran_temp;
    Button findmentor;
    private TextView lokasi_text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.mentor, container, false);
        lokasi_text = (TextView) view.findViewById(R.id.text_lokasi);
        Spinner spinner = (Spinner) view.findViewById(R.id.spinner0_jenjang);
        final Spinner spinner1 = (Spinner) view.findViewById(R.id.spinner1_kelas);
        Spinner spinner2 = (Spinner) view.findViewById(R.id.spinner2_metode);
        final Spinner spinner3 = (Spinner) view.findViewById(R.id.spinner_pembelajaran);
        final Spinner spinner4 = (Spinner) view.findViewById(R.id.spinner_lokasi);
        findmentor = view.findViewById(R.id.buttonmentor);
        String [] values =
                {"SD","SMP","SMA"};
        String [] values_metode =
                {"Chat","Video Call","Tatap Muka"};
        final String [] values_sd =
                {"1","2","3", "4", "5", "6"};
        final String [] values_pembelajaran_sd =
                {"Matematika","IPA", "Bahasa Inggris"};
        final String [] values_smp =
                {"1","2","3"};
        final String [] values_pembelajaran_smp =
                {"Matematika","Fisika", "Biologi"};
        final String [] values_sma =
                {"1","2","3"};
        final String [] values_pembelajaran_sma =
                {"Matematika","Fisika", "Biologi", "Kimia"};
        final String [] lokasi =
                {"Surakarta","Yogya", "Jakarta", "Semarang"};


        //spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        lokasi_ = "SD";
                        jenjang_ = "SD";
                        ArrayAdapter<String> adapter_kelas = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, values_sd);
                        adapter_kelas.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                        spinner1.setAdapter(adapter_kelas);
                        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position) {
                                    case 0:
                                        kelas_ = "1";
                                        break;
                                    case 1:
                                        kelas_ = "2";
                                        break;
                                    case 2:
                                        kelas_ = "3";
                                        break;
                                    case 3:
                                        kelas_ = "4";
                                        break;
                                    case 4:
                                        kelas_ = "5";
                                        break;
                                    case 5:
                                        kelas_ = "6";
                                        break;
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                        ArrayAdapter<String> adapter_pelajaran_sd = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, values_pembelajaran_sd);
                        adapter_pelajaran_sd.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                        spinner3.setAdapter(adapter_pelajaran_sd);
                        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position) {
                                    case 0:
                                        pelajaran_ = "Matematika";
                                        break;
                                    case 1:
                                        pelajaran_ = "IPA";
                                        break;
                                    case 2:
                                        pelajaran_ = "Bahasa Inggris";
                                        break;
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });

                        break;
                    case 1:
                        jenjang_ = "SMP";
                        ArrayAdapter<String> adapter_kelas_smp = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, values_smp);
                        adapter_kelas_smp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                        spinner1.setAdapter(adapter_kelas_smp);
                        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position) {
                                    case 0:
                                        kelas_ = "1";
                                        break;
                                    case 1:
                                        kelas_ = "2";
                                        break;
                                    case 2:
                                        kelas_ = "3";
                                        break;
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                        ArrayAdapter<String> adapter_pelajaran_smp = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, values_pembelajaran_smp);
                        adapter_pelajaran_smp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                        spinner3.setAdapter(adapter_pelajaran_smp);
                        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position) {
                                    case 0:
                                        pelajaran_ = "Matematika";
                                        break;
                                    case 1:
                                        pelajaran_ = "FISIKA";
                                        break;
                                    case 2:
                                        pelajaran_ = "BIOLOGI";
                                        break;
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                        break;
                    case 2:
                        jenjang_ = "SMA";
                        ArrayAdapter<String> adapter_kelas_sma = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, values_sma);
                        adapter_kelas_sma.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                        spinner1.setAdapter(adapter_kelas_sma);
                        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position) {
                                    case 0:
                                        kelas_ = "1";
                                        break;
                                    case 1:
                                        kelas_ = "2";
                                        break;
                                    case 2:
                                        kelas_ = "3";
                                        break;
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                        ArrayAdapter<String> adapter_pelajaran_sma = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, values_pembelajaran_sma);
                        adapter_pelajaran_sma.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                        spinner3.setAdapter(adapter_pelajaran_sma);
                        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position) {
                                    case 0:
                                        pelajaran_ = "Matematika";
                                        break;
                                    case 1:
                                        pelajaran_ = "BIOLOGI";
                                        break;
                                    case 2:
                                        pelajaran_ = "FISIKA";
                                        break;
                                    case 3:
                                        pelajaran_ = "KIMIA";
                                        break;
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //spinner 2
        ArrayAdapter<String> adapter_metode = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values_metode);
        adapter_metode.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner2.setAdapter(adapter_metode);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        mode_ = "Chat";
                        lokasi_text.setVisibility(INVISIBLE);
                        spinner4.setVisibility(INVISIBLE);
                        cek_active = "off";
                        break;
                    case 1:
                        mode_ = "Video Call";
                        lokasi_text.setVisibility(INVISIBLE);
                        spinner4.setVisibility(INVISIBLE);
                        cek_active = "off";
                        break;
                    case 2:
                        mode_ = "Tatap Muka";
                        lokasi_text.setVisibility(VISIBLE);
                        spinner4.setVisibility(VISIBLE);
                        cek_active = "on";
                        ArrayAdapter<String> adapter_lokasi = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, lokasi);
                        adapter_lokasi.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                        spinner4.setAdapter(adapter_lokasi);
                        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                switch (position) {
                                    case 0:
                                        lokasi_ = "Surakarta";
                                        break;
                                    case 1:
                                        lokasi_ = "Yogya";
                                        break;
                                    case 2:
                                        lokasi_ = "Jakarta";
                                        break;
                                    case 3:
                                        lokasi_ = "Semarang";
                                        break;
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        findmentor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_ = new Intent(getActivity(), resultmentor.class);
                go_.putExtra("jenjang", jenjang_);

                go_.putExtra("kelas", kelas_);

                go_.putExtra("mode", mode_);
                go_.putExtra("pelajaran", pelajaran_);
                if (cek_active == "on") {
                    go_.putExtra("lokasi", lokasi_);
                } else {
                    go_.putExtra("lokasi", "Tidak ada lokasi");
                }
                startActivity(go_);
            }
        });
        //spinner.setOnItemSelectedListener(this);
        return view;
    }
}
