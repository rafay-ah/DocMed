package com.innova.docmed.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.innova.docmed.R;
import com.innova.docmed.pharmacist.ReachBuyers;

/*
* Reach Buyers
* Reach Sellers
* View Profile
* Give Feedback*/
public class PharmacistDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacist_dashboard);
    }

    public void pharmacistSignout(View view) {
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(this, "Signing you out!!",
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Signin.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void reachBuyers(View view) {
        Intent reachPatients = new Intent(getApplicationContext(), ReachBuyers.class);
        startActivity(reachPatients);
    }

    public void reachSellers(View view) {
    }

    public void viewProfile(View view) {
    }

    public void addFeedback(View view) {
    }
}