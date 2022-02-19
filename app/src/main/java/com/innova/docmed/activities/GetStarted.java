package com.innova.docmed.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.innova.docmed.R;

public class GetStarted extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
    }

    public void skip(View view) {
        Intent i = new Intent(GetStarted.this, Signin.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }

    public void next(View view) {
        Intent i = new Intent(getApplicationContext(), GetStartedInfo2.class);
        startActivity(i);

    }
}