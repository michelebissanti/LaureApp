package it.uniba.dib.sms222320.fragment_prof;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.*;
import androidx.fragment.app.Fragment;

import it.uniba.dib.sms222320.R;

public class SegnalazioniFragment extends Fragment {

    public SegnalazioniFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_segnalazioni, container, false);
    }
}
