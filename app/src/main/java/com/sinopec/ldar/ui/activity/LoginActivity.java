package com.sinopec.ldar.ui.activity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.sinopec.ldar.R;
import com.sinopec.ldar.core.entity.UserResult;
import com.sinopec.ldar.core.service.UserResultService;
import com.sinopec.ldar.core.utils.DbUtil;
import com.sinopec.ldar.ui.BaseActivity;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;

public class LoginActivity extends BaseActivity {

    private Spinner mSpUser;
    private Button mBtnLogin;
    private Button mBtnExit;

    private ArrayAdapter mAdapter;
    private List<String> mListUserName;
    private UserResult mSelectUser;
    private List<UserResult> mUserAll;

    private int type = -1;
    private String user;

//    @Override
//    protected void initParams(Bundle bundle) {
//        super.initParams(bundle);
//        if (bundle != null) {
//            type = bundle.getInt("exit");
//            user = bundle.getString("user");
//        }
//        Logger.i("type:" + type + "--user:" + user);
//    }
//
    @Override
    protected void widgetClick(View view) {
        super.widgetClick(view);
        switch (view.getId()) {
            case R.id.login_btn_login:
                if (mSelectUser == null) {
                    showToast("请选择用户");
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("userResult", (Serializable) mSelectUser);
                    startActivity(MainActivity.class, bundle);
                    finish();
                }
                break;
            case R.id.login_btn_exit:
                finish();
                break;
        }

    }

    @Override
    protected void afterOnCreate() {
        super.afterOnCreate();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void doBusiness(Context context) {
        super.doBusiness(context);
        if (type != -1) {
            return;
        }
        //获取登录用户列表
        mUserAll = new ArrayList<>();
        UserResult userResult = new UserResult();
        userResult.setName("张三");
        userResult.setPassword("qw11");
        userResult.setPrdtCellId(2.0);
        userResult.setPrdtCellSname("hsfah");
        userResult.setUserId(3.0);

        UserResult userResult2 = new UserResult();
        userResult2.setName("李四");
        userResult2.setPassword("qw11");
        userResult2.setPrdtCellId(2.0);
        userResult2.setPrdtCellSname("hsfah");
        userResult2.setUserId(3.0);

        UserResult userResult3 = new UserResult();
        userResult3.setName("王五");
        userResult3.setPassword("qw11");
        userResult3.setPrdtCellId(2.0);
        userResult3.setPrdtCellSname("hsfah");
        userResult3.setUserId(3.0);
        mUserAll.add(userResult);
        mUserAll.add(userResult2);
        mUserAll.add(userResult3);
        for (UserResult user :
                mUserAll) {
            if (user != null && !TextUtils.isEmpty(user.getName())) {
                mListUserName.add(user.getName());
            }
        }
        Logger.i("listUser:" + mListUserName);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    UserResultService service = new UserResultService();
//                    mUserAll = service.GetUserList(true);
//                    for (UserResult user :
//                            mUserAll) {
//                        if (user != null && !TextUtils.isEmpty(user.getName())) {
//                            mListUserName.add(user.getName());
//                        }
//                    }
//                    Logger.i("listUser:"+mListUserName);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

    }

    AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            if (i != 0) {
                mSelectUser = mUserAll.get(i - 1);
            } else {
                mSelectUser = null;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    @Override
    protected void initListener() {
        super.initListener();
        mBtnLogin.setOnClickListener(this);
        mBtnExit.setOnClickListener(this);
        mSpUser.setOnItemSelectedListener(itemSelectedListener);
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected boolean isTitlePanelGone() {
        return true;
    }

    @Override
    protected boolean isIvBackGone() {
        return true;
    }


    @Override
    protected void initView(View view) {
        super.initView(view);
//        ActivityCompat.requestPermissions(this, new String[]{android
//                .Manifest.permission.WRITE_EXTERNAL_STORAGE}, 10001);
//
//        DbUtil.getInstance().initGreenDao(getApplicationContext(), "zhf");

        Logger.i("initView");
        mSpUser = findViewById(R.id.login_sp_user);
        mBtnLogin = findViewById(R.id.login_btn_login);
        mBtnExit = findViewById(R.id.login_btn_exit);
        mListUserName = new ArrayList<>();
        if (type != -1) {
            mBtnLogin.setVisibility(View.GONE);
            mBtnExit.setVisibility(View.VISIBLE);
            mListUserName.add(user);
            mSpUser.setEnabled(false);
        } else {
            mBtnLogin.setVisibility(View.VISIBLE);
            mBtnExit.setVisibility(View.GONE);
            mListUserName.add(0, "请选择");
        }
        mAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, mListUserName);
        mSpUser.setAdapter(mAdapter);
    }
}
