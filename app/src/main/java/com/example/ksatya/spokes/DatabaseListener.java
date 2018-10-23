package com.example.ksatya.spokes;

import android.content.Intent;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.Map;

import static android.support.v4.content.ContextCompat.startActivity;

public class DatabaseListener implements ValueEventListener {

    String child;
    boolean exists = false;
    DatabaseReference userRef;
    String childData;
    Map<String,Object> mapUpdated;

    public DatabaseListener (String newChild, Map<String,Object> newMapUpdated, DatabaseReference newUserRef){
        child = newChild;
        mapUpdated = newMapUpdated;
        userRef = newUserRef;
    }

    public DatabaseListener (String newChild, String newChildData, DatabaseReference newUserRef){
        child = newChild;
        childData = newChildData;
        userRef = newUserRef;
    }
    @Override
    public void onDataChange(DataSnapshot snapshot) {
        if (childData != null && !snapshot.exists()) {
            userRef.setValue(childData);
        } else if (mapUpdated != null && !snapshot.hasChildren()) {
            userRef.updateChildren(mapUpdated);
        }
    }
    @Override
    public void onCancelled(DatabaseError error) {
    }
}
