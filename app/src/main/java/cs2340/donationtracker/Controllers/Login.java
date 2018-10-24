package cs2340.donationtracker.Controllers;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import cs2340.donationtracker.Model.CurrentUser;
import cs2340.donationtracker.Model.User;
import cs2340.donationtracker.Model.User_type;
import cs2340.donationtracker.R;

public class Login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    DatabaseReference databaseReference;
    final String TAG = "Login";


    EditText email;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        initTextViews();

    }
    private void initTextViews() {
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
    }
    private void signIn(String email, String password) {
        Log.d(TAG, "signIn:" + email);
        if (!validateForm()) {
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            final FirebaseUser user = mAuth.getCurrentUser();
                            final String uId = user.getUid();
                            databaseReference = FirebaseDatabase.getInstance().getReference();
                            databaseReference.child("account").child(uId).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    User mUser = dataSnapshot.getValue(User.class);
                                    System.out.println(mUser.getType()+" adfasfsf");
                                    CurrentUser.getInstance().setUserType(mUser.getType());
                                    if (mUser.getType() == User_type.USER) {
                                        goToMainApplication_user();
                                    } else {
                                        goToMainApplication();
                                    }
                                }
                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(Login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            goToFailedLogin();
                        }
                    }
                });
    }
    private boolean validateForm() {
        boolean valid = true;

        String email = this.email.getText().toString();
        if (TextUtils.isEmpty(email)) {
            this.email.setError("Required.");
            valid = false;
        } else {
            this.email.setError(null);
        }

        String password = pass.getText().toString();
        if (TextUtils.isEmpty(password)) {
            pass.setError("Required.");
            valid = false;
        } else {
            pass.setError(null);
        }

        return valid;
    }
    public void loginAttempt(View v) {
        signIn(email.getText().toString(), pass.getText().toString());
    }
    private void goToMainApplication() {
        Intent intent = new Intent(this, MainApplication.class);
        startActivity(intent);
    }
    private void goToMainApplication_user() {
        Intent intent = new Intent(this, MainApplication_user.class);
        startActivity(intent);
    }
    private void goToFailedLogin() {
        Intent intent = new Intent(this, FailedLogin.class);
        startActivity(intent);
    }

    public void goBack(View v) {
        Intent intent = new Intent(this, Welcomescreen.class);
        startActivity(intent);
    }
}
