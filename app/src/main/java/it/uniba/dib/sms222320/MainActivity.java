package it.uniba.dib.sms222320;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.os.Bundle;
import android.view.MenuItem;

import it.uniba.dib.sms222320.fragment_prof.HomeFragment;
import it.uniba.dib.sms222320.fragment_prof.ProfiloFragment;
import it.uniba.dib.sms222320.fragment_prof.RicevimentiFragment;
import it.uniba.dib.sms222320.fragment_prof.SegnalazioniFragment;
import it.uniba.dib.sms222320.fragment_prof.TesiFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);

    }

    HomeFragment homeFragment = new HomeFragment();
    ProfiloFragment profiloFragment = new ProfiloFragment();
    RicevimentiFragment ricevimentiFragment = new RicevimentiFragment();
    SegnalazioniFragment segnalazioniFragment = new SegnalazioniFragment();
    TesiFragment tesiFragment = new TesiFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                return true;

            case R.id.profilo:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, profiloFragment).commit();
                return true;

            case R.id.ricevimenti:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, ricevimentiFragment).commit();
                return true;

            case R.id.segnalazioni:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, segnalazioniFragment).commit();
                return true;

            case R.id.tesi:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, tesiFragment).commit();
                return true;
        }
        return false;
    }
}
