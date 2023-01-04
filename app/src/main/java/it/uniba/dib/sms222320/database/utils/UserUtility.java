package it.uniba.dib.sms222320.database.utils;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import it.uniba.dib.sms222320.models.User;

public class UserUtility {

    private DatabaseReference mDatabase;

    public UserUtility() {
        // [START initialize_database_ref]
        mDatabase = FirebaseDatabase.getInstance("https://laureapp-fbf2b-default-rtdb.europe-west1.firebasedatabase.app").getReference();
        // [END initialize_database_ref]
    }

    public void writeNewUser(User user) {
        String key = mDatabase.child("users").push().getKey();

        mDatabase.child("users").child(key).setValue(user);
    }

}