package com.sinopec.ldar.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.orhanobut.logger.Logger;
import com.sinopec.ldar.R;
import com.sinopec.ldar.mvp.model.entity.InstrumentChildValue;
import com.sinopec.ldar.ui.activity.AddNewActivity;
import com.sinopec.ldar.ui.activity.CheckBgActivity;
import com.sinopec.ldar.ui.activity.CheckInstrumentActivity;
import com.sinopec.ldar.ui.adapter.BgAdapter;
import com.sinopec.ldar.ui.adapter.InstrumentCheckAdapter;
import com.sinopec.ldar.ui.view.OnAdapterItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class FragmentBg extends Fragment {

    private RecyclerView mRecyclerView;
    private BgAdapter mAdapter;

    private List<?> mList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bg, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        mRecyclerView = view.findViewById(R.id.bg_recycler);
        //将 RecyclerView 布局设置为线性布局
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new BgAdapter(mList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter.setAdapterItemClickListener(new OnAdapterItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //如果没有数据就跳转
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                bundle.putString("name","常压装置");
                intent.putExtras(bundle);
                intent.setClass(getActivity(), CheckBgActivity.class);
                startActivity(intent);
            }
        });
    }
}
