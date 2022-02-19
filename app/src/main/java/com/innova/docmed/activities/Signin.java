package com.innova.docmed.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.innova.docmed.R;

public class Signin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }

    public void signIn(View view) {

        Intent i = new Intent(getApplicationContext(), Signup.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);

    }

    public void registerIntent(View view) {
        Intent i = new Intent(getApplicationContext(), Signup.class);
        startActivity(i);
    }

    public void forgotPasswordIntent(View view) {

        Intent i = new Intent(getApplicationContext(), RecoverPassword.class);
        startActivity(i);

    }
}