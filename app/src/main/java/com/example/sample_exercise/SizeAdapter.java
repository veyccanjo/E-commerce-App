package com.example.sample_exercise;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SizeAdapter extends RecyclerView.Adapter<SizeAdapter.SizeViewHolder> {

    private final List<String> sizes;
    private int selectedPosition=-1;
    private final onClickListener listener;

    public interface onClickListener{
        void onSizeSelected(String size);
    }

    public SizeAdapter(List<String> sizes, onClickListener listener) {
        this.sizes = sizes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SizeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.size_layout, parent, false);
        return new SizeViewHolder(view);
    }

    public void onBindViewHolder(@NonNull SizeViewHolder holder, int position) {
        String size = sizes.get(position);
        holder.text.setText(size);

        if (position == selectedPosition) {
            holder.text.setTextColor(Color.WHITE);
            holder.text.setBackgroundResource(R.drawable.size_selected_bg);
        } else {
            holder.text.setTextColor(Color.BLACK);
            holder.text.setBackgroundResource(R.drawable.size_unselected_bg);
        }

        holder.itemView.setOnClickListener(v -> {
            int oldPosition = selectedPosition;
            selectedPosition = position;
            notifyItemChanged(oldPosition);
            notifyItemChanged(selectedPosition);
            listener.onSizeSelected(size);
        });
    }

    @Override
    public int getItemCount() {
        return sizes.size();
    }

    static class SizeViewHolder extends RecyclerView.ViewHolder{
         TextView text;

         public SizeViewHolder(View ItemView){
             super(ItemView);
             text=ItemView.findViewById(R.id.size_text);
         }
     }
}
