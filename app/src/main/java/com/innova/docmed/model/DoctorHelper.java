package com.innova.docmed.model;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class DoctorHelper {
    static FirebaseFirestore db = FirebaseFirestore.getInstance();
    static CollectionReference DoctorRef = db.collection("Doctor");

    public static void addDoctor(String name, String adress, String tel,String specialization, String email){
        Doctor doctor = new Doctor(name,adress,tel, email,specialization);

        DoctorRef.document(email).set(doctor);

    }
}
