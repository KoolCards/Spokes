package com.example.ksatya.spokes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class notifications extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        ImageButton addfriend = (ImageButton) findViewById(R.id.addfriend);
        addfriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(notifications.this, addfriends.class));
            }
        });

        ImageButton activityfeed = (ImageButton) findViewById(R.id.menu);
        activityfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(notifications.this, activityfeed.class));
            }
        });

        ImageButton notifications = (ImageButton) findViewById(R.id.notifications);
        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(notifications.this, notifications.class));
            }
        });

        ImageButton gotopoke = (ImageButton) findViewById(R.id.gotopoke);
        gotopoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(notifications.this, friends2.class));
            }
        });
    }
}
