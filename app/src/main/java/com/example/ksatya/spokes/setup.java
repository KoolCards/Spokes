package com.example.ksatya.spokes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class setup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        final Map<String, Boolean> preferences = new HashMap<>();





        Button setup = (Button) findViewById(R.id.setup);
        setup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(setup.this, addfriends.class));
            }
        });
    }

    private void addUserPreference(String preference, String userId) {
        //final DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users/" + userId + "/preferences/platforms/");
        //userRef.updateChildren(new Map<preference, true>);
    }
}