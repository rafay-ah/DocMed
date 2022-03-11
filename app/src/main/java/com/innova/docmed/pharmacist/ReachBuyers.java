package com.innova.docmed.pharmacist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.innova.docmed.R;
import com.innova.docmed.utilities.adapter.DoctorAdapterFiltred;
import com.innova.docmed.utilities.adapter.ListAllPatientAdapter;

public class ReachBuyers extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference patients = db.collection("Patient");
    private ListAllPatientAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reach_buyers);
    }
}