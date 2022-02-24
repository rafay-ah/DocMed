package com.innova.docmed.model;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class PharmacistHelper {
    static FirebaseFirestore db = FirebaseFirestore.getInstance();
    static CollectionReference pharmacistRef = db.collection("Pharmacist");

    public static void addPharmacist(String name, String adress, String tel, String email){
        Pharmacist pharmacist = new Pharmacist(name,adress,tel, email);
        pharmacistRef.document(email).set(pharmacist);

    }
}
