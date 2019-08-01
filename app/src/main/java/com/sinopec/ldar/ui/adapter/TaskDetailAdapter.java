package com.sinopec.ldar.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sinopec.ldar.R;
import com.sinopec.ldar.ui.view.OnAdapterItemClickListener;
import com.sinopec.ldar.ui.view.RecyclerItemView;

import java.util.List;
import java.util.Map;

public class TaskDetailAdapter extends RecyclerView.Adapter<TaskDetailAdapter.ViewHolder> {

    private Context context;
    private List<Map<String, Object>> cards;

    private OnAdapterItemClickListener adapterItemClickListener;

    public TaskDetailAdapter(Context context,
                             List<Map<String, Object>> dataImage) {
        this.context = context;
        this.cards=dataImage;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_task_detail_recycler, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.name.setText(cards.get(position).get("cardId").toString());
        holder.progress.setText("12/90");
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public void setOnItemClick(OnAdapterItemClickListener onItemClick) {
        this.adapterItemClickListener = onItemClick;
    }

    class ViewHolder extends  RecyclerView.ViewHolder {

        private TextView name;//分区名称
        private TextView progress;//进度

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.item_task_detail_tv_subreginName);
            progress=view.findViewById(R.id.item_task_detail_tv_progress);
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
