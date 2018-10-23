package cs2340.donationtracker.Controllers;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import cs2340.donationtracker.Model.Model;
//import cs2340.donationtracker.Model.User;
import cs2340.donationtracker.Model.User_type;
import cs2340.donationtracker.R;

public class Registration extends AppCompatActivity {
    private GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN = 10;
    private FirebaseAuth mAuth;
    private User_type userType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initTypeSprinner();
        initGoogleSignInButton();



    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Toast.makeText(Registration.this, "Google sign-in failed, try it again", Toast.LENGTH_SHORT).show();
                // ...
            }
        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(Registration.this, "Google sign-in was successful", Toast.LENGTH_SHORT).show();
                            goToNextView();
                        } else {
                            Toast.makeText(Registration.this, "Google sign-in failed, try it again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    public void onAddUser(View v) {
        Log.d("smt", "got here");
        EditText email = findViewById(R.id.email);
        final EditText user = findViewById(R.id.username);
        EditText pass = findViewById(R.id.password);
        Spinner type = findViewById(R.id.type);
        Log.d("smtg", "got else");

        final User_type[] userTypes = User_type.values();
        type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (userTypes[position] == User_type.ADMIN) {
                    goToRegistration_admin();
                } else if (userTypes[position] == User_type.MANAGER) {
                    userType = User_type.MANAGER;
                } else if (userTypes[position] == User_type.LOCATION_EMPLOYEE) {
                    userType = User_type.LOCATION_EMPLOYEE;
                } else if (userTypes[position] == User_type.USER){
                    userType = User_type.USER;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                userType = User_type.USER;
            }
        });

    }
    /*private void signUpUser(String email, String password) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                FirebaseUser user = task.getResult().getUser();
                //User userModel = new User(user.getEmail());
            }
        })
    }*/
    /*
    public void onAddUser(View v) {
        Log.d("smt", "got here");
        EditText email = findViewById(R.id.email);
        EditText user = findViewById(R.id.username);
        EditText pass = findViewById(R.id.password);
        Spinner type = findViewById(R.id.type);
        Log.d("smtg", "got else");

        Model model = Model.getInstance();
        User newuser = new User(email.getText().toString(), user.getText().toString(),
                pass.getText().toString(), type.getSelectedItem().toString());
        if (model.addUser(newuser)) {
            Intent intent = new Intent(this, MainApplication.class);
            startActivity(intent);
        } else {
            TextView fail = findViewById(R.id.fail);
            fail.setText("Registration Failed: Email already in use");
        }ß
    }
    */
    private void initGoogleSignInButton() {
        mAuth = FirebaseAuth.getInstance();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        SignInButton button = (SignInButton) findViewById(R.id.button_google);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }
    private void initTypeSprinner() {

        Spinner s = findViewById(R.id.type);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, User_type.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }
    private void goToNextView() {
        Intent intent = new Intent(this, MainApplication.class);
        startActivity(intent);
    }
    private void goToRegistration_admin() {
        Intent intent = new Intent(this, Registration_admin.class);
        startActivity(intent);
    }
    public void cancel(View v) {
        Intent intent = new Intent(this, Welcomescreen.class);
        startActivity(intent);
    }
}
