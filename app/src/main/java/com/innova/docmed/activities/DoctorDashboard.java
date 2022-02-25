package com.innova.docmed.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.innova.docmed.R;
import com.innova.docmed.doctor.DAppointment;
import com.innova.docmed.doctor.DoctorCalander;
import com.innova.docmed.doctor.DoctorProfile;
import com.innova.docmed.doctor.MyPatients;
import com.innova.docmed.doctor.PatientRequests;
import com.innova.docmed.patient.PatientProfile;
import com.innova.docmed.patient.SearchDoctors;
import com.innova.docmed.utilities.Common;

import java.util.Calendar;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DoctorDashboard extends AppCompatActivity  implements DatePickerDialog.OnDateSetListener {

    static String doc;
    Unbinder unbinder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_dashboard);
        unbinder = ButterKnife.bind(this,this);


        Common.CurreentDoctor = FirebaseAuth.getInstance().getCurrentUser().getEmail().toString();
        Common.CurrentUserType = "doctor";
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
        Intent k = new Intent(getApplicationContext(), DoctorProfile.class);
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

    public void docSignOut(View view) {
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(this, "Signing you out!!",
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Signin.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void showDatePickerDialog(Context wf){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                wf,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = "month_day_year: " + month + "_" + dayOfMonth + "_" + year;
        openPage(view.getContext(),doc,date);
    }

    private void openPage(Context wf, String d, String day){
        Intent i = new Intent(wf, AppointmentActivity.class);
        i.putExtra("key1",d+"");
        i.putExtra("key2",day);
        i.putExtra("key3","doctor");
        wf.startActivity(i);
    }
}