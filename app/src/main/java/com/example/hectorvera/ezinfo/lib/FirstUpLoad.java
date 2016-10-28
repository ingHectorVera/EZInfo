package com.example.hectorvera.ezinfo.lib;

import android.content.Context;
import android.util.Log;

import com.example.hectorvera.ezinfo.Category;
import com.example.hectorvera.ezinfo.Info;
import com.example.hectorvera.ezinfo.POJO.Information;
import com.example.hectorvera.ezinfo.db.InformationDao;

import java.util.ArrayList;
import java.util.List;

public class FirstUpLoad {
    private InformationDao informationDao;
    public FirstUpLoad(InformationDao informationDao){
        this.informationDao = informationDao;
    }

    public void upLoadMainCategory(){
        ArrayList<Information> informations = Test.getMainCategory();
//        for later
       for (Information i: informations) {
            long id = (int)informationDao.getInformationId(i.getName(),i.getContent(),i.getIsTopLevel());
            if(id == 0){
                informationDao.addInformation(i);
            }else{
                i.setId(id);
                Log.d(Library.DEBUG, i.toString());
            }
        }
    }

    public void upLoadMainCategoryFB(){
        List<Info> informations = Test.getMainCategoryFB();

    }
}
