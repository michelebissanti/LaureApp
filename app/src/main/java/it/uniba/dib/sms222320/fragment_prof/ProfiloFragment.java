package it.uniba.dib.sms222320.fragment_prof;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.*;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import it.uniba.dib.sms222320.LoginActivity;
import it.uniba.dib.sms222320.MainProfActivity;
import it.uniba.dib.sms222320.R;

public class ProfiloFragment extends Fragment {

    public ProfiloFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profilo, container, false);

        Button esciBtn = view.findViewById(R.id.logout);

        // Set on Click Listener on Sign-in button
        esciBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                FirebaseAuth.getInstance().signOut();

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    Log.d("1", "NON FUNZIONA");
                } else {
                    Log.d("1", "mi sono scollegato");
                }
            }
        });

        return view;
    }
}
