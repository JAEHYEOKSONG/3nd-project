package org.techtown.dongseomap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag_4uit extends Fragment {
    private View view;

    public static Frag_4uit newlnstance(){
        Frag_4uit frag4uit = new Frag_4uit();
        return frag4uit;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_4uit, container, false);

        return view;
    }
}
