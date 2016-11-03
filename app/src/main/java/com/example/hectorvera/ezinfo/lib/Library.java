package com.example.hectorvera.ezinfo.lib;

/**
 * Created by User on 10/24/2016.
 */

public class Library {

    public static final String DATABASE_NAME = "EZIDB";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME_I = "Information";
    public static final String TABLE_NAME_R = "Relation";

    public static final String I_ID = "Id";
    public static final String I_NAME = "Name";
    public static final String I_CONTENT = "Content";
    public static final String I_IS_TOP_LEVEL = "IsTopLevel";

    public static final String R_PARENT_ID = "ParentId";
    public static final String R_CONTENT_ID = "ContentId";
    public static final String R_RANK = "Rank";

    public static final String BROADCAST_NAME = "com.MAC.Training.InfoReceiver";
    public static final String TITLE = "Title";
    public static final String CONTENT = "Content";
    public static final String PARENT_ID = "parentId";
    public static final String CONNECTION_FLAG_KEY = "ConnectionFlag";
    public static final String IS_OTHER_FLAG = "IsOtherFlag";
    public static final long MAIN_CATEGORY = 0;
    public static final long SUB_CATEGORIES = 1;
    public static final long CONTENT_FLAG = 2;

    public static final String DEBUG = "Debug";
}
