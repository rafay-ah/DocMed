package com.innova.docmed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import com.innova.docmed.activities.GetStarted;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(MainActivity.this, GetStarted.class);
                startActivity(i);
                // close this activity
                finish();
            }
        }, 2000);

    }

    public void homeIntent(View view) {
        Intent i = new Intent(getApplicationContext(), GetStarted.class);
        startActivity(i);
    }
}