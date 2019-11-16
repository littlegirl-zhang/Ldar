package com.sinopec.ldar.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;


import com.orhanobut.logger.Logger;
import com.sinopec.ldar.R;
import com.sinopec.ldar.core.entity.UserResult;
import com.sinopec.ldar.ui.BaseActivity;
import com.sinopec.ldar.ui.fragment.FragmentBg;
import com.sinopec.ldar.ui.fragment.FragmentCheck;
import com.sinopec.ldar.ui.fragment.FragmentTask;

public class MainActivity extends BaseActivity {

    private ImageView mIvExit;
    private RadioGroup mRadioGroup;

    private Fragment fraTemp;
    private Fragment mFragmentTask;
    private Fragment mFragmentCheck;
    private Fragment mFragmentBg;
    private FragmentManager mFragmentManager;

    public static final int TAB_TASK = 0;
    public static final int TAB_CHECK = 1;
    public static final int TAB_BG = 2;

    private String name;
    private UserResult mUserResult;

    @Override
    protected void initParams(Bundle bundle) {
        super.initParams(bundle);
        mUserResult= (UserResult) bundle.getSerializable("userResult");
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mRadioGroup = findViewById(R.id.main_rg);
        mRadioGroup.setOnCheckedChangeListener(checkedChangeListener);
        mIvExit=findViewById(R.id.main_iv_exit);
        mIvExit.setOnClickListener(this);
        changeSelectView(TAB_TASK);
    }

    @Override
    protected void widgetClick(View view) {
        super.widgetClick(view);
        Bundle bundle=new Bundle();
        bundle.putInt("exit",1);
        bundle.putString("user",mUserResult.getName());
        startActivity(LoginActivity.class,bundle);
        finish();
    }

    RadioGroup.OnCheckedChangeListener checkedChangeListener = new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            switch (checkedId) {
                case R.id.main_rb_task:
                    Logger.i("任务列表:");
                    changeSelectView(TAB_TASK);
                    break;

                case R.id.main_rb_check:
                    Logger.i("仪器校验:");
                    changeSelectView(TAB_CHECK);
                    break;

                case R.id.main_rb_bg:
                    Logger.i("背景值:");
                    changeSelectView(TAB_BG);
                    break;

            }
        }
    };


    public void changeSelectView(int index) {
        if (null == mFragmentManager) {
            mFragmentManager = getSupportFragmentManager();
        }
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (fraTemp != null) {
            transaction.hide(fraTemp);
        }
        switch (index) {
            case TAB_TASK:
                if (mFragmentTask == null) {
                    mFragmentTask = new FragmentTask();
                    transaction.add(R.id.fragment_container, mFragmentTask);
                } else {
                    transaction.show(mFragmentTask);
                }
                fraTemp = mFragmentTask;
                break;
            case TAB_CHECK:
                if (mFragmentCheck == null) {
                    mFragmentCheck = new FragmentCheck();
                    transaction.add(R.id.fragment_container, mFragmentCheck);
                } else {
                    transaction.show(mFragmentCheck);
                }
                fraTemp = mFragmentCheck;
                break;
            case TAB_BG:
                if (mFragmentBg == null) {
                    mFragmentBg = new FragmentBg();
                    transaction.add(R.id.fragment_container, mFragmentBg);
                } else {
                    transaction.show(mFragmentBg);
                }
                fraTemp = mFragmentBg;
                break;
        }
        transaction.commit();

    }


    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }


    @Override
    protected boolean isTitlePanelGone() {
        return true;
    }

    @Override
    protected boolean isIvBackGone() {
        return true;
    }
}
