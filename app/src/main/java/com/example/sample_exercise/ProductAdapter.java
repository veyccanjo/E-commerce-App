package com.example.sample_exercise;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    private List<ProductItem> productList;
    Context context;

    public ProductAdapter(List<ProductItem> productList, Context context) {
        this.productList = productList;
        this.context=context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);

        return new ProductViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductItem item=productList.get(position);
        holder.title.setText(item.getTitle());
        holder.price.setText(item.getPrice());
        holder.img.setImageResource(item.getImageResId());
        holder.icon.setImageResource(item.getIconResID());

        holder.itemView.setOnClickListener(v -> {
            Intent intent=new Intent(context,ThirdActivity.class);
            intent.putParcelableArrayListExtra("productList",new ArrayList<>(productList));
            intent.putExtra("position",position);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
    public static class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView img,icon;
        TextView title,price;
        public ProductViewHolder(View itemView){
            super(itemView);
            img=itemView.findViewById(R.id.Productimage);
            title=itemView.findViewById(R.id.ProductText);
            price=itemView.findViewById(R.id.ProductPrice);
            icon=itemView.findViewById(R.id.icon);
        }
    }
}
