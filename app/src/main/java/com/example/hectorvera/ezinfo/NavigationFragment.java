package com.example.hectorvera.ezinfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hectorvera.ezinfo.POJO.Information;
import com.example.hectorvera.ezinfo.db.InformationDao;
import com.example.hectorvera.ezinfo.lib.Test;

import java.util.ArrayList;
import java.util.List;


public class NavigationFragment extends Fragment {

    public NavigationFragment() {
        // Required empty public constructor
    }

    private RecyclerView navegationRV;
    private RecyclerView.LayoutManager nlayoutManager;
    private NavigationAdapter nAdapter;
    private TextView txtBreadCrumbs;
    private boolean connectionflag = false;
    private InformationDao informationDao;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        informationDao = new InformationDao(getContext());
        navegationRV = ((RecyclerView) view.findViewById(R.id.navegationRV));

        navegationRV.setHasFixedSize(true);
        nlayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        navegationRV.setLayoutManager(nlayoutManager);

        ArrayList<Information> informations =  null;

        if(Test.isFireBaseConnection()){
            connectionflag = true;
        }else {
            informations =  informationDao.getMainCategories();
            connectionflag = false;
        }

        nAdapter = new NavigationAdapter(informations);
        nAdapter.setTxtBreadCrumbs(txtBreadCrumbs);
        nAdapter.setConnectionflag(connectionflag);
        nAdapter.setInformationDao(informationDao);
        navegationRV.setAdapter(nAdapter);

        return view;
    }


    public void setTxtBreadCrumbs(TextView txtBreadCrumbs) {
        this.txtBreadCrumbs = txtBreadCrumbs;
    }
}
