package com.example.hectorvera.ezinfo.lib;

import static com.example.hectorvera.ezinfo.lib.Library.*;

/**
 * Created by User on 10/26/2016.
 */

public class DbLibrary {
    public static String CREATE_INFORMATION_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_I + " ("
            + I_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            I_NAME + " TEXT, " +
            I_CONTENT + " TEXT, " +
            I_IS_TOP_LEVEL+ " INTEGER DEFAULT 0 )";

    public static String CREATE_RELATION_TABLE = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME_R + "("
            + R_PARENT_ID + " INTEGER, "
            + Library.R_CONTENT_ID + " INTEGER, "
            + Library.R_RANK + " INTEGER )";

    public static String DROP_INFORMATION_TABLE = "DROP TABLE IF EXIST "+ Library.TABLE_NAME_I;

    public static String DROP_RELATION_TABLE = "DROP TABLE IF EXIST "+ Library.TABLE_NAME_R;

    public static String SELECT_INFORMATION = "SELECT I.*, R."+R_RANK+
            " FROM " + TABLE_NAME_I + " AS I INNER JOIN " +
            Library.TABLE_NAME_R + " AS R " +
            "WHERE I.id = R."+R_CONTENT_ID +
            " AND R."+Library.R_PARENT_ID + "= ?";

    public static String SELECT_SEARCH = "SELECT * FROM "+ Library.TABLE_NAME_I +
            " WHERE ("+Library.I_NAME+ " LIKE %?% OR " +
            Library.I_CONTENT + " LIKE %?%) AND (" +
            Library.I_IS_TOP_LEVEL +"= ?)";

    public static String DELETE_RELATION = "DELETE FROM "+TABLE_NAME_R
            + " WHERE "+R_CONTENT_ID+"=?";

    public static String DELETE_INFORMATION = "DELETE FROM "+TABLE_NAME_I
            + " WHERE "+I_ID+"=?";
}
