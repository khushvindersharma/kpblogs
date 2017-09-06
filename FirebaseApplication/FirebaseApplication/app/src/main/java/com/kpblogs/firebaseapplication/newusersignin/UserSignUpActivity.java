package com.kpblogs.firebaseapplication.newusersignin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.kpblogs.firebaseapplication.R;

/**
 * @author Khushvinders
 */

public class UserSignUpActivity extends AppCompatActivity {
    private static final String TAG = UserSignUpActivity.class.getName();
    private Button signUp;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText email, password, userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up);
        ((TextView)findViewById(R.id.loginHere)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserSignUpActivity.this, SigninActivity.class));
                finish();
            }
        });
        signUp = (Button)findViewById(R.id.signUp);
        userName = (EditText)findViewById(R.id.userName);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Toast.makeText(UserSignUpActivity.this, "onAuthStateChanged:signed_in", Toast.LENGTH_LONG).show();
                } else {
                    // User is signed out
                    Toast.makeText(UserSignUpActivity.this, "onAuthStateChanged:signed_out", Toast.LENGTH_LONG).show();
                }
            }
        };
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.createUserWithEmailAndPassword(email.getText().toString().trim(), password.getText().toString().trim())
                        .addOnCompleteListener(UserSignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(UserSignUpActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    task.getException().printStackTrace();
                                }
                                else{

                                    //After user creation adding user name also for display prospective
                                    UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                                            .setDisplayName(userName.getText().toString().trim()).build();
                                    mAuth.getCurrentUser().updateProfile(request).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()) {
                                                Toast.makeText(UserSignUpActivity.this, "Sign up successfully completed",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                            else{
                                                task.getException().printStackTrace();
                                            }
                                        }
                                    });
                                }
                            }
                        });
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
