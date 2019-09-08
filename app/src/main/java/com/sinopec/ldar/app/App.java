package com.sinopec.ldar.app;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.sinopec.ldar.core.utils.DbUtil;
import com.sinopec.ldar.utils.AppUtils;
import com.sinopec.ldar.utils.LogCatStrategy;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;


public class App extends Application {

    private static final String TAG = "LDAR";
    public static final boolean isDebug = true;

    @Override
    public void onCreate() {
        super.onCreate();

        // Logger初始化
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)// (Optional) Whether to show thread info or not. Default true
                .methodCount(1)         // (Optional) How many method line to show. Default 2
                .methodOffset(9)        // (Optional) Hides internal method calls up to offset. Default 5
                .logStrategy(new LogCatStrategy()) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag(TAG)   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));


        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new
                LoggerInterceptor(TAG))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS).readTimeout(50000L, TimeUnit
                        .MILLISECONDS)
                .build();


        // OkHttpUtils初始化
        OkHttpUtils.initClient(okHttpClient);
        AppUtils.init(getApplicationContext());

    }

}
