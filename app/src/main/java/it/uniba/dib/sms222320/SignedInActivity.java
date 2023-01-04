package it.uniba.dib.sms222320;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

import it.uniba.dib.sms222320.models.User;

public class SignedInActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    TextView username2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signed_in);

        username2 = (TextView) findViewById(R.id.username2);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        mDatabase = FirebaseDatabase.getInstance("https://laureapp-fbf2b-default-rtdb.europe-west1.firebasedatabase.app").getReference();

        mDatabase.child("users").child(mAuth.getUid()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {

            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    Log.d("firebase", String.valueOf(task.getResult().getValue()));

                    String username = ((Map)task.getResult().getValue()).get("username").toString();
                    String password = ((Map)task.getResult().getValue()).get("password").toString();
                    String email = ((Map)task.getResult().getValue()).get("email").toString();

                    username2.setText(username);
                }
            }
        });
    }

}