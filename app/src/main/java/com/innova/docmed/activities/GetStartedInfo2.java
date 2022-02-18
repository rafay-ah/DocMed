package com.innova.docmed.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.innova.docmed.R;

public class GetStartedInfo2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started_info2);
    }

    public void skip(View view) {
    }

    public void next1(View view) {
        Intent i = new Intent(getApplicationContext(), GetStartedInfo3.class);
        startActivity(i);

    }
}