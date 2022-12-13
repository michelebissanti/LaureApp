package it.uniba.dib.sms222320;

import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;

import it.uniba.dib.sms222320.eccezioni.EccezioniPersonalizzate;
import it.uniba.dib.sms222320.soggetti.Professore;

public class RegistrazioneProfActivity extends AppCompatActivity {

    private EditText emailTextView, passwordTextView, matricolaTextView, nomeTextView, cognomeTextView, nascitaTextView, cittaTextView, viaTextView, telefonoTextView;
    private Button registratiBtn;
    private ProgressBar progressbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione_prof);

        // taking FirebaseAuth instance
        mAuth = FirebaseAuth.getInstance();

        // initialising all views through id defined above
        emailTextView = findViewById(R.id.email);
        passwordTextView = findViewById(R.id.passwd);
        matricolaTextView = findViewById(R.id.matricola);
        nomeTextView = findViewById(R.id.nome);
        cognomeTextView = findViewById(R.id.cognome);
        nascitaTextView = findViewById(R.id.nascita);
        cittaTextView = findViewById(R.id.citta);
        viaTextView = findViewById(R.id.residenza);
        telefonoTextView = findViewById(R.id.telefono);

        registratiBtn = findViewById(R.id.btnregister);
        progressbar = findViewById(R.id.progressbar);

        // Set on Click Listener on Registration button
        registratiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                registerNewUser();
            }
        });
    }

    private void registerNewUser()
    {

        // show the visibility of progress bar to show loading
        progressbar.setVisibility(View.VISIBLE);

        // Take the value of two edit texts in Strings
        String email, password;
        email = emailTextView.getText().toString();
        password = passwordTextView.getText().toString();

        // Validations for input email and password
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                            "Inserisci una mail.",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                            "Inserisci una password",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }

        // create new user or register new user
        mAuth
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(),
                                            "Registrazione completata!",
                                            Toast.LENGTH_LONG)
                                    .show();

                            //istanzio il nuovo prof
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            if (user != null) {
                                String data_nascita_stringa = nascitaTextView.getText().toString();
                                //qui va la data convertita in localdate
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                LocalDate data_nascita = LocalDate.parse(data_nascita_stringa, formatter);

                                try {
                                    Professore prof = new Professore(user.getUid(), nomeTextView.getText().toString(), cognomeTextView.getText().toString(), data_nascita ,cittaTextView.getText().toString(), viaTextView.getText().toString(), telefonoTextView.getText().toString(), emailTextView.getText().toString(), matricolaTextView.getText().toString());

                                    //TODO adesso andrebbe caricata questa istanza su firebase
                                } catch (EccezioniPersonalizzate e) {
                                    e.printStackTrace();
                                }

                            } else {
                                // No user is signed in
                                //problema
                            }

                            // hide the progress bar
                            progressbar.setVisibility(View.GONE);

                            // if the user created intent to login activity
                            Intent intent
                                    = new Intent(RegistrazioneProfActivity.this,
                                    MainProfActivity.class);
                            startActivity(intent);
                        }
                        else {

                            // Registration failed
                            Toast.makeText(
                                            getApplicationContext(),
                                            "Registazione fallita, per favore riprova.",
                                            Toast.LENGTH_LONG)
                                    .show();

                            // hide the progress bar
                            progressbar.setVisibility(View.GONE);
                        }
                    }
                });
    }
}
