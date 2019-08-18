package com.sinopec.ldar.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.sinopec.ldar.R;
import com.sinopec.ldar.ui.BaseActivity;
import com.sinopec.ldar.ui.view.CircleProgressbar;

public class CheckInstrumentActivity extends BaseActivity {

    private RadioButton mRbZero;
    private RadioButton mRbStandard;
    private RadioButton mRbDrift;
    private TextView mTvType;
    private EditText mEdZero;
    private EditText mEdStandard;
    private EditText mEdDrift;
    private EditText mEdValue;
    private RadioButton mRbInput;
    private View mLayoutBegin;
    private CircleProgressbar mCircelBar;


    private String mName;

    @Override
    protected void initParams(Bundle bundle) {
        super.initParams(bundle);
        mName = bundle.getString("name");
    }

    CircleProgressbar.OnCountdownProgressListener countdownProgressListener = new CircleProgressbar.OnCountdownProgressListener() {
        @Override
        public void onProgress(int what, int progress) {
            Logger.i("onProgress--what:" + what + "--progress:" + progress);
            if (progress == 100) {
                mCircelBar.stop();
                mTvRight.setClickable(true);
                mRbInput.setEnabled(true);
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
                Logger.i("---enable:" + mEdZero.isEnabled());
                mRbInput.setChecked(!mEdZero.isEnabled());
                mEdZero.setEnabled(!mEdZero.isEnabled());
                mEdStandard.setEnabled(!mEdStandard.isEnabled());
                mEdDrift.setEnabled(!mEdDrift.isEnabled());
                break;
            case R.id.check_instrument_rb_zero:
                mTvType.setText("零气值");
                mRbStandard.setChecked(!mRbZero.isChecked());
                mRbDrift.setChecked(!mRbZero.isChecked());
                break;
            case R.id.check_instrument_rb_standard:
                mTvType.setText("标准值");
                mRbZero.setChecked(!mRbStandard.isChecked());
                mRbDrift.setChecked(!mRbStandard.isChecked());
                break;
            case R.id.check_instrument_rb_drift:
                mTvType.setText("漂移值");
                mRbZero.setChecked(!mRbDrift.isChecked());
                mRbStandard.setChecked(!mRbDrift.isChecked());
                break;

            case R.id.begin_tv_over:
                Logger.i("---click over---");
                mCircelBar.stop();
                mRbInput.setEnabled(true);
                break;
        }
    }


    @Override
    protected void initListener() {
        super.initListener();
        mRbInput.setOnClickListener(this);
        mLayoutBegin.setOnClickListener(this);
        mRbZero.setOnClickListener(this);
        mRbStandard.setOnClickListener(this);
        mRbDrift.setOnClickListener(this);
        mCircelBar.setCountdownProgressListener(0, countdownProgressListener);
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mRbZero = findViewById(R.id.check_instrument_rb_zero);
        mRbZero.setChecked(true);
        mRbStandard = findViewById(R.id.check_instrument_rb_standard);
        mRbDrift = findViewById(R.id.check_instrument_rb_drift);
        mTvType = findViewById(R.id.begin_tv_type);
        mEdValue = findViewById(R.id.begin_ed_checkValue);
        mEdValue.setEnabled(false);
        mEdZero = findViewById(R.id.check_instrument_ed_zero);
        mEdStandard = findViewById(R.id.check_instrument_ed_standard);
        mEdDrift = findViewById(R.id.check_instrument_ed_drift);
        mEdZero.setEnabled(false);
        mEdStandard.setEnabled(false);
        mEdDrift.setEnabled(false);
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
    protected int bindLayout() {
        return R.layout.activity_check_instrument;
    }

    @Override
    protected String getTitleBarName() {
        return "仪器-" + mName;
    }
}
