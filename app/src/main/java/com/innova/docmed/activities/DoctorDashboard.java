package com.innova.docmed.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.innova.docmed.R;
import com.innova.docmed.doctor.DAppointment;
import com.innova.docmed.doctor.DoctorCalander;
import com.innova.docmed.doctor.MyPatients;
import com.innova.docmed.doctor.PatientRequests;
import com.innova.docmed.patient.PatientProfile;
import com.innova.docmed.patient.SearchDoctors;

public class DoctorDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_dashboard);
    }

    public void myPatientsIntent(View view) {
        Intent k = new Intent(getApplicationContext(), MyPatients.class);
        startActivity(k);
    }

    public void doctorAppointmentIntent(View view) {
        Intent k = new Intent(getApplicationContext(), DAppointment.class);
        startActivity(k);
    }

    public void doctorProfileIntent(View view) {
        Intent k = new Intent(getApplicationContext(), PatientProfile.class);
        startActivity(k);
    }

    public void patientRequestIntents(View view) {
        Intent k = new Intent(getApplicationContext(), PatientRequests.class);
        startActivity(k);
    }

    public void doctorCalendarIntent(View view) {
        Intent k = new Intent(getApplicationContext(), DoctorCalander.class);
        startActivity(k);
    }
}