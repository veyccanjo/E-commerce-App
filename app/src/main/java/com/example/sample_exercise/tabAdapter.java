package com.example.sample_exercise;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class tabAdapter extends RecyclerView.Adapter<tabAdapter.TabViewHolder> {

    private List<TabItem> tabList;
    private int selectedPosition=0;

    public tabAdapter(List<TabItem> tabList){
        this.tabList=tabList;
    }

    @NonNull
    @Override
    public TabViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);

        return new TabViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TabViewHolder holder, int position) {

        TabItem item=tabList.get(position);
        holder.tabText.setText(item.getTitle());
        holder.tabMirror.setText(item.getTitle());

        if(item.isSelected()){
            holder.tabText.setTextColor(Color.BLACK);
            holder.tabMirror.setVisibility(View.VISIBLE);
        }else{
            holder.tabText.setTextColor(Color.GRAY);
            holder.tabMirror.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<tabList.size();i++){
                    tabList.get(i).setSelected(i==position);
                }
                notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getItemCount() {
        return tabList.size();
    }

    public static class TabViewHolder extends RecyclerView.ViewHolder{
        TextView tabText,tabMirror;

        public TabViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tabText = itemView.findViewById(R.id.tabText);
            this.tabMirror = itemView.findViewById(R.id.tabMirror);
        }
    }
}
