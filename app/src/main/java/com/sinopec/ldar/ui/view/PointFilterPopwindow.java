package com.sinopec.ldar.ui.view;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.sinopec.ldar.R;

public class PointFilterPopwindow extends PopupWindow {

    private String TAG = getClass().getSimpleName();
    private Activity mContext;
    private TextView mTvAll;
    private TextView mTvUncheck;
    private TextView mTvChecked;
    private View contentView;

    public PointFilterPopwindow(Activity context) {
        this.mContext = context;
        initPopView();
    }

    // -----------------------初始化PopView子控件-----------------------//
    private void initPopView() {
        // 一个自定义的布局，作为显示的内容
        contentView = LayoutInflater.from(mContext).inflate(R.layout.pop_point_filter, null);
        setContentView(contentView);
        // 设置宽高
        setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        setHeight(WindowManager.LayoutParams.WRAP_CONTENT);

        setOutsideTouchable(true);
        setFocusable(true);
        setTouchInterceptor(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                Log.i(TAG, "==onTouch:Intercept");
                return false;
            }
        });

        /* ======这句是为了防止popupwindow被弹出的软键盘遮挡====== */
        setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        WindowManager.LayoutParams lp = mContext.getWindow().getAttributes();
        lp.alpha = 0.7f;
        mContext.getWindow().setAttributes(lp);
        // 设置popWindow的显示和消失动画
//        setAnimationStyle(R.style.mypopwindow_anim_style);
        update();
        initView();
    }

    private void initView() {
        mTvAll = contentView.findViewById(R.id.pop_filter_all);
        mTvUncheck = contentView.findViewById(R.id.pop_filter_uncheck);
        mTvChecked = contentView.findViewById(R.id.pop_filter_check);
        mTvAll.setOnClickListener(onClickListener);
        mTvUncheck.setOnClickListener(onClickListener);
        mTvChecked.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.pop_filter_all:
                    Log.i(TAG, "all");
                    break;
                case R.id.pop_filter_uncheck:
                    Log.i(TAG, "uncheck");
                    break;
                case R.id.pop_filter_check:
                    Log.i(TAG, "checked");
                    break;
            }
        }
    };
}
