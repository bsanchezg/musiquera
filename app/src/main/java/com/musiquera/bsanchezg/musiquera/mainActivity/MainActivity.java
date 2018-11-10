package com.musiquera.bsanchezg.musiquera.mainActivity;

import android.support.v7.app.AppCompatActivity;

import com.musiquera.bsanchezg.musiquera.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "BaseDriveActivity";

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);
    }
}