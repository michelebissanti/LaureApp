package it.uniba.dib.sms222320.activities.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import it.uniba.dib.sms222320.R;
import it.uniba.dib.sms222320.activities.LoginActivity;
import it.uniba.dib.sms222320.activities.SignedInActivity;
import it.uniba.dib.sms222320.databinding.MainStudentBinding;
import it.uniba.dib.sms222320.models.Professor;
import it.uniba.dib.sms222320.models.Student;
import it.uniba.dib.sms222320.utils.ScanQRActivity;

public class MainActivity extends AppCompatActivity {

    MainStudentBinding binding;
    private FirebaseAuth mAuth;

    private EditText formName, formSurname, formDateBirth, formCity, formAddress, formTelephone;

    private TextView usernameText, matricolaText, welcomeText, corsoDiLaureaText, codiceTesiScansionato;

    private DatabaseReference mDatabase;

    private Button modProfile;

    private static final int CODE_TESI = 31;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MainStudentBinding.inflate(getLayoutInflater());
        mAuth = FirebaseAuth.getInstance();
        setContentView(binding.getRoot());

        mDatabase = FirebaseDatabase.getInstance("https://laureapp-fbf2b-default-rtdb.europe-west1.firebasedatabase.app").getReference();

        //Profile Fragment
        usernameText = findViewById(R.id.usernameText_student);
        corsoDiLaureaText = findViewById(R.id.corsoText_student);
        matricolaText = findViewById(R.id.matricolaText_student);

        formName = findViewById(R.id.formName_student);
        formSurname = findViewById(R.id.formSurname_student);
        formDateBirth = findViewById(R.id.formDateBirth_student);
        formCity = findViewById(R.id.formCity_student);
        formAddress = findViewById(R.id.formAddress_student);
        formTelephone = findViewById(R.id.formTelephone_student);

        //Tesi Fragment
        codiceTesiScansionato = findViewById(R.id.codiceTesiScansionato);

        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch(item.getItemId()) {
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.profile:
                    profileClicked();
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

    private void profileClicked() {
        mDatabase.child("users").child(mAuth.getCurrentUser().getUid()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error Getting Data", task.getException());
                } else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));

                    Student user = task.getResult().getValue(Student.class);

                    usernameText = findViewById(R.id.usernameText_student);
                    matricolaText = findViewById(R.id.matricolaText_student);
                    corsoDiLaureaText = findViewById(R.id.corsoText_student);

                    formName = findViewById(R.id.formName_student);
                    formSurname = findViewById(R.id.formSurname_student);
                    formDateBirth = findViewById(R.id.formDateBirth_student);
                    formCity = findViewById(R.id.formCity_student);
                    formAddress = findViewById(R.id.formAddress_student);
                    formTelephone = findViewById(R.id.formTelephone_student);


                    formName.setEnabled(false);
                    formSurname.setEnabled(false);
                    formDateBirth.setEnabled(false);
                    formCity.setEnabled(false);
                    formAddress.setEnabled(false);
                    formTelephone.setEnabled(false);


                    usernameText.setText(user.getUsername());
                    matricolaText.setText(user.getMatricola());
                    corsoDiLaureaText.setText(user.getCorsoDiLaurea());

                    formName.setText(user.getName());
                    formSurname.setText(user.getSurname());
                    formDateBirth.setText(user.getBirthDate());
                    formCity.setText(user.getCity());
                    formAddress.setText(user.getAddress());
                    formTelephone.setText(user.getTelephone());

                }
            }
        });
    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();

    }

    //Profile Fragment
    public void onLogOutClick(View view) {
        mAuth.signOut();
        Toast.makeText(this, getString(R.string.logOutSuccess), Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    public void onModProfileClick(View view) {
        modProfile = findViewById(R.id.modProfileBtn_student);

        if(modProfile.getText().equals("Modifica Profilo")) {

            modProfile.setText("Salva Modifiche");
            formName.setEnabled(true);
            formSurname.setEnabled(true);
            formDateBirth.setEnabled(true);
            formCity.setEnabled(true);
            formAddress.setEnabled(true);
            formTelephone.setEnabled(true);

        } else if (modProfile.getText().equals("Salva Modifiche")) {

            modProfile.setText("Modifica Profilo");
            formName.setEnabled(false);
            formSurname.setEnabled(false);
            formDateBirth.setEnabled(false);
            formCity.setEnabled(false);
            formAddress.setEnabled(false);
            formTelephone.setEnabled(false);

            mDatabase.child("users").child(mAuth.getUid()).child("name").setValue(formName.getText().toString());
            mDatabase.child("users").child(mAuth.getUid()).child("surname").setValue(formSurname.getText().toString());
            mDatabase.child("users").child(mAuth.getUid()).child("birthDate").setValue(formDateBirth.getText().toString());
            mDatabase.child("users").child(mAuth.getUid()).child("city").setValue(formCity.getText().toString());
            mDatabase.child("users").child(mAuth.getUid()).child("address").setValue(formAddress.getText().toString());
            mDatabase.child("users").child(mAuth.getUid()).child("telephone").setValue(formTelephone.getText().toString());
            Toast.makeText(it.uniba.dib.sms222320.activities.student.MainActivity.this, "Modifiche apportate con Successo.",
                    Toast.LENGTH_LONG).show();
        }


    }

    //Tesi Fragment
    public void onScanQRClick(View view) {
        Intent intent = new Intent(MainActivity.this, ScanQRActivity.class);
        startActivityForResult(intent, CODE_TESI);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODE_TESI && resultCode == this.RESULT_OK) {
            codiceTesiScansionato = findViewById(R.id.codiceTesiScansionato);
            codiceTesiScansionato.setText("Il codice scansionato è: " + data.getStringExtra("codiceTesiScansionato"));
        }
    }


}