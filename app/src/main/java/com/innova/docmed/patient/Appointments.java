package com.innova.docmed.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.innova.docmed.R;
import com.innova.docmed.model.ApointementInformation;
import com.innova.docmed.utilities.adapter.PatientAppointmentsAdapter;

public class Appointments extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference myDoctorsRef = db.collection("Patient");
    private PatientAppointmentsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);

        setUpRecyclerView();
    }

    public void setUpRecyclerView(){
        //Get the doctors by patient id
        final String doctorID = FirebaseAuth.getInstance().getCurrentUser().getEmail().toString();
        Query query = myDoctorsRef.document(""+doctorID+"")
                .collection("calendar").orderBy("time", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<ApointementInformation> options = new FirestoreRecyclerOptions.Builder<ApointementInformation>()
                .setQuery(query, ApointementInformation.class)
                .build();

        adapter = new PatientAppointmentsAdapter(options);
        //List current appointments
        RecyclerView recyclerView = findViewById(R.id.patient_appointements);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}