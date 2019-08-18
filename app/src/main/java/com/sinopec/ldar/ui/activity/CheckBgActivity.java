package com.sinopec.ldar.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.sinopec.ldar.R;
import com.sinopec.ldar.ui.BaseActivity;
import com.sinopec.ldar.ui.view.CircleProgressbar;
import com.sinopec.ldar.utils.DateUtil;

public class CheckBgActivity extends BaseActivity {

    private TextView mTvDate;
    private TextView mTvEquipment;
    private TextView mTvType;
    private EditText mEdValue;
    private RadioButton mRbInput;
    private View mLayoutBegin;
    private CircleProgressbar mCircelBar;

    private String mName;

    CircleProgressbar.OnCountdownProgressListener countdownProgressListener = new CircleProgressbar.OnCountdownProgressListener() {
        @Override
        public void onProgress(int what, int progress) {
            Logger.i("onProgress--what:" + what + "--progress:" + progress);
            if (progress == 100) {
                mCircelBar.stop();
                mRbInput.setEnabled(true);
                mTvRight.setClickable(true);
                mCircelBar.setVisibility(View.GONE);
                mLayoutBegin.setVisibility(View.VISIBLE);
            }
        }
    };

    @Override
    protected void widgetClick(View view) {
        super.widgetClick(view);
        switch (view.getId()) {
            //点击开始
            case R.id.begin_layout_begin:
                Logger.i("---click begin---");
                mTvRight.setClickable(false);
                mLayoutBegin.setVisibility(View.INVISIBLE);
                mCircelBar.setVisibility(View.VISIBLE);
                mRbInput.setEnabled(false);
                mCircelBar.setProgressType(CircleProgressbar.ProgressType.COUNT);
                mCircelBar.setProgress(0);
                mCircelBar.start();
                break;
            //点击手动输入
            case R.id.begin_rb_input:
                Logger.i("radiobutton onclick--");
                Logger.i("---enable:" + mEdValue.isEnabled());
                mRbInput.setChecked(!mEdValue.isEnabled());
                mEdValue.setEnabled(!mEdValue.isEnabled());
                break;
            case R.id.begin_tv_over:
                Logger.i("---click over---");
                mCircelBar.stop();
                mRbInput.setEnabled(true);
                mTvRight.setClickable(true);
                break;
            case R.id.tv_base_right:
                Logger.i("--save--");
                break;
        }
    }


    @Override
    protected void initListener() {
        super.initListener();
        mRbInput.setOnClickListener(this);
        mLayoutBegin.setOnClickListener(this);
        mCircelBar.setCountdownProgressListener(0, countdownProgressListener);
    }
    @Override
    protected void initParams(Bundle bundle) {
        super.initParams(bundle);
        mName = bundle.getString("name");
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mTvDate=findViewById(R.id.check_bg_tv_date);
        mTvDate.setText(DateUtil.timeStamp2Date(System.currentTimeMillis(),null));
        mTvEquipment=findViewById(R.id.check_bg_tv_instrument);
        mTvEquipment.setText(mName);
        mTvType = findViewById(R.id.begin_tv_type);
        mTvType.setText("背景值");
        mEdValue = findViewById(R.id.begin_ed_checkValue);
        mEdValue.setEnabled(false);
        mRbInput = findViewById(R.id.begin_rb_input);
        mLayoutBegin = findViewById(R.id.begin_layout_begin);
        mCircelBar = findViewById(R.id.begin_tv_over);
        mCircelBar.setTimeMillis(10 * 1000);
        mCircelBar.setProgressColor(getResources().getColor(R.color.c_F38800));
    }

    @Override
    protected String getRightFunName() {
        return "保存";
    }

    @Override
    protected boolean isTvRightVisible() {
        return true;
    }

    @Override
    protected boolean isExitVisible() {
        return true;
    }

    @Override
    protected boolean isIvBackGone() {
        return true;
    }
    @Override
    protected String getTitleBarName() {
        return "背景值校验";
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_check_bg;
    }
}
