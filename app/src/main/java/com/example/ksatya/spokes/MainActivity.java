package com.example.ksatya.spokes;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button spokes = (Button) findViewById(R.id.spokes);
        spokes.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                createSignInIntent();
            }
        });


    }

    public void createSignInIntent() {
        // [START auth_fui_create_intent]
        // Choose authentication providers
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.FacebookBuilder().build());

        // Create and launch sign-in intent
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN);
        // [END auth_fui_create_intent]
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                writeUserData(user.getUid(), user.getDisplayName(), user.getEmail());
                final String uId = user.getUid();
                final DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users/" + uId);
                userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    boolean hasChild = false;
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        if (!snapshot.hasChild("preferences")) {
                            startActivity(new Intent(MainActivity.this, setup.class));
                        } else {
                            startActivity(new Intent(MainActivity.this, addfriends.class));
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                    }
                });
            } else {

            }
        }
    }

    private void isSetup(String userId) {

    }

    private void writeUserData(String userId, String name, String email) {
        final String uName = name;
        final String uEmail = email;
        final String uId = userId;
        final DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("users/");
        usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (!snapshot.hasChild(uId)) {
                    Map<String, Object> childUpdates = new HashMap<>();
                    childUpdates.put("name", uName);
                    childUpdates.put("email", uEmail);
                    usersRef.setValue(childUpdates);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });

    }

}
