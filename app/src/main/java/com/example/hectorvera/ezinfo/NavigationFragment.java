package com.example.hectorvera.ezinfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hectorvera.ezinfo.POJO.Information;
import com.example.hectorvera.ezinfo.db.InformationDao;
import com.example.hectorvera.ezinfo.lib.Library;
import com.example.hectorvera.ezinfo.lib.Test;

import java.util.ArrayList;


public class NavigationFragment extends Fragment {

    public NavigationFragment() {
        // Required empty public constructor
    }

    private RecyclerView navegationRV;
    private RecyclerView.LayoutManager nlayoutManager;
    private NavigationAdapter nAdapter;
    private TextView txtBreadCrumbs;
    private EditText infoSearch;
    private ImageButton onSearch;
    private ImageButton bhome;
    private ImageButton bBackward;
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
            informations =  informationDao.getMSCategories(Library.MAIN_CATEGORY);
            connectionflag = false;
        }

        nAdapter = new NavigationAdapter(informations);
        nAdapter.setTxtBreadCrumbs(txtBreadCrumbs);
        nAdapter.setOnSearch(onSearch);
        nAdapter.setBhome(bhome);
        nAdapter.setbBackward(bBackward);
        nAdapter.setInfoSearch(infoSearch);
        nAdapter.setConnectionflag(connectionflag);
        nAdapter.setInformationDao(informationDao);
        navegationRV.setAdapter(nAdapter);

        return view;
    }


    public void setTxtBreadCrumbs(TextView txtBreadCrumbs) {
        this.txtBreadCrumbs = txtBreadCrumbs;
    }

    public void setOnSearch(ImageButton onSearch) {
        this.onSearch = onSearch;
    }

    public void setInfoSearch(EditText infoSearch) {
        this.infoSearch = infoSearch;
    }

    public void setBhome(ImageButton bhome) {
        this.bhome = bhome;
    }

    public void setbBackward(ImageButton bBackward) {
        this.bBackward = bBackward;
    }
}
