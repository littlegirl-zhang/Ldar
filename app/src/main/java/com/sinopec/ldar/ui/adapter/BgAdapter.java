package com.sinopec.ldar.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.sinopec.ldar.R;
import com.sinopec.ldar.ui.view.OnAdapterItemClickListener;

import java.util.List;

public class BgAdapter extends RecyclerView.Adapter<BgAdapter.ViewHolder> {

    private List<?> lists;

    public BgAdapter(List<?> list) {
        this.lists = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_bg_recycler, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.date.setText("2019-01-23");
        viewHolder.name.setText("常减压装置");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView date;
        private TextView name;
        private EditText value;
        private RadioButton isInput;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.item_bg_tv_date);
            name = itemView.findViewById(R.id.item_bg_tv_name);
            value = itemView.findViewById(R.id.item_bg_ed_value);
            isInput = itemView.findViewById(R.id.item_bg_rb_input);
            value.setEnabled(false);
            isInput.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    isInput.setChecked(!value.isEnabled());
                    value.setEnabled(!value.isEnabled());
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (adapterItemClickListener != null) {
                        adapterItemClickListener.onItemClick(itemView, getAdapterPosition());
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
