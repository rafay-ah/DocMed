package com.innova.docmed.model;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserHelper {
    static FirebaseFirestore db = FirebaseFirestore.getInstance();
    static CollectionReference UsersRef = db.collection("User");

    public static void addUser(String name, String adress, String tel,String type, String email){
        User user = new User(name,adress,tel,email,type);
        UsersRef.document(email).set(user);

    }
}
