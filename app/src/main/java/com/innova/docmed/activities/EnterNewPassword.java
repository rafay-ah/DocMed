package com.innova.docmed.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.innova.docmed.R;

public class EnterNewPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_new_password);
    }

    public void changePassword(View view) {

        // password is changed successfully, taking back to signin screen
        // activity stack is cleared

        Intent i = new Intent(getApplicationContext(), Signin.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);

    }
}