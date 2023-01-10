package it.uniba.dib.sms222320.activities.professor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import it.uniba.dib.sms222320.R;
import it.uniba.dib.sms222320.activities.LoginActivity;
import it.uniba.dib.sms222320.databinding.MainProfessorBinding;

public class MainActivity extends AppCompatActivity {

    MainProfessorBinding binding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainProfessorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mAuth = FirebaseAuth.getInstance();

        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch(item.getItemId()) {
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileFragment());
                    break;
                case R.id.ricevimenti:
                    replaceFragment(new RicevimentiFragment());
                    break;
                case R.id.segnalazioni:
                    replaceFragment(new SegnalazioniFragment());
                    break;
                case R.id.tesi:
                    replaceFragment(new TesiFragment());
                    break;
            }

            return true;
        });

    }


    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();

    }

    public void onLogOutClick(View view) {
        mAuth.signOut();
        Toast.makeText(this, getString(R.string.logOutSuccess), Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}