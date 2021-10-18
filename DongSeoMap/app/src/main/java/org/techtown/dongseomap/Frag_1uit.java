package org.techtown.dongseomap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag_1uit extends Fragment {
    private View view;

    public static Frag_1uit newlnstance(){
        Frag_1uit frag1uit = new Frag_1uit();
        return frag1uit;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_1uit, container, false);

        return view;
    }
}
