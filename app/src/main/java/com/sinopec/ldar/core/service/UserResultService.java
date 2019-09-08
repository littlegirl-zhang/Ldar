package com.sinopec.ldar.core.service;

import com.orhanobut.logger.Logger;
import com.sinopec.ldar.core.entity.UserResult;
import com.sinopec.ldar.core.utils.DbUtil;
import com.sinopec.ldar.core.utils.HttpUtil;
import com.sinopec.ldar.core.utils.JsonUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.Call;
import okhttp3.ConnectionSpec;

public class UserResultService {
    /**
     * 获取用户下拉列表
     * @param isNetWell 是否联网
    */
    public List<UserResult> GetUserList(boolean isNetWell) {

        OkHttpUtils.get()
                .url("http://www.csdn.net/")
                .addParams("username", "hyman")
                .addParams("password", "123")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Logger.i("===onError--ex:"+e);
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Logger.i("===onResponse--response:"+response);
                    }
                });
//        List<UserResult> apiResult = new ArrayList<>();
//        if (isNetWell) {
//            //TODO 这儿填上获取用户列表的URL
//            String result = HttpUtil.get("http://58.215.50.72:19000/apkp/TSMServer/applicationBusiness.action", null);
//            if (result != null) {
//                Logger.i(result);
//                return JsonUtil.parseArray(JsonUtil.getData(result), UserResult.class);
//            }
//        }
//        return DbUtil.getInstance().getmDaoSession().getUserResultDao().loadAll();
        return  null;
    }
}
