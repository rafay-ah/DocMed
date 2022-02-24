package com.innova.docmed.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.innova.docmed.R;
import com.innova.docmed.model.Doctor;
import com.innova.docmed.model.DoctorHelper;
import com.innova.docmed.model.PatientHelper;
import com.innova.docmed.model.PharmacistHelper;
import com.innova.docmed.model.UserHelper;

public class Signup extends AppCompatActivity {

    EditText username;
    EditText mobilenum;
    EditText email;
    EditText password;
    Button signup;
    EditText userRole;
    private FirebaseAuth mAuth;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.editTextTextEmailAddress3);
        mobilenum = findViewById(R.id.editTextTextEmailAddress5);
        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextEmailAddress2);
        userRole = findViewById(R.id.editTextTextEmailAddress6);
        signup = findViewById(R.id.button3);
    }

    public void register(View view) {
        // all logic pertaining to different roles signup occurs here
        String name=username.getText().toString();
        String mobile=mobilenum.getText().toString();
        String emails = email.getText().toString();
        String pass = password.getText().toString();
        String role = userRole.getText().toString().trim();

        if(!emails.isEmpty() && !pass.isEmpty()){
            mAuth.createUserWithEmailAndPassword(emails, pass)
                    .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("TAG", "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("TAG", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(Signup.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

            if (role.equals("Patient")) {
                PatientHelper.addPatient(name, "No Address Provided", mobile,emails);
                UserHelper.addUser(name, "Not Provided", mobile, "Patient",emails);

            } else if (role.equals("Doctor")) {
                DoctorHelper.addDoctor(name, "No Address Provided", mobile, "General",emails);
                UserHelper.addUser(name, "Not Provided", mobile, "Doctor",emails);
            }
            else if (role.equals("Pharmacist")) {
                PharmacistHelper.addPharmacist(name, "No Address Provided", mobile, emails);
                UserHelper.addUser(name, "Not Provided", mobile, "Pharmacist",emails);
            }
        }

        Toast.makeText(getApplicationContext(), "Account Created!",
                Toast.LENGTH_SHORT).show();

        Intent i = new Intent(getApplicationContext(), Signin.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}