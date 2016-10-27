package com.example.hectorvera.ezinfo;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hectorvera.ezinfo.lib.Methods;

public class ContainerActivity extends AppCompatActivity {
    NavigationFragment nf;
    InformationFragment inf;
    LinearLayout navigationId, informationId;
    private TextView txtBreadCrumbs;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        navigationId = ((LinearLayout) findViewById(R.id.navigationId));
        informationId = ((LinearLayout) findViewById(R.id.informationId));
        txtBreadCrumbs = ((TextView) findViewById(R.id.txtBreadCrumbs));

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        if((navigationId!= null)&&(informationId!=null)){
            nf = new NavigationFragment();
            nf.setTxtBreadCrumbs(txtBreadCrumbs);
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
    }
}
