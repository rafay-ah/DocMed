package com.innova.docmed.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.innova.docmed.R;
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

}