package com.sinopec.ldar.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.sinopec.ldar.R;
import com.sinopec.ldar.mvp.model.entity.InstrumentCheckItem;
import com.sinopec.ldar.mvp.model.entity.InstrumentChildValue;
import com.sinopec.ldar.mvp.model.entity.InstrumentGroupDate;
import com.sinopec.ldar.ui.view.OnAdapterItemClickListener;
import com.sinopec.ldar.utils.DateUtil;

import java.util.List;

public class InstrumentCheckAdapter extends RecyclerView.Adapter {


    private List<InstrumentCheckItem> mList;

    public InstrumentCheckAdapter(List<InstrumentCheckItem> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case InstrumentCheckItem.TYPE_GROUP:
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_instrument_check_dategroup, viewGroup, false);
                GroupViewHolder groupViewHolder = new GroupViewHolder(view);
                return groupViewHolder;

            case InstrumentCheckItem.TYPE_CHILD:
                View viewChild = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_instrument_check_valuechild, viewGroup, false);
                ChildViewHolder childViewHolder = new ChildViewHolder(viewChild);
                return childViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        InstrumentCheckItem item = mList.get(position);
        Logger.i("====item:"+item);
        switch (getItemViewType(position)) {
            case InstrumentCheckItem.TYPE_GROUP:
                Logger.i("===group");
                InstrumentGroupDate date = (InstrumentGroupDate) item;
                GroupViewHolder groupVH = (GroupViewHolder) viewHolder;
                groupVH.date.setText(DateUtil.timeStamp2Date(date.getDate(),null));
                break;

            case InstrumentCheckItem.TYPE_CHILD:
                Logger.i("===child");
                InstrumentChildValue child = (InstrumentChildValue) item;
                ChildViewHolder childVH = (ChildViewHolder) viewHolder;
                childVH.device.setText(child.getName());
                childVH.zero.setText(child.getZeroValue()+"");
                childVH.standard.setText(child.getStandardValue()+"");
                childVH.drift.setText(child.getDriftValue()+"");
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        Logger.i("===type:"+mList.get(position).getType());
        return mList.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class GroupViewHolder extends RecyclerView.ViewHolder {

        private TextView date;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.item_check_group_date);
        }
    }

    class ChildViewHolder extends RecyclerView.ViewHolder {

        private TextView device;
        private EditText zero;
        private EditText standard;
        private EditText drift;
        private RadioButton isInput;

        public ChildViewHolder(@NonNull final View itemView) {
            super(itemView);
            device = itemView.findViewById(R.id.item_check_child_device);
            zero = itemView.findViewById(R.id.item_check_child_zero);
            standard = itemView.findViewById(R.id.item_check_child_standard);
            drift = itemView.findViewById(R.id.item_check_child_drift);
            isInput = itemView.findViewById(R.id.item_check_child_input);
            zero.setEnabled(false);
            standard.setEnabled(false);
            drift.setEnabled(false);
            isInput.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    isInput.setChecked(!zero.isEnabled());
                    zero.setEnabled(!zero.isEnabled());
                    standard.setEnabled(!standard.isEnabled());
                    drift.setEnabled(!drift.isEnabled());
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (adapterItemClickListener!=null){
                        adapterItemClickListener.onItemClick(itemView,getAdapterPosition());
                    }
                }
            });
        }
    }

    OnAdapterItemClickListener adapterItemClickListener;

    public void setAdapterItemClickListener(OnAdapterItemClickListener adapterItemClickListener) {
        this.adapterItemClickListener = adapterItemClickListener;
    }
}
