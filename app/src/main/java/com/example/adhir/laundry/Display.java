package com.example.adhir.laundry;

import android.content.SharedPreferences;
import android.nfc.Tag;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Display extends AppCompatActivity {
    String marketPref = "";
    String machinesAvailable = "";
    String machinesUnavailable = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(this);
        marketPref = sharedPref.getString("floor", "Select Floor");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        if(marketPref.length() == 7){
            marketPref = marketPref.substring(6,7);
        } else {
            marketPref = marketPref.substring(5,7);
        }

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Laundry")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        Long d = Long.valueOf(0);
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                if(document.getId().equals("Floor" + marketPref)){
                                    for( String key : document.getData().keySet()){
                                        if(document.getData().get(key).equals(d)){
                                            machinesAvailable += key + "\n";
                                        } else {
                                            machinesUnavailable += key + " Time Left: " + document.getData().get(key) + "\n";
                                        }
                                    }
                                }
                            }
                            TextView tv = (TextView) findViewById(R.id.textView3);
                            tv.setText(machinesAvailable);
                            TextView tv2 = (TextView) findViewById(R.id.textView6);
                            tv2.setText(machinesUnavailable);
                        } else {
                            Log.w("TAG", "Error getting documents.", task.getException());
                        }
                    }
                });

        /*
        DatabaseReference myRef = database.getReference("/");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                HashMap<String, String> value = (HashMap<String, String>) dataSnapshot.getValue(true);
                for ( String key : value.keySet() ) {
                    if(key.contains(marketPref) && value.get(key).equals("0")){
                        machinesAvailable += key + "\n";
                    }
                }
                TextView tv = (TextView) findViewById(R.id.textView3);
                tv.setText(machinesAvailable);
                // for(String key : a.keySet()){
                // }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        }); */

        /* HashMap<String, ArrayList<String>> laundryID = new HashMap<>();
        ArrayList<String> Floor1 = new ArrayList<>();
        Floor1.add("machine0101");
        Floor1.add("machine0102");
        ArrayList<String> Floor2 = new ArrayList<>();
        Floor2.add("machine0201");
        Floor2.add("machine0202");
        laundryID.put("Floor1", Floor1);
        laundryID.put("Floor2", Floor2);
        myRef.setValue(laundryID);
        myRef = database.getReference("machine0101");
        myRef.setValue("true");
        myRef = database.getReference("machine0102");
        myRef.setValue("true");
        myRef = database.getReference("machine0201");
        myRef.setValue("true");
        myRef = database.getReference("machine0202");
        myRef.setValue("true"); */

    }
}
