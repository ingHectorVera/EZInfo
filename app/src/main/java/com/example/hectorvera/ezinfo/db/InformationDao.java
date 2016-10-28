package com.example.hectorvera.ezinfo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hectorvera.ezinfo.POJO.Information;
import com.example.hectorvera.ezinfo.POJO.Relation;
import com.example.hectorvera.ezinfo.lib.DbLibrary;
import com.example.hectorvera.ezinfo.lib.Library;

import java.util.ArrayList;

public class InformationDao extends SQLiteOpenHelper {

    public InformationDao(Context context) {
        super(context, Library.DATABASE_NAME, null, Library.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DbLibrary.CREATE_INFORMATION_TABLE);
        db.execSQL(DbLibrary.CREATE_RELATION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DbLibrary.DROP_INFORMATION_TABLE);
        db.execSQL(DbLibrary.DROP_RELATION_TABLE);
        onCreate(db);
    }

    public void addInformation(Information information){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Library.I_NAME, information.getName());
        values.put(Library.I_CONTENT, information.getContent());
        values.put(Library.I_IS_TOP_LEVEL, information.getIsTopLevel());
        db.insert(Library.TABLE_NAME_I, null, values);
        db.close();
    }
    //nuevo
    public void addRelation(long parentId, long contentId, long rank){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Library.R_PARENT_ID, parentId);
        values.put(Library.R_CONTENT_ID, contentId);
        values.put(Library.R_RANK, rank);
        db.insert(Library.TABLE_NAME_R, null, values);
        db.close();
    }
    //nuevo
    public boolean isRelation(long parentId, long contentId){
        boolean flag = false;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Library.TABLE_NAME_R,
                new String[]{Library.R_PARENT_ID},
                Library.R_PARENT_ID+"=? AND "+Library.R_CONTENT_ID+"=?",
                new String[]{parentId+"", contentId+""},
                null,null,null);
        if(cursor.getCount()>0){
            flag = true;
        }
        return flag;
    }

    //nuevo
    public void updateContent(long id, String content){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(DbLibrary.UPDATE_CONTENT,
                new String[]{content, id+""});
    }

    public long getInformationId(String title, String content, Long isTopLevel){
        long index = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Library.TABLE_NAME_I,
                new String[]{Library.I_ID},
                Library.I_NAME+"=? AND "+Library.I_CONTENT+"=? AND "+Library.I_IS_TOP_LEVEL+"=?",
                new String[]{title,content,isTopLevel+""},
                null,null,null);
        if(cursor != null){
            if(cursor.moveToFirst()){
                do{
                    index = cursor.getLong(0);
                }while (cursor.moveToNext());
            }
        }
        return index;
    }

    public ArrayList<Information> getMainCategories(){
        ArrayList<Information> mainCat = new ArrayList<Information>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Library.TABLE_NAME_I,
                new String[]{Library.I_ID, Library.I_NAME, Library.I_CONTENT, Library.I_IS_TOP_LEVEL}, //columns
                Library.I_IS_TOP_LEVEL+"= ?",             //Conditions
                new String[]{Library.MAIN_CATEGORY+""}, //values
                null,null,null);//group by, having, order by
        if(cursor != null){
            if(cursor.moveToFirst()){
                do {
                    mainCat.add(new Information(
                            cursor.getLong(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getLong(3)));
                }while (cursor.moveToNext());
            }
        }
        return mainCat;
    }

    public int countMainCategories(){
        int count = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Library.TABLE_NAME_I,
                new String[]{Library.I_ID, Library.I_NAME, Library.I_CONTENT, Library.I_IS_TOP_LEVEL}, //columns
                Library.I_IS_TOP_LEVEL+"= ?",             //Conditions
                new String[]{Library.MAIN_CATEGORY+""}, //values
                null,null,null);//group by, having, order by
        if(cursor != null){
            count = cursor.getCount();
        }
        return count;
    }

    public ArrayList<Information> getInformation(long parentId){
        ArrayList<Information> informations = new ArrayList<Information>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(DbLibrary.SELECT_INFORMATION, new String[]{parentId+""});
        if(cursor != null){
            if(cursor.moveToFirst()){
                do {
                    long id = cursor.getLong(0);
                    long rank = cursor.getLong(4);
                    Information information = new Information(id,
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getLong(3));
                    information.setRelation(parentId, id, rank);
                    informations.add(information);
                }while (cursor.moveToNext());
            }
        }
        return informations;
    }

    public ArrayList<Information> search(String keyWord){
        int count = 0;
        ArrayList<Information> informations = new ArrayList<Information>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        do{
            if(count == 0){
                cursor = db.rawQuery(DbLibrary.SELECT_SEARCH,
                        new String[]{keyWord, keyWord, Library.MAIN_CATEGORY+""});
            }else if(count == 1){
                cursor = db.rawQuery(DbLibrary.SELECT_SEARCH,
                        new String[]{keyWord, keyWord, Library.SUB_CATEGORIES+""});
            }else if(count == 2){
                cursor = db.rawQuery(DbLibrary.SELECT_SEARCH,
                        new String[]{keyWord, keyWord, Library.CONTENT_FLAG+""});
            }else if(count == 3){
                return null;
            }
            count++;
        }while (cursor == null);
        if(cursor.moveToFirst()){
            do{
                informations.add(new Information(
                   cursor.getLong(0), cursor.getString(1), cursor.getString(2),
                        cursor.getLong(3)));
            }while (cursor.moveToNext());
        }
        return informations;
    }

    public void deleteContent(Information information){
        SQLiteDatabase db = this.getWritableDatabase();
        db.rawQuery(DbLibrary.DELETE_RELATION, new String[]{information.getId()+""});
        db.rawQuery(DbLibrary.DELETE_INFORMATION, new String[]{information.getId()+""});
    }
    @Override
    public synchronized void close() {
        super.close();
    }
}
