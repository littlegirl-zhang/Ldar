package com.sinopec.ldar.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sinopec.ldar.R;
import com.sinopec.ldar.ui.BaseActivity;
import com.sinopec.ldar.ui.adapter.TaskDetailAdapter;
import com.sinopec.ldar.ui.view.OnAdapterItemClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskDetailActivity extends BaseActivity {

    private TextView mTvDesc;
    private TextView mTvProgress;
    private TextView mTvDate;
    private TextView mTvEqpSort;

    private RecyclerView mRecyclerView;
    private TaskDetailAdapter mAdapter;
    private List<Map<String, Object>> mList;

    @Override
    protected void initView(View view) {
        super.initView(view);

        mTvDesc = findViewById(R.id.task_detail_tv_desc);
        mTvProgress = findViewById(R.id.task_detail_tv_process);
        mTvDate = findViewById(R.id.task_detail_tv_date);
        mTvEqpSort = findViewById(R.id.task_detail_tv_sort);

        mRecyclerView = findViewById(R.id.task_detail_recycler);
        mList = new ArrayList<>();
        initData();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new TaskDetailAdapter(this, mList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter.setOnItemClick(onAdapterItemClickListener);
    }

    private void initData() {
        Map<String, Object> map;
        for (int i = 0; i < 20; i++) {
            map = new HashMap<>();
            map.put("cardId", "A000" + i);
            mList.add(map);
        }

    }

    OnAdapterItemClickListener onAdapterItemClickListener = new OnAdapterItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            Bundle bundle=new Bundle();
            bundle.putString("name",mList.get(position).get("cardId").toString());
            startActivity(SubregionActivity.class,bundle);
        }
    };

    private void setDrawableLeft(TextView view, int imgId) {
        // 使用代码设置drawableleft
        Drawable drawable = getResources().getDrawable(imgId);
        // / 这一步必须要做,否则不会显示.
        drawable.setBounds(0, 0, drawable.getMinimumWidth(),
                drawable.getMinimumHeight());
        view.setCompoundDrawables(drawable, null, null, null);
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_task_detail;
    }

    @Override
    protected String getTitleBarName() {
        return "任务详情";
    }


}
