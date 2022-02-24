package com.innova.docmed.model;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class PatientHelper {
    static FirebaseFirestore db = FirebaseFirestore.getInstance();
    static CollectionReference PatientRef = db.collection("Patient");

    public static void addPatient(String name, String adress, String tel,String email){
        Patient patient = new Patient(name,adress,tel,email,"Not Provided", "Not Provided");
        System.out.println("Create object patient");
        PatientRef.document(email).set(patient);
    }
}
