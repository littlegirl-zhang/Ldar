package com.sinopec.ldar.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.sinopec.ldar.R;
import com.sinopec.ldar.ui.BaseActivity;
import com.sinopec.ldar.ui.adapter.SubregionAdapter;
import com.sinopec.ldar.ui.adapter.TaskDetailAdapter;
import com.sinopec.ldar.ui.view.OnAdapterItemClickListener;
import com.sinopec.ldar.ui.view.PointFilterPopwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubregionActivity extends BaseActivity {

    private TextView mTvBg;
    private TextView mTvInstrument;
    private TextView mTvUser;
    private RecyclerView mRecyclerView;
    private SubregionAdapter mAdapter;
    private List<Map<String, Object>> mList;

    private PointFilterPopwindow mPopwindow;

    private String titleName;




    @Override
    protected void initParams(Bundle bundle) {
        super.initParams(bundle);
        titleName = bundle.getString("name");
    }

    @Override
    protected void widgetClick(View view) {
        super.widgetClick(view);
        switch (view.getId()){
            case R.id.iv_base_filter:
                showToast("过滤");
                mPopwindow.showAsDropDown(mIvFilter);
                break;
            case R.id.iv_base_search:
                showToast("搜索");
                break;
            case R.id.subregion_tv_bg:
                startActivity(CheckBgActivity.class);
                break;
        }
    }

    OnAdapterItemClickListener onAdapterItemClickListener = new OnAdapterItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            Bundle bundle=new Bundle();
            bundle.putString("name",mList.get(position).get("cardId").toString());
            startActivity(SubregionDetailActivity.class,bundle);
        }
    };

    private void initData() {
        Map<String, Object> map;
        for (int i = 0; i < 20; i++) {
            map = new HashMap<>();
            map.put("cardId", "aa000" + i);
            mList.add(map);
        }

    }

    @Override
    protected void initListener() {
        super.initListener();
        mTvBg.setOnClickListener(this);
        mAdapter.setOnItemClick(onAdapterItemClickListener);
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mTvBg=findViewById(R.id.subregion_tv_bg);
        mTvInstrument=findViewById(R.id.subregion_tv_instrument);
        mTvUser=findViewById(R.id.subregion_tv_user);
        mRecyclerView=findViewById(R.id.subregion_recycler);
        mList = new ArrayList<>();
        initData();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SubregionAdapter(this, mList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mPopwindow=new PointFilterPopwindow(this);
    }

    @Override
    protected boolean isLLRightVisiable() {
        return true;
    }

    @Override
    protected String getTitleBarName() {
        return "分区" + titleName;
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_subregion;
    }
}
