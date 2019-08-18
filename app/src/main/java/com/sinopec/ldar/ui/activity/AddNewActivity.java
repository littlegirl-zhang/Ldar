package com.sinopec.ldar.ui.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.sinopec.ldar.R;
import com.sinopec.ldar.ui.BaseActivity;
import com.sinopec.ldar.ui.view.ChildClickableLinearLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AddNewActivity extends BaseActivity {

    private TextView mTvDate;
    private Spinner mSpInstrument;
    private ChildClickableLinearLayout mLayout;
    private ArrayAdapter mAdapter;
    private DatePickerDialog mDatePickerDialog;

    private List<String> mInstruments;
    private String mIName;


    @Override
    protected void doBusiness(Context context) {
        super.doBusiness(context);
        mInstruments.add("XY0001");
        mInstruments.add("XY0002");
        mInstruments.add("XY0003");
    }

    @Override
    protected void afterOnCreate() {
        super.afterOnCreate();
        mAdapter.notifyDataSetChanged();
        if (Build.VERSION.SDK_INT >= 24) {
            //api24的构造方法
            mDatePickerDialog = new DatePickerDialog(AddNewActivity.this, AlertDialog.THEME_HOLO_LIGHT);
            mDatePickerDialog.setTitle("请选择");
            mDatePickerDialog.setOnDateSetListener(onDateSetListener);
            mDatePickerDialog.getDatePicker().setCalendarViewShown(false);
        } else {
            //api24以下的构造方法
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            mDatePickerDialog = new DatePickerDialog(AddNewActivity.this, AlertDialog.THEME_HOLO_LIGHT, onDateSetListener, year, month, day);
            mDatePickerDialog.setTitle("请选择");
            mDatePickerDialog.getDatePicker().setCalendarViewShown(false);
        }
    }

    @Override
    protected void widgetClick(View view) {
        super.widgetClick(view);
        switch (view.getId()) {
            case R.id.add_new_tv_date:
                mDatePickerDialog.show();
                break;
            case R.id.tv_base_right:
                if (mTvDate.getText().equals("0000-00-00")) {
                    showToast("请选择日期");
                } else if (TextUtils.isEmpty(mIName)) {
                    showToast("请选择仪器");
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("name", mIName);
                    startActivity(CheckInstrumentActivity.class, bundle);
                }
                break;
        }

    }

    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            Logger.i("set--year:" + year + "--month:" + month + "--day:" + day);
            mTvDate.setText(year + "--" + (month + 1) + "--" + day);
        }
    };

    @Override
    protected void initListener() {
        super.initListener();
        mTvDate.setOnClickListener(this);
        mSpInstrument.setOnItemSelectedListener(itemSelectedListener);
    }

    AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            if (i != 0) {
                mIName = mInstruments.get(i);
            } else {
                mIName = null;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    @Override
    protected void initView(View view) {
        super.initView(view);
        mTvDate = findViewById(R.id.add_new_tv_date);
        mSpInstrument = findViewById(R.id.add_new_sp_instrument);
        mLayout = findViewById(R.id.add_new_begin_layout);
        mLayout.setAlpha((float) 0.3);
        mLayout.setChildClickable(false);
        mInstruments = new ArrayList<>();
        mInstruments.add(0, "请选择");
        mAdapter = new ArrayAdapter<>(this, R.layout.spinner_simple_item, mInstruments);
        mAdapter.setDropDownViewResource(R.layout.item_drop_down_simple);
        mSpInstrument.setAdapter(mAdapter);
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_add_new;
    }

    @Override
    protected String getTitleBarName() {
        return "新增仪器校验";
    }

    @Override
    protected String getRightFunName() {
        return "完成";
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
}
