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
import android.widget.AdapterView;
import android.widget.Spinner;

import com.orhanobut.logger.Logger;
import com.sinopec.ldar.R;
import com.sinopec.ldar.ui.activity.TaskDetailActivity;
import com.sinopec.ldar.ui.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FragmentTask extends Fragment {

    private Spinner mSpinner;
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;      //item_task_recycler 布局的 适配器
    private List<Map<String, Object>> mList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task, container, false);
        mList = new ArrayList<>();
        initData();
        initViews(view);
        return view;
    }


    private void initData() {
        Map<String, Object> map;
        for (int i = 0; i < 20; i++) {
            map = new HashMap<String, Object>();
            map.put("cardId", "测试测试是十四号 if 好烦嗲破发后到 v 阿迪女哈UI风好大 v 奶茶" + i);
            mList.add(map);
        }

    }

    private void initViews(View view) {
        mSpinner = view.findViewById(R.id.task_sp_sort);
        mRecyclerView = view.findViewById(R.id.task_reyclerview);

        mSpinner.setOnItemSelectedListener(onItemSelectedListener);
        //将 RecyclerView 布局设置为线性布局
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new RecyclerViewAdapter(getActivity(), mList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter.setOnSlidListener(itemSlideClickListener);
        mAdapter.setOnItemClick(adapterItemClickListener);
    }

    RecyclerViewAdapter.OnAdapterItemClickListener adapterItemClickListener=new RecyclerViewAdapter.OnAdapterItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            Intent intent = new Intent();
            intent.setClass(getActivity(), TaskDetailActivity.class);
//                if (bundle != null) {
//                    intent.putExtras(bundle);
//                }
            startActivity(intent);
        }
    };
    RecyclerViewAdapter.OnItemSlideClickListener itemSlideClickListener=new RecyclerViewAdapter.OnItemSlideClickListener() {
        @Override
        public void onDeleteBtnCilck(View view, int position) {
            mAdapter.removeData(position);
        }
    };
    AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Logger.d("onItemSelected:" + i);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };


}
