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

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import static android.view.View.VISIBLE;

public class FindMentorFragment_1 extends Fragment {
    private mentor_minat minat;
    private mentor_akademik akademik;
    private TextView toolbarText_;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.mentorpick, container, false);
        toolbarText_ = view.findViewById(R.id.toolbar_text_find_mentor);
        String [] tipe_belajar =
                {"Akademik","Minat Bakat"};
        Spinner spinner_pick_mentor = (Spinner) view.findViewById(R.id.spinnepick_mentor);
        ArrayAdapter<String> adapter_smp = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, tipe_belajar);
        adapter_smp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner_pick_mentor.setAdapter(adapter_smp);
        spinner_pick_mentor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position) {
                    case 0:
                        akademik = new mentor_akademik();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_q1, akademik)
                                .commit();
                        // Whatever you want to happen when the first item gets selected
                        break;
                    case 1:
                        minat = new mentor_minat();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_q1, minat)
                                .commit();
                        // Whatever you want to happen when the second item gets selected
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });
        return view;
    }
}

