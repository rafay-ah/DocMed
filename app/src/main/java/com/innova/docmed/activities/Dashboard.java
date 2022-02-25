package com.innova.docmed.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.innova.docmed.R;
import com.innova.docmed.patient.Appointments;
import com.innova.docmed.patient.MedicalDossier;
import com.innova.docmed.patient.MyDoctors;
import com.innova.docmed.patient.PatientProfile;
import com.innova.docmed.patient.SearchDoctors;
import com.innova.docmed.utilities.Common;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Common.CurrentUserid= FirebaseAuth.getInstance().getCurrentUser().getEmail().toString();
        FirebaseFirestore.getInstance().collection("User").document(Common.CurrentUserid).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Common.CurrentUserName = documentSnapshot.getString("name");
            }
        });

    }

    public void searchDoctorIntent(View view) {
        Intent k = new Intent(getApplicationContext(), SearchDoctors.class);
        startActivity(k);
    }

    public void medicalHistoryIntent(View view) {
        Intent k = new Intent(getApplicationContext(), MedicalDossier.class);
        startActivity(k);
    }

    public void myDoctorsIntent(View view) {

        Intent k = new Intent(getApplicationContext(), MyDoctors.class);
        startActivity(k);
    }

    public void patientProfileIntent(View view) {

        Intent k = new Intent(getApplicationContext(), PatientProfile.class);
        startActivity(k);
    }

    public void appointmentsIntent(View view) {

        Intent k = new Intent(getApplicationContext(), Appointments.class);
        startActivity(k);

    }

    public void signOut(View view) {
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(Dashboard.this, "Signing you out!!",
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Signin.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}