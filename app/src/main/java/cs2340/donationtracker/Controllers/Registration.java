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
import android.widget.ImageView;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import cs2340.donationtracker.Model.CurrentUser;
import cs2340.donationtracker.Model.Sha256;
import cs2340.donationtracker.Model.User;
import cs2340.donationtracker.Model.User_type;
import cs2340.donationtracker.R;


@SuppressWarnings({"SpellCheckingInspection", "IfCanBeSwitch", "RedundantCast", "TypeMayBeWeakened", "ChainedMethodCall"})
public class Registration extends AppCompatActivity {
    private GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN = 10;
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;
    private Spinner locationSpinner;
    private ImageView imageView;
    private final String TAG = "Reg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initTypeSpinner();
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
                fireBaseAuthWithGoogle(account);
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
    private void fireBaseAuthWithGoogle(GoogleSignInAccount acct) {

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(Registration.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(Registration.this, "Google sign-in was successful", Toast.LENGTH_SHORT).show();
                            goToMainApplication_user();
                        } else {
                            Toast.makeText(Registration.this, "Google sign-in failed, try it again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    public void onAddUser(View v) {
        Log.d("smt", "got here");
        EditText email = findViewById(R.id.email);
        EditText user = findViewById(R.id.name);
        EditText pass = findViewById(R.id.password);
        Spinner type = findViewById(R.id.type);
        signUpUser(email.getText().toString(), pass.getText().toString(), user.getText().toString(), CurrentUser.getInstance().getUserType());
        Log.d("smtg", "got else");
    }

    @SuppressWarnings("FeatureEnvy")
    private void signUpUser(String email, String password, String username, final User_type user_type) {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        final User userModel = new User("", Sha256.encrypt(password), username, user_type);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("sign-up", "createUserWithEmail:success");
                            FirebaseUser user = task.getResult().getUser();
                            userModel.setEmail(user.getEmail());
                            databaseReference.child("account").child(user.getUid()).setValue(userModel);
                            CurrentUser.getInstance().setUserType(user_type);
                            CurrentUser.getInstance().setCurrUser(userModel);
                            if (CurrentUser.getInstance().getUserType() == User_type.USER) {
                                goToMainApplication_user();
                            } else {
                                goToMainApplication();
                            }
                        } else {
                            Log.w("", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Registration.this, "The email address is already in use",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("", "createUserWithEmail:failure" + e.getMessage());
                        Toast.makeText(Registration.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });

    }
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
    @SuppressWarnings("FeatureEnvy")
    private void initTypeSpinner() {
        locationSpinner = findViewById(R.id.regist_location);
        TextView textView = findViewById(R.id.manage);
        imageView = findViewById(R.id.map);

        Spinner s = findViewById(R.id.type);
        final ArrayAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, User_type.values());
        final ArrayAdapter adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Location.locationList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        final User_type[] userTypes = User_type.values();
        //noinspection FeatureEnvy
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (userTypes[position] == User_type.ADMIN) {
                    goToRegistration_admin();
                    locationSpinner.setVisibility(View.GONE);
                    imageView.setVisibility(View.GONE);
                } else if (userTypes[position] == User_type.MANAGER) {
                    CurrentUser.getInstance().setUserType(User_type.MANAGER);
                    locationSpinner.setVisibility(View.GONE);
                    imageView.setVisibility(View.GONE);
                } else if (userTypes[position] == User_type.LOCATION_EMPLOYEE) {
                    CurrentUser.getInstance().setUserType(User_type.LOCATION_EMPLOYEE);
                    locationSpinner.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.VISIBLE);
                    locationSpinner.setAdapter(adapter2);
                    locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            CurrentUser.getInstance().setLocationData(Location.locationList.get(position));
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            CurrentUser.getInstance().setLocationData(Location.locationList.get(0));
                        }
                    });
                } else if (userTypes[position] == User_type.USER){
                    CurrentUser.getInstance().setUserType(User_type.USER);
                    locationSpinner.setVisibility(View.GONE);
                    imageView.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                CurrentUser.getInstance().setUserType(User_type.USER);
            }
        });
    }
    private void goToMainApplication() {
        Intent intent = new Intent(this, MainApplication.class);
        startActivity(intent);
    }
    private void goToMainApplication_user() {
        Intent intent = new Intent(this, MainApplication_user.class);
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
