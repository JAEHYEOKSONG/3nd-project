package org.techtown.dongseomap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag_5uit extends Fragment {
    private View view;

    public static Frag_5uit newlnstance(){
        Frag_5uit frag5uit = new Frag_5uit();
        return frag5uit;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_5uit, container, false);

        return view;
    }
}
