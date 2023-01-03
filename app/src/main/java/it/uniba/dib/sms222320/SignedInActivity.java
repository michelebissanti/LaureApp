package it.uniba.dib.sms222320;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class SignedInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signed_in);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        System.out.println("********** LOG :" + mAuth.getCurrentUser().getEmail());
    }
}