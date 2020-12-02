package com.example.scholaedu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class GrupFragment extends Fragment {
    private TextView toolbarText_;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.grup_discussion, container, false);
        toolbarText_ = root.findViewById(R.id.toolbar_text_group_discussion);
        return root;
    }
}
