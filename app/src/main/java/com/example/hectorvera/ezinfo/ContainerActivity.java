package com.example.hectorvera.ezinfo;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hectorvera.ezinfo.lib.Methods;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class ContainerActivity extends AppCompatActivity {
    NavigationFragment nf;
    InformationFragment inf;
    LinearLayout navigationId, informationId;
    //Button onLogout;
    ImageButton onLogout;
    ImageButton onSearch;
    ImageButton bhome;
    private TextView txtBreadCrumbs;
    private EditText infoSearch;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        navigationId = ((LinearLayout) findViewById(R.id.navigationId));
        informationId = ((LinearLayout) findViewById(R.id.informationId));
        txtBreadCrumbs = ((TextView) findViewById(R.id.txtBreadCrumbs));
        infoSearch = ((EditText) findViewById(R.id.infoSearch));
        //onLogout = ((Button) findViewById(R.id.onLogout));
        onLogout = ((ImageButton) findViewById(R.id.onLogout));
        onSearch = ((ImageButton) findViewById(R.id.onSearch));
        bhome = ((ImageButton) findViewById(R.id.bhome));
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if((navigationId!= null)&&(informationId!=null)){
            nf = new NavigationFragment();
            nf.setTxtBreadCrumbs(txtBreadCrumbs);
            nf.setOnSearch(onSearch);
            nf.setInfoSearch(infoSearch);
            nf.setBhome(bhome);
            inf = new InformationFragment();
            if(Methods.isTablet(this)){
                transaction.add(R.id.navigationId, nf);
                transaction.add(R.id.informationId, inf).commit();
            }else {
                transaction.add(R.id.navigationId, nf);
                transaction.add(R.id.informationId, inf);
                transaction.hide(inf).commit();
            }
        }

        onLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthUI.getInstance().signOut(ContainerActivity.this).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        finish();
                    }
                });
            }
        });
    }
    @Override
    public void onStop() {
        super.onStop();
        AuthUI.getInstance().signOut(ContainerActivity.this).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                finish();
            }
        });

    }
}
