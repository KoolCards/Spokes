package com.example.ksatya.spokes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addfriends extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfriends);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users/" + user.getUid() + "/friends");

        Button search = (Button) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText emailId = (EditText) findViewById(R.id.searchEmail);
                String emailUserId = emailId.getText().toString();
                userRef.setValue(emailUserId);

            }
        });

        ImageButton addfriend = (ImageButton) findViewById(R.id.addfriend);
        addfriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(addfriends.this, addfriends.class));
            }
        });

        ImageButton activityfeed = (ImageButton) findViewById(R.id.menu);
        activityfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(addfriends.this, activityfeed.class));
            }
        });

        ImageButton notifications = (ImageButton) findViewById(R.id.notifications);
        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(addfriends.this, notifications.class));
            }
        });

        ImageButton gotopoke = (ImageButton) findViewById(R.id.gotopoke);
        gotopoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(addfriends.this, friends2.class));
            }
        });
    }
}
