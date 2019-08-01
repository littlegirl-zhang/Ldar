package com.sinopec.ldar.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;


import com.orhanobut.logger.LogStrategy;

public class LogCatStrategy implements LogStrategy {
    @Override
    public void log(int priority, @Nullable String tag, @NonNull String message) {
        Log.println(priority, randomKey() + tag, message);
    }

    private int last;

    private String randomKey() {
        int random = (int) (10 * Math.random());
        if (random == last) {
            random = (random + 1) % 10;
        }
        last = random;
        return String.valueOf(random);
    }

}
