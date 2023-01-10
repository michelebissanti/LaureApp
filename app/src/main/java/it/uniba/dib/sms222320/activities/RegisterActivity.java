package it.uniba.dib.sms222320.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import it.uniba.dib.sms222320.R;
import it.uniba.dib.sms222320.database.utils.UserUtility;
import it.uniba.dib.sms222320.models.Role;
import it.uniba.dib.sms222320.models.User;

public class RegisterActivity extends AppCompatActivity {

    private EditText inputUsername, inputEmail, inputPassword, inputName, inputSurname, inputBirthDate, inputCity, inputAddress, inputTelephone;
    private Spinner roleSpinner;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Database instance
        mAuth = FirebaseAuth.getInstance();

        // Roles Spinner
        roleSpinner = findViewById(R.id.role);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.roles, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        roleSpinner.setAdapter(adapter);
        roleSpinner.setPrompt(getString(R.string.role_label));

        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        inputUsername = (EditText) findViewById(R.id.username);

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

    public void onRegisterClicked(View view) {
        final String username = inputUsername.getText().toString().trim();
        final String email = inputEmail.getText().toString().trim();
        final String password = inputPassword.getText().toString().trim();
        final String name = inputName.getText().toString().trim();
        final String surname = inputSurname.getText().toString().trim();
        final String birthDate = inputBirthDate.getText().toString().trim();
        final String city = inputCity.getText().toString().trim();
        final String address = inputAddress.getText().toString().trim();
        final String telephone = inputTelephone.getText().toString().trim();


        if (TextUtils.isEmpty(username)) {
            Toast.makeText(getApplicationContext(), "Enter username!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getApplicationContext(), "Enter name!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(surname)) {
            Toast.makeText(getApplicationContext(), "Enter surname!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(birthDate)) {
            Toast.makeText(getApplicationContext(), "Enter birth date!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(city)) {
            Toast.makeText(getApplicationContext(), "Enter city!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(address)) {
            Toast.makeText(getApplicationContext(), "Enter address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(telephone)) {
            Toast.makeText(getApplicationContext(), "Enter telephone number!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            return;
        }

        //create user
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(RegisterActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_LONG).show();
                            Log.e("MyTag", task.getException().toString());
                        } else {
                            UserUtility userUtility = new UserUtility();

                            Role role = null;

                            switch(roleSpinner.getSelectedItemPosition()) {
                                case 0:
                                    role = Role.STUDENT;
                                    break;
                                case 1:
                                    role = Role.PROFESSOR;
                                    break;
                                case 2:
                                    role = Role.ADMIN;
                                    break;
                                default:
                                    ((TextView)roleSpinner.getSelectedView()).setError(getString(R.string.role_error));
                                    return;
                            }

                            User user = new User(role, username, email, password, name, surname, birthDate, city, address, telephone);
                            userUtility.writeNewUser(user);

                            startActivity(new Intent(RegisterActivity.this, SignedInActivity.class));
                            finish();
                        }
                    }
                });
    }

    public void onLoginClicked(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
}

