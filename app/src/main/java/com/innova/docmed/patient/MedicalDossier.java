package com.innova.docmed.patient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.innova.docmed.R;
import com.innova.docmed.activities.Signin;
import com.innova.docmed.model.MedicalDetails;
import com.innova.docmed.utilities.Common;

public class MedicalDossier extends AppCompatActivity {
    TextView name;
    TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_dossier);

        name = findViewById(R.id.patient_name);
        email = findViewById(R.id.patient_address);

        name.setText(Common.CurrentUserName);
        email.setText(Common.CurrentUserid);
        ;

    }

    public void getDetails(View view) {


    }

    public void addDetails(View view) {
        EditText weight = findViewById(R.id.weight);
        EditText height = findViewById(R.id.height);
        EditText bloodGroup = findViewById(R.id.bloodType);
        String weightS = weight.getText().toString();
        String heightS = height.getText().toString();
        String bloodGroupS = bloodGroup.getText().toString();
        MedicalDetails patientDossier = new MedicalDetails(weightS,heightS,bloodGroupS);

        FirebaseFirestore.getInstance().collection("Patient").document(Common.CurrentUserid).collection("MedicalDossier").add(patientDossier);
        Toast.makeText(MedicalDossier.this, "Medical Dossier Updated!",
                Toast.LENGTH_SHORT).show();

    }
}