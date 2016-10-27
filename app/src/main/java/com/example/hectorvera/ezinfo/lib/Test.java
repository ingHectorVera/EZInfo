package com.example.hectorvera.ezinfo.lib;

import com.example.hectorvera.ezinfo.POJO.Information;

import java.util.ArrayList;

/**
 * Created by User on 10/23/2016.
 */

public class Test {


    public static ArrayList<Information> getCategories(){
        ArrayList<Information> informations = new ArrayList<Information>();
        informations.add(new Information((long)1,"Category1", "Content1", (long)0));
        informations.add(new Information((long)2,"Category2", "Content2", (long)0));
        informations.add(new Information((long)3,"Category3", "Content3", (long)0));
        informations.add(new Information((long)4,"Category4", "Content4", (long)0));
        informations.add(new Information((long)5,"Category5", "Content5", (long)0));
        informations.add(new Information((long)6,"Category6", "Content6", (long)0));
        informations.add(new Information((long)7,"Category7", "Content7", (long)0));
        informations.add(new Information((long)8,"Category8", "Content8", (long)0));
        informations.add(new Information((long)9,"Category9", "Content9", (long)0));
        informations.add(new Information((long)10,"Category10", "Content10", (long)0));
        return informations;
    }

    public static ArrayList<Information> getSubCategories(){
        ArrayList<Information> subCategories = new ArrayList<Information>();
        subCategories.add(new Information((long)11,"SubCategory11","Content11", (long)1));
        subCategories.add(new Information((long)12,"SubCategory12","Content12", (long)1));
        subCategories.add(new Information((long)13,"SubCategory13","Content13", (long)1));
        subCategories.add(new Information((long)14,"SubCategory14","Content14", (long)1));
        subCategories.add(new Information((long)15,"SubCategory15","Content15", (long)1));
        subCategories.add(new Information((long)16,"SubCategory16","Content16", (long)1));
        subCategories.add(new Information((long)17,"SubCategory17","Content17", (long)1));
        subCategories.add(new Information((long)18,"SubCategory18","Content18", (long)1));
        subCategories.add(new Information((long)19,"SubCategory19","Content19", (long)1));
        subCategories.add(new Information((long)20,"SubCategory20","Content20", (long)1));
        return subCategories;
    }

    public static boolean isFireBaseConnection(){
        return false;
    }

    public static boolean isContent(){
        return true;
    }

    public static ArrayList<Information> getMainCategory(){
        ArrayList<Information> informations = new ArrayList<Information>();
        informations.add(new Information("Culture and arts","", Library.MAIN_CATEGORY));
        informations.add(new Information("Geography and places","", Library.MAIN_CATEGORY));
        informations.add(new Information("Health and fitness","", Library.MAIN_CATEGORY));
        informations.add(new Information("Mathematics and logic","", Library.MAIN_CATEGORY));
        informations.add(new Information("Natural and physical sciences","", Library.MAIN_CATEGORY));
        informations.add(new Information("People and self","", Library.MAIN_CATEGORY));
        informations.add(new Information("Philosophy and thinking","", Library.MAIN_CATEGORY));
        informations.add(new Information("Religion and belief systems","", Library.MAIN_CATEGORY));
        informations.add(new Information("Society and social sciences","", Library.MAIN_CATEGORY));
        informations.add(new Information("Technology and applied sciences","", Library.MAIN_CATEGORY));
        return informations;
    }
}
