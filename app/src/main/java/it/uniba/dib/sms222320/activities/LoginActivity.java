package it.uniba.dib.sms222320.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import it.uniba.dib.sms222320.R;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private ImageView logo;
    private EditText inputEmail, inputPassword;
    private TextView noAccount;
    private Button loginButton, signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the view now
        setContentView(R.layout.activity_login);

        inputEmail = (EditText)findViewById(R.id.email);
        inputPassword = (EditText)findViewById(R.id.password);

        loginButton = (Button)findViewById(R.id.loginButton);
        signupButton = (Button)findViewById(R.id.signupButton);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();

        // if user logged in, go to sign-in screen
        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(this, SignedInActivity.class));
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void onLoginClick(View view) {
        String email = inputEmail.getText().toString();
        final String password = inputPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            inputPassword.setError(getString(R.string.minimum_password));
            Toast.makeText(LoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
            return;
        }

        //authenticate user
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            // there was an error
                            Toast.makeText(LoginActivity.this, "Authentication failed. Retry",
                                    Toast.LENGTH_LONG).show();
                            Log.e("MyTag", task.getException().toString());

                        } else {
                            Intent intent = new Intent(LoginActivity.this, SignedInActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
    }

    public void onSignupClick(View view)  {
        startActivity(new Intent(this, RegisterActivity.class));
    }
}