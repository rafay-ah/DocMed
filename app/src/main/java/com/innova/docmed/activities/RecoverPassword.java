package com.innova.docmed.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.innova.docmed.R;

public class RecoverPassword extends AppCompatActivity {

    EditText recoverEmail;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);
        recoverEmail = findViewById(R.id.recoverEmail);

        auth = FirebaseAuth.getInstance();
    }

    public void sendOTP(View view) {
        String email = recoverEmail.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplication(), "Enter your registered email id", Toast.LENGTH_SHORT).show();
            return;
        }
        auth.sendPasswordResetEmail(email)

                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
//        Intent i = new Intent(getApplicationContext(), EnterOTP.class);
//        startActivity(i);
    }
}