package com.innova.docmed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.innova.docmed.activities.GetStarted;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void homeIntent(View view) {
        Intent i = new Intent(getApplicationContext(), GetStarted.class);
        startActivity(i);
    }
}