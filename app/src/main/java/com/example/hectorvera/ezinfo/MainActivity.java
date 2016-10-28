package com.example.hectorvera.ezinfo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.hectorvera.ezinfo.POJO.Information;
import com.example.hectorvera.ezinfo.db.InformationDao;
import com.example.hectorvera.ezinfo.lib.FirstUpLoad;
import com.example.hectorvera.ezinfo.lib.Library;
import com.example.hectorvera.ezinfo.lib.Test;
import com.firebase.client.Firebase;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 747;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    //Button login;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        InformationDao informationDao = new InformationDao(getBaseContext());

        if(informationDao.countMainCategories() == 0){
            FirstUpLoad firstUpLoad = new FirstUpLoad(informationDao);
            firstUpLoad.upLoadMainCategory();
        }

        Firebase.setAndroidContext(this);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setProviders(
                            AuthUI.EMAIL_PROVIDER,
                            AuthUI.GOOGLE_PROVIDER
                            )
                                    .build(),
                            RC_SIGN_IN);
                }
                else {

                    //Toast.makeText(MainActivity.this,"Not logged in", Toast.LENGTH_LONG).show();
                }
            }
        };
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                // user is signed in!
                startActivity(new Intent(this, ContainerActivity.class));
                //Toast.makeText(this, "YES   :)",Toast.LENGTH_LONG).show();
                finish();
            } else {
                // user is not signed in. Maybe just wait for the user to press
                // "sign in" again, or show a message
                //Toast.makeText(this, "Not signed in",Toast.LENGTH_LONG).show();
                finish();
            }
        }
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
    /*public void onSuccess(View view) {
        //setContentView(R.layout.activity_container);
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }*/


}
