package com.innova.docmed.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.innova.docmed.R;
import com.innova.docmed.patient.Appointments;
import com.innova.docmed.patient.MedicalDossier;
import com.innova.docmed.patient.MyDoctors;
import com.innova.docmed.patient.PatientProfile;
import com.innova.docmed.patient.SearchDoctors;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

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
}