package com.example.hectorvera.ezinfo.lib;

import android.util.Log;

import com.example.hectorvera.ezinfo.Category;
import com.example.hectorvera.ezinfo.FBConnection;
import com.example.hectorvera.ezinfo.Info;
import com.example.hectorvera.ezinfo.POJO.Information;
import com.example.hectorvera.ezinfo.POJO.Relation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    public static ArrayList<Information> getSubCategoriesD(){
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
        informations.add(new Information("History and events","", Library.MAIN_CATEGORY));
        informations.add(new Information("Mathematics and logic","", Library.MAIN_CATEGORY));
        informations.add(new Information("Natural and physical sciences","", Library.MAIN_CATEGORY));
        informations.add(new Information("People and self","", Library.MAIN_CATEGORY));
        informations.add(new Information("Philosophy and thinking","", Library.MAIN_CATEGORY));
        informations.add(new Information("Religion and belief systems","", Library.MAIN_CATEGORY));
        informations.add(new Information("Society and social sciences","", Library.MAIN_CATEGORY));
        informations.add(new Information("Technology and applied sciences","", Library.MAIN_CATEGORY));
        return informations;
    }

    public static ArrayList<Information> getSubCategories(){
        ArrayList<Information> informations = new ArrayList<Information>();
        informations.add(new Information("Culture","", Library.SUB_CATEGORIES));
        informations.add(new Information("Art","", Library.SUB_CATEGORIES));
        informations.add(new Information("Recreation and Entretainment","", Library.SUB_CATEGORIES));
        informations.add(new Information("Geography","", Library.SUB_CATEGORIES));
        informations.add(new Information("America","", Library.SUB_CATEGORIES));
        informations.add(new Information("Africa","", Library.SUB_CATEGORIES));
        informations.add(new Information("Asia","", Library.SUB_CATEGORIES));
        informations.add(new Information("Europe","", Library.SUB_CATEGORIES));
        informations.add(new Information("Ocenia","", Library.SUB_CATEGORIES));
        informations.add(new Information("Health","", Library.SUB_CATEGORIES));
        informations.add(new Information("Self-care","", Library.SUB_CATEGORIES));
        informations.add(new Information("Health-science","", Library.SUB_CATEGORIES));
        informations.add(new Information("Tecnology","", Library.SUB_CATEGORIES));
        informations.add(new Information("Computing and Information technology","", Library.SUB_CATEGORIES));
        informations.add(new Information("Transport","", Library.SUB_CATEGORIES));
        informations.add(new Information("Language","", Library.SUB_CATEGORIES));
        informations.add(new Information("Literature","", Library.SUB_CATEGORIES));
        informations.add(new Information("Food","", Library.SUB_CATEGORIES));
        informations.add(new Information("Atlas","", Library.SUB_CATEGORIES));
        informations.add(new Information("United States","", Library.SUB_CATEGORIES));
        informations.add(new Information("Computer progamming","", Library.SUB_CATEGORIES));
        informations.add(new Information("English","", Library.SUB_CATEGORIES));
        informations.add(new Information("Spanish","", Library.SUB_CATEGORIES));
        informations.add(new Information("Book","", Library.SUB_CATEGORIES));
        informations.add(new Information("Comics","", Library.SUB_CATEGORIES));
        informations.add(new Information("Chinese","", Library.SUB_CATEGORIES));
        informations.add(new Information("Mexican","", Library.SUB_CATEGORIES));
        informations.add(new Information("Island","", Library.SUB_CATEGORIES));
        informations.add(new Information("Mountains","", Library.SUB_CATEGORIES));
        informations.add(new Information("Georgia","", Library.SUB_CATEGORIES));
        informations.add(new Information("Android","", Library.SUB_CATEGORIES));
        informations.add(new Information("Grammar","", Library.SUB_CATEGORIES));
        informations.add(new Information("Science - Fiction","", Library.SUB_CATEGORIES));
        informations.add(new Information("Marvel","", Library.SUB_CATEGORIES));
        informations.add(new Information("Rice","", Library.SUB_CATEGORIES));
        informations.add(new Information("Mole","", Library.SUB_CATEGORIES));
        informations.add(new Information("Everest","", Library.SUB_CATEGORIES));
        informations.add(new Information("Atlanta","", Library.SUB_CATEGORIES));
        informations.add(new Information("Context","", Library.SUB_CATEGORIES));
        informations.add(new Information("Services","", Library.SUB_CATEGORIES));
        return informations;
    }

    public static ArrayList<Information> getContent(){
        ArrayList<Information> informations = new ArrayList<Information>();
        informations.add(new Information("Android","Android content", Library.CONTENT_FLAG));
        informations.add(new Information("Grammar","Grammar content", Library.CONTENT_FLAG));
        informations.add(new Information("Science - Fiction","Science - Fiction content", Library.CONTENT_FLAG));
        informations.add(new Information("Marvel","Marvel content", Library.CONTENT_FLAG));
        informations.add(new Information("Rice","Rice content", Library.CONTENT_FLAG));
        informations.add(new Information("Mole","Mole content", Library.CONTENT_FLAG));
        informations.add(new Information("Everest","Everest content", Library.CONTENT_FLAG));
        informations.add(new Information("Atlanta","Atlanta content", Library.CONTENT_FLAG));
        informations.add(new Information("Context","Context content", Library.CONTENT_FLAG));
        informations.add(new Information("Services","Service content", Library.CONTENT_FLAG));
        return informations;
    }

    public static ArrayList<Relation> getRelations(){

        ArrayList<Relation> relations = new ArrayList<Relation>();
        relations.add(new Relation(1L,12L,1L));
        relations.add(new Relation(1L,13L,2L));
        relations.add(new Relation(1L,14L,3L));
        relations.add(new Relation(2L,15L,4L));
        relations.add(new Relation(2L,16L,5L));
        relations.add(new Relation(2L,17L,6L));
        relations.add(new Relation(2L,18L,7L));
        relations.add(new Relation(2L,19L,8L));
        relations.add(new Relation(2L,20L,9L));
        relations.add(new Relation(3L,21L,10L));
        relations.add(new Relation(3L,22L,11L));
        relations.add(new Relation(3L,23L,12L));
        relations.add(new Relation(11L,24L,13L));
        relations.add(new Relation(11L,25L,14L));
        relations.add(new Relation(11L,26L,15L));
        relations.add(new Relation(12L,27L,16L));
        relations.add(new Relation(13L,28L,17L));
        relations.add(new Relation(14L,29L,18L));
        relations.add(new Relation(15L,30L,19L));
        relations.add(new Relation(16L,31L,20L));
        relations.add(new Relation(25L,32L,21L));
        relations.add(new Relation(27L,33L,22L));
        relations.add(new Relation(27L,34L,23L));
        relations.add(new Relation(28L,35L,24L));
        relations.add(new Relation(28L,36L,25L));
        relations.add(new Relation(29L,37L,26L));
        relations.add(new Relation(29L,38L,27L));
        relations.add(new Relation(30L,39L,28L));
        relations.add(new Relation(30L,40L,29L));
        relations.add(new Relation(31L,41L,30L));
        relations.add(new Relation(33L,43L,31L));
        relations.add(new Relation(34L,43L,32L));
        relations.add(new Relation(35L,44L,33L));
        relations.add(new Relation(36L,45L,34L));
        relations.add(new Relation(37L,46L,35L));
        relations.add(new Relation(38L,47L,36L));
        relations.add(new Relation(40L,48L,37L));
        relations.add(new Relation(41L,49L,38L));
        relations.add(new Relation(42L,50L,39L));
        relations.add(new Relation(42L,51L,40L));
        relations.add(new Relation(43L,53L,41L));
        relations.add(new Relation(44L,54L,42L));
        relations.add(new Relation(45L,55L,43L));
        relations.add(new Relation(46L,56L,44L));
        relations.add(new Relation(47L,57L,45L));
        relations.add(new Relation(48L,58L,46L));
        relations.add(new Relation(49L,59L,47L));
        relations.add(new Relation(50L,60L,48L));
        relations.add(new Relation(51L,61L,49L));
        relations.add(new Relation(32L,42L,50L));
        return relations;
    }

    public static List<Info> getMainCategoryFB(){
        Log.d("GET MAIN CATE ", "HAPPENED!");
        List<Category> cates =  FBConnection.readLCategory("");
        List<Info> infos = new LinkedList<Info>();
        for (Category c:cates)
        {
            Info i = new Info();
            i.setName(c.getName());
            i.setParent(c.getParent());
            infos.add(i);
        }
        return infos;

    }
}
