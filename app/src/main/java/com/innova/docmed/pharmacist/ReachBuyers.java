package com.innova.docmed.pharmacist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.innova.docmed.R;
import com.innova.docmed.model.Patient;
import com.innova.docmed.utilities.adapter.DoctorAdapterFiltred;
import com.innova.docmed.utilities.adapter.ListAllPatientAdapter;
import com.innova.docmed.utilities.adapter.MyPatientsAdapter;

public class ReachBuyers extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference myPatientsRef = db.collection("Patient");
    private MyPatientsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_patients);
        setUpRecyclerView();
        TextView toolbarTitle = findViewById(R.id.toolbarTitle);
        toolbarTitle.setText("Available Buyers");
    }

    public void setUpRecyclerView(){

        final String doctorID = FirebaseAuth.getInstance().getCurrentUser().getEmail().toString();
        Query query = myPatientsRef.orderBy("name", Query.Direction.DESCENDING);

        FirestoreRecyclerOptions<Patient> options = new FirestoreRecyclerOptions.Builder<Patient>()
                .setQuery(query, Patient.class)
                .build();

        adapter = new MyPatientsAdapter(options);
        //ListMyPatients
        RecyclerView recyclerView = findViewById(R.id.ListMyPatients);
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