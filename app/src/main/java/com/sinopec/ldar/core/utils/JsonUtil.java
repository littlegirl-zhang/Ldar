package com.sinopec.ldar.core.utils;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;

import java.util.List;


public class JsonUtil {


    private static final String SUCCESS = "IsSuccess";
    private static final String MSG = "Msg";
    private static final String DATA = "Data";
    private static final String ERROR = "Error";
//    private static final String OBJ = "objData";

    public static <T> T parseObject(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    public static boolean isSuccess(String json) {
        if (TextUtils.isEmpty(json)) {
            return false;
        } else {
            return JSON.parseObject(json).getBooleanValue(SUCCESS);
        }
    }

    public static String getError(String json) {
        return JSON.parseObject(json).getString(ERROR);
    }

    public static String getMsg(String json) {
        return JSON.parseObject(json).getString(MSG);
    }

    public static String getData(String json) {
        return JSON.parseObject(getMsg(json)).getString(DATA);
    }


//    public static String getObj(String json) {
//        return JSON.parseObject(json).getString(OBJ);
//    }

    public static <T> List<T> parseArray(String json, Class<T> clazz) {

        return JSON.parseArray(json, clazz);
    }


}
