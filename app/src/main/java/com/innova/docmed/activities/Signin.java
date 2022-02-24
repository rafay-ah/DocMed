package com.innova.docmed.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.innova.docmed.R;
import com.innova.docmed.model.User;

public class Signin extends AppCompatActivity {
    EditText emailText;
    EditText passwordText;
    private FirebaseAuth mAuth;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference UsersRef = db.collection("User");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        mAuth = FirebaseAuth.getInstance();
        emailText =findViewById(R.id.editTextTextEmailAddress);
        passwordText =findViewById(R.id.editTextTextEmailAddress2);
    }

    public void signIn(View view) {

        String email=emailText.getText().toString();
        String password=passwordText.getText().toString();
        if(!email.isEmpty() && !password.isEmpty() ){
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(Signin.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("TAG", "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("TAG", "signInWithEmail:failure", task.getException());
                                Toast.makeText(Signin.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                updateUI(null);
                            }
                        }
                    });
        }else{
            Toast.makeText(Signin.this, "Email & Password fields are necessary",
                    Toast.LENGTH_SHORT).show();
        }
//        Intent i = new Intent(getApplicationContext(), DoctorDashboard.class);
//        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(i);
    }

    private void updateUI(final FirebaseUser currentUser) {
        if(currentUser!=null){
            try {
                UsersRef.document(currentUser.getEmail()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            UsersRef.document(currentUser.getEmail()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                    User user=documentSnapshot.toObject(User.class);
                                    if(user.getType().equals("Patient")){
                                        Intent k = new Intent(getApplicationContext(), Dashboard.class);
                                        k.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(k);
                                    }else if (user.getType().equals("Doctor")){
                                        Intent k = new Intent(getApplicationContext(), DoctorDashboard.class);
                                        k.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(k);
                                    }else if (user.getType().equals("Pharmacist")){
                                        Intent k = new Intent(getApplicationContext(), PharmacistDashboard.class);
                                        k.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(k);
                                    }
                                }});
                        }
                    }
                });
            } catch(Exception e) {
                e.printStackTrace();
            } }
    }

    public void registerIntent(View view) {
        Intent i = new Intent(getApplicationContext(), Signup.class);
        startActivity(i);
    }

    public void forgotPasswordIntent(View view) {

        Intent i = new Intent(getApplicationContext(), RecoverPassword.class);
        startActivity(i);

    }
}