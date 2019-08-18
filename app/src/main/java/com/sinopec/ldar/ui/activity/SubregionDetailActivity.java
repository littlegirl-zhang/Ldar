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

public class SubregionDetailActivity extends BaseActivity {

    private TextView mTvDesc;
    private TextView mTvLabel;
    private TextView mTvExtend;
    private TextView mTvInstrument;
    private TextView mTvUser;
    private EditText mEdInput;
    private RadioButton mRbInput;
    private View mLayoutBegin;
    private CircleProgressbar mCircelBar;

    private String name;

    @Override
    protected void widgetClick(View view) {
        super.widgetClick(view);
        switch (view.getId()) {
            //点击开始
            case R.id.point_layout_begin:
                Logger.i("---click begin---");
                mLayoutBegin.setVisibility(View.INVISIBLE);
                mCircelBar.setVisibility(View.VISIBLE);
                mRbInput.setEnabled(false);
                mCircelBar.setProgressType(CircleProgressbar.ProgressType.COUNT);
                mCircelBar.setProgress(0);
                mCircelBar.start();
                break;
            //点击手动输入
            case R.id.point_rb_input:
                Logger.i("radiobutton onclick--");
                Logger.i("---enable:" + mEdInput.isEnabled());
                mRbInput.setChecked(!mEdInput.isEnabled());
                setTvRightGone(mEdInput.isEnabled());
                mEdInput.setEnabled(!mEdInput.isEnabled());
                break;
            case R.id.point_tv_over:
                Logger.i("---click over---");
                mCircelBar.stop();
                mRbInput.setEnabled(true);
                break;
        }
    }

    @Override
    protected String getRightFunName() {
        return "保存";
    }

    @Override
    protected void initListener() {
        super.initListener();
        mRbInput.setOnClickListener(this);
        mLayoutBegin.setOnClickListener(this);
//        mCircelBar.setOnClickListener(this);
        mCircelBar.setCountdownProgressListener(0,countdownProgressListener);
    }

    CircleProgressbar.OnCountdownProgressListener countdownProgressListener=new CircleProgressbar.OnCountdownProgressListener() {
        @Override
        public void onProgress(int what, int progress) {
            Logger.i("onProgress--what:"+what+"--progress:"+progress);
            if (progress==100){
                mCircelBar.stop();
                mRbInput.setEnabled(true);
                mCircelBar.setVisibility(View.GONE);
                mLayoutBegin.setVisibility(View.VISIBLE);
            }
        }
    };

    @Override
    protected void initView(View view) {
        super.initView(view);
        mTvDesc = findViewById(R.id.point_tv_desc);
        mTvLabel = findViewById(R.id.point_tv_label);
        mTvExtend = findViewById(R.id.point_tv_extend);
        mTvInstrument = findViewById(R.id.point_tv_insrument);
        mTvUser = findViewById(R.id.point_tv_user);
        mEdInput = findViewById(R.id.point_ed_checkValue);
        mEdInput.setEnabled(false);
        mRbInput = findViewById(R.id.point_rb_input);
        mLayoutBegin = findViewById(R.id.point_layout_begin);
        mCircelBar=findViewById(R.id.point_tv_over);
        mCircelBar.setTimeMillis(10*1000);
        mCircelBar.setProgressColor(getResources().getColor(R.color.c_F38800));
    }

    @Override
    protected String getTitleBarName() {
        return "点位" + name;
    }

    @Override
    protected void initParams(Bundle bundle) {
        super.initParams(bundle);
        name = bundle.getString("name");
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_subregion_detail;
    }
}
