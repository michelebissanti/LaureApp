package it.uniba.dib.sms222320.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import it.uniba.dib.sms222320.R;
import it.uniba.dib.sms222320.activities.admin.HomeActivity;

public class SignedInActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signed_in);

        // Firebase Realtime Instance
        mDatabase = FirebaseDatabase.getInstance("https://laureapp-fbf2b-default-rtdb.europe-west1.firebasedatabase.app").getReference();

        // Fetch uid currentUser
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        String uid = mAuth.getCurrentUser().getUid();

        // Search Role by ID
        mDatabase.child("users").child(uid).child("role").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error Getting Data", task.getException());
                } else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));

                    switch(task.getResult().getValue().toString()) {
                        case "ADMIN":
                            startActivity(new Intent(SignedInActivity.this, it.uniba.dib.sms222320.activities.admin.HomeActivity.class));
                            break;
                        case "STUDENT":
                            startActivity(new Intent(SignedInActivity.this, it.uniba.dib.sms222320.activities.student.HomeActivity.class));
                            break;
                        case "PROFESSOR":
                            startActivity(new Intent(SignedInActivity.this, it.uniba.dib.sms222320.activities.professor.HomeActivity.class));
                            break;
                    }
                }
            }
        });

        //FirebaseAuth.getInstance().signOut();
    }

}