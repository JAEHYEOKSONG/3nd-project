package org.techtown.dongseomap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag_8uit extends Fragment {
    private View view;

    public static Frag_8uit newlnstance(){
        Frag_8uit frag8uit = new Frag_8uit();
        return frag8uit;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_8uit, container, false);

        return view;
    }
}
