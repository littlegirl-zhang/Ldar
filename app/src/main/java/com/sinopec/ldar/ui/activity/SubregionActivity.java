package com.sinopec.ldar.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sinopec.ldar.R;
import com.sinopec.ldar.ui.BaseActivity;

public class SubregionActivity extends BaseActivity {

    private String titleName;

    @Override
    protected boolean isLLRightVisiable() {
        return true;
    }

    @Override
    protected void initParams(Bundle bundle) {
        super.initParams(bundle);
        titleName = bundle.getString("name");
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
    }

    @Override
    protected String getTitleBarName() {
        return "分区" + titleName;
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_subregion;
    }
}
