package com.sinopec.ldar.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sinopec.ldar.R;
import com.sinopec.ldar.ui.view.OnAdapterItemClickListener;

import java.util.List;
import java.util.Map;

public class SubregionAdapter extends RecyclerView.Adapter<SubregionAdapter.ViewHolder>{

    private Context context;
    private List<Map<String, Object>> cards;

    private OnAdapterItemClickListener adapterItemClickListener;

    public SubregionAdapter(Context context,
                             List<Map<String, Object>> dataImage) {
        this.context = context;
        this.cards=dataImage;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_subregion_recycler, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.desc.setText(cards.get(position).get("cardId").toString());
        holder.pointName.setText(cards.get(position).get("cardId").toString());
        holder.label.setText("999");
        holder.extendNum.setText("a1111");
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public void setOnItemClick(OnAdapterItemClickListener onItemClick) {
        this.adapterItemClickListener = onItemClick;
    }

    class ViewHolder extends  RecyclerView.ViewHolder {

        private TextView pointName;//点位名称
        private TextView label;//标签
        private TextView extendNum;
        private TextView desc;
        private TextView dateValue;//检测值

        public ViewHolder(View view) {
            super(view);
            pointName = view.findViewById(R.id.item_subregion_tv_poiontName);
            label=view.findViewById(R.id.item_subregion_tv_label);
            extendNum=view.findViewById(R.id.item_subregion_tv_extend);
            desc=view.findViewById(R.id.item_subregion_tv_desc);
            dateValue=view.findViewById(R.id.item_subregion_tv_dateValue);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (adapterItemClickListener!=null){
                        adapterItemClickListener.onItemClick(view,getAdapterPosition());
                    }
                }
            });
        }
    }
}
