package com.sinopec.ldar.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sinopec.ldar.R;
import com.sinopec.ldar.ui.BaseActivity;

public class TaskDetailActivity extends BaseActivity {

    @Override
    protected int bindLayout() {
        return R.layout.activity_task_detail;
    }

    @Override
    protected String getTitleBarName() {
        return "任务详情";
    }


}
