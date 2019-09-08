package com.sinopec.ldar.core.utils;

import android.util.Log;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.GetBuilder;
import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Response;

public class HttpUtil {
    private static HttpUtil INSTANCE;

    public static HttpUtil getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new HttpUtil();
        }
        return INSTANCE;
    }

    public static String get(String url, HashMap<String,String> params) {
        final GetBuilder builder = OkHttpUtils.getInstance().get().url(url);
        if(params!=null){
            for(String key:params.keySet()){
                builder.addParams(key,params.get(key));
            }
        }

        try {
            return builder.build().execute().body().string();
        }catch (Exception e){
            return null;
        }
    }

    public static String post(String url, HashMap<String,String> params) {
        PostFormBuilder postFormBuilder = OkHttpUtils.getInstance().post().url(url);
        for(String key:params.keySet()){
            postFormBuilder.addParams(key,params.get(key));
        }
        try {
            return postFormBuilder.build().execute().body().string();
        }catch (Exception e){
            return null;
        }
    }
}
