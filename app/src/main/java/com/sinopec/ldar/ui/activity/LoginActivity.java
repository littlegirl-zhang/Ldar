package com.sinopec.ldar.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.sinopec.ldar.R;
import com.sinopec.ldar.ui.BaseActivity;

public class LoginActivity extends BaseActivity {

    private Spinner mSpUser;
    private Button mBtnLogin;

    @Override
    protected int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected boolean isTitlePanelGone() {
        return true;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mSpUser = findViewById(R.id.login_sp_user);
        mBtnLogin = findViewById(R.id.login_btn_login);
    }
}
