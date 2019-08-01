package com.sinopec.ldar.utils;

import android.content.Context;


public class AppUtils {

    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    public static Context getAppContext() {
        return mContext;
    }

    private static String userName;

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        AppUtils.userName = userName;
    }

}
