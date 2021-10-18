package org.techtown.dongseomap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag_7uit extends Fragment {
    private View view;

    public static Frag_7uit newlnstance(){
        Frag_7uit frag7uit = new Frag_7uit();
        return frag7uit;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_7uit, container, false);

        return view;
    }
}
