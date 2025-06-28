package com.example.sample_exercise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ImgAdapter extends RecyclerView.Adapter<ImgAdapter.ViewHolder> {

    private List<ProductItem> imgList;
    private onImageClickListener listener;


    public interface onImageClickListener  {
        void onImageClick(int imageResId);
    }
    public ImgAdapter(List<ProductItem>imgList,onImageClickListener listener){
        this.imgList=imgList;
        this.listener=listener;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent,int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.img_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductItem productItem=imgList.get(position);
        holder.imgview.setImageResource(productItem.getImageResId());
        holder.itemView.setOnClickListener(v -> listener.onImageClick(productItem.getImageResId()));
    }

    @Override
    public int getItemCount() {
        return imgList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgview;
        public ViewHolder(@NotNull View itemView){
            super(itemView);
            imgview=itemView.findViewById(R.id.imgItem);
        }
    }
}
