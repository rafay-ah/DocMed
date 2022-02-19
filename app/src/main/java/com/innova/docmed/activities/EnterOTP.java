package com.innova.docmed.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.innova.docmed.R;

public class EnterOTP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_otp);
    }

    public void verifyOTP(View view) {
        Intent i = new Intent(getApplicationContext(), EnterNewPassword.class);
        startActivity(i);
    }
}