package com.sinopec.ldar.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.sinopec.ldar.R;
import com.sinopec.ldar.ui.view.OnAdapterItemClickListener;
import com.sinopec.ldar.ui.view.RecyclerItemView;
import com.sinopec.ldar.utils.RecyclerUtils;

import java.util.List;
import java.util.Map;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.SimpleHolder>
        implements RecyclerItemView.OnSlideClickListener, View.OnClickListener {

    private Context context;
    private List<Map<String, Object>> cards;

    private OnItemSlideClickListener itemSlideClickListener;
    private OnAdapterItemClickListener adapterItemClickListener;

    private RecyclerItemView itemView;
    private SimpleHolder simpleHolder;
    private int position;

    public TaskAdapter(Context context,
                       List<Map<String, Object>> dataImage) {
        this.context = context;
        this.cards = dataImage;
    }

    @Override
    public SimpleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_task_recycler, parent, false);
        return new SimpleHolder(view);
    }


    @Override
    public void onBindViewHolder(final SimpleHolder holder, final int position) {
        simpleHolder = holder;
        this.position = position;
        holder.desc.setText(cards.get(position).get("taskDesc").toString());
        holder.progress.setText(cards.get(position).get("taskPro")+"");
        holder.lackGb.setOnClickListener(this);
        holder.unchecked.setOnClickListener(this);
        holder.layout_left.getLayoutParams().width = RecyclerUtils.getScreenWidth(context);
        holder.layout_left.setOnClickListener(this);
        holder.delete.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    @Override
    public void onMenuIsOpen(View view) {
        itemView = (RecyclerItemView) view;
    }

    @Override
    public void onDownOrMove(RecyclerItemView recycler) {
        if (menuIsOpen()) {
            if (itemView != recycler) {
                closeMenu();
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.delete:
                Logger.i("---删除---");
                int subscript = simpleHolder.getLayoutPosition();
                if (itemSlideClickListener != null) {
                    itemSlideClickListener.onDeleteBtnCilck(view, subscript);
                }
                break;
            case R.id.layout_left:
                Logger.i("---是否有删除---");
                //判断是否有删除菜单打开
                if (menuIsOpen()) {
                    closeMenu();//关闭菜单
                } else {
                    if (adapterItemClickListener != null) {
                        adapterItemClickListener.onItemClick(view, position);
                    }
                }
                break;
            case R.id.item_task_tv_uncheck:
                Logger.i("---仪器未校验---");
            case R.id.item_task_tv_lackbg:
                Logger.i("---缺少背景值---");
                if (adapterItemClickListener != null) {
                    adapterItemClickListener.onItemClick(view, position);
                }
                break;
        }
    }

    class SimpleHolder extends RecyclerView.ViewHolder {

        private TextView desc;//任务描述
        private TextView progress;//进度
        private TextView date;//日期
        private TextView eqpSort;//常减压装置(装置分类)
        private TextView exported;//已导出文字显示
        private TextView export;//导出
        private TextView lackGb;//缺少背景值
        private TextView unchecked;//未校验仪器
        private TextView delete;//滑动删除
        private View layout_left;//

        public SimpleHolder(View view) {
            super(view);

            desc = view.findViewById(R.id.item_task_tv_desc);
            progress = view.findViewById(R.id.item_task_tv_process);
            date = view.findViewById(R.id.item_task_tv_process);
            eqpSort = view.findViewById(R.id.item_task_tv_sort);
            exported = view.findViewById(R.id.item_task_tv_exported);
            export = view.findViewById(R.id.item_task_tv_export);
            lackGb = view.findViewById(R.id.item_task_tv_lackbg);
            unchecked = view.findViewById(R.id.item_task_tv_uncheck);
            delete = view.findViewById(R.id.delete);
            layout_left = view.findViewById(R.id.layout_left);

            ((RecyclerItemView) view).setSlidingButtonListener(TaskAdapter.this);
        }
    }

    //删除数据
    public void removeData(int position) {
        cards.remove(position);
        notifyDataSetChanged();
        itemView = null;
    }

    //关闭菜单
    public void closeMenu() {
        itemView.closeMenu();
        itemView = null;

    }

    // 判断是否有菜单打开
    public Boolean menuIsOpen() {
        if (itemView != null) {
            return true;
        }
        return false;
    }

    //设置在滑动侦听器上
    public void setOnSlidListener(OnItemSlideClickListener listener) {
        itemSlideClickListener = listener;
    }

    public void setOnItemClick(OnAdapterItemClickListener onItemClick) {
        this.adapterItemClickListener = onItemClick;
    }

    // 在滑动视图上单击侦听器
    public interface OnItemSlideClickListener {
        void onDeleteBtnCilck(View view, int position);
    }
}
