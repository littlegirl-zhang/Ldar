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
import android.widget.Button;


import com.orhanobut.logger.Logger;
import com.sinopec.ldar.R;
import com.sinopec.ldar.core.entity.InstrumentCheckItem;
import com.sinopec.ldar.core.entity.InstrumentChildValue;
import com.sinopec.ldar.core.entity.InstrumentGroupDate;
import com.sinopec.ldar.ui.activity.AddNewActivity;
import com.sinopec.ldar.ui.activity.CheckInstrumentActivity;
import com.sinopec.ldar.ui.adapter.InstrumentCheckAdapter;
import com.sinopec.ldar.ui.view.OnAdapterItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class FragmentCheck extends Fragment {

    private Button mBtnAdd;
    private RecyclerView mRecyclerView;
    private InstrumentCheckAdapter mAdapter;

    private List<InstrumentCheckItem> mList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check, container, false);
        mList=new ArrayList<>();
        InstrumentGroupDate groupDate=new InstrumentGroupDate();
        Logger.i("===date:"+System.currentTimeMillis());
        groupDate.setDate(System.currentTimeMillis());
        mList.add(groupDate);

        InstrumentChildValue childValue=new InstrumentChildValue();
        childValue.setName("NCX0010");
        childValue.setZeroValue(100);
        childValue.setStandardValue(80);
        childValue.setDriftValue(40);
        mList.add(childValue);
        InstrumentChildValue childValue2=new InstrumentChildValue();
        childValue2.setName("NCX0011");
        childValue2.setZeroValue(100);
        childValue2.setStandardValue(80);
        childValue2.setDriftValue(40);
        mList.add(childValue2);
        mList.add(groupDate);
        InstrumentChildValue childValue3=new InstrumentChildValue();
        childValue3.setName("NCX0013");
        childValue3.setZeroValue(100);
        childValue3.setStandardValue(80);
        childValue3.setDriftValue(40);
        mList.add(childValue3);
        Logger.i("====list:"+mList);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        mBtnAdd=view.findViewById(R.id.check_btn_add);
        mRecyclerView = view.findViewById(R.id.check_recycler);
        //将 RecyclerView 布局设置为线性布局
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new InstrumentCheckAdapter(mList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter.setAdapterItemClickListener(new OnAdapterItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Logger.i("---intent");
                InstrumentChildValue childValue= (InstrumentChildValue) mList.get(position);
                if (childValue==null){
                    Intent intent=new Intent();
                    Bundle bundle=new Bundle();
                    bundle.putString("name",childValue.getName());
                    intent.putExtras(bundle);
                    intent.setClass(getActivity(), CheckInstrumentActivity.class);
                    startActivity(intent);
                }
            }
        });
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logger.i("---add new device---");
                Intent intent=new Intent();
                intent.setClass(getActivity(), AddNewActivity.class);
                startActivity(intent);
            }
        });
    }
}
