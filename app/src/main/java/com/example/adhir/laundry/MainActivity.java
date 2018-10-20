package com.example.adhir.laundry;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PreferenceManager.setDefaultValues(this, R.xml.pref_notification, false);
        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(this);
        Boolean switchPref = sharedPref.getBoolean
                ("notifications_new_message", false);
        String marketPref = sharedPref.getString("floor", "Select Floor");
        if(marketPref.toString().equals("Select Floor")){
            setContentView(R.layout.activity_main);
        } else {
            Intent intentMain = new Intent(MainActivity.this ,
                    Navigation.class);
            MainActivity.this.startActivity(intentMain);
        }
    }

    public void begin(android.view.View r){
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        String text = mySpinner.getSelectedItem().toString();

        if(text.equals("Select Floor")){
            Toast.makeText(this, "Please Select a Floor Number", Toast.LENGTH_LONG).show();
        } else {
            SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("floor",text);
            editor.commit();

            Intent intentMain = new Intent(MainActivity.this ,
                    Navigation.class);
            MainActivity.this.startActivity(intentMain);
        }
    }
}
