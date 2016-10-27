package com.example.hectorvera.ezinfo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.hectorvera.ezinfo.POJO.Information;
import com.example.hectorvera.ezinfo.db.InformationDao;
import com.example.hectorvera.ezinfo.lib.Library;
import com.example.hectorvera.ezinfo.lib.Test;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Button login;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        login = ((Button) findViewById(R.id.login));

        InformationDao informationDao = new InformationDao(getBaseContext());

        ArrayList<Information> informations = Test.getMainCategory();
        for (Information i:informations) {
            long index = informationDao.getInformationId(i.getName(),i.getContent(),i.getIsTopLevel());
            if(index==0){
                informationDao.addInformation(i);
            }else {
                i.setId(index);
                Log.d("DEBUG", i.toString());
            }
        }
    }

    public void onSuccess(View view) {
        //setContentView(R.layout.activity_container);
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }


}
