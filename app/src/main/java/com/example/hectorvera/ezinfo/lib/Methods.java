package com.example.hectorvera.ezinfo.lib;

import android.content.Context;
import android.content.res.Configuration;

/**
 * Created by User on 10/25/2016.
 */

public class Methods {

    public static boolean isTablet(Context context){
        boolean xlarge = ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                == Configuration.SCREENLAYOUT_SIZE_XLARGE);
        boolean large = ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                == Configuration.SCREENLAYOUT_SIZE_LARGE);
        return (xlarge || large);
    }
}
