package com.sinopec.ldar.ui;

import android.content.Context;
import android.view.View;

public class BaseActivity extends ABActivity{

    @Override
    protected void afterOnCreate() {

    }

    @Override
    protected String getTitleBarName() {
        return null;
    }

    @Override
    protected String getRightFunName() {
        return null;
    }

    @Override
    protected int bindLayout() {
        return 0;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void widgetClick(View view) {

    }

    @Override
    protected void doBusiness(Context context) {

    }

    @Override
    protected boolean isIvBackGone() {
        return false;
    }

    @Override
    protected boolean isTvRightGone() {
        return true;
    }

    @Override
    protected boolean isTitlePanelGone() {
        return false;
    }

    @Override
    protected boolean isLLRightVisiable() {
        return true;
    }
}
