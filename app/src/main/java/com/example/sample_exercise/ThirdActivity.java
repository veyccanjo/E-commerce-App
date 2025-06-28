package com.example.sample_exercise;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {
    ImageView productImage;
    TextView productPrice,productName;
    MaterialToolbar toolbar;
    ShapeableImageView big;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(ThirdActivity.this);
        setContentView(R.layout.activity_third);

        toolbar=findViewById(R.id.toolbar);
        productName=findViewById(R.id.ProductText);
        productPrice=findViewById(R.id.ProductPrice);
        big=findViewById(R.id.bigImg);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(v -> {
            finish();
        });
        RecyclerView imgRecycler=findViewById(R.id.imgrecycler);
        imgRecycler.setLayoutManager(new LinearLayoutManager(ThirdActivity.this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<ProductItem> receivedList=getIntent().getParcelableArrayListExtra("productList");
        int clickedIndex =getIntent().getIntExtra("position",0);
        List<Integer> imageList=new ArrayList<>();
        if (receivedList!=null && !receivedList.isEmpty()){
            ProductItem clickedItem=receivedList.get(clickedIndex);
            big.setImageResource(clickedItem.getImageResId());
            productName.setText(clickedItem.getTitle());
            productPrice.setText(clickedItem.getPrice());

            List<ProductItem> reorderedList=new ArrayList<>();
            reorderedList.add(clickedItem);

            for (int i=0;i<receivedList.size();i++){
                if (i!=clickedIndex){
                    reorderedList.add(receivedList.get(i));
                }

            }
            ImgAdapter adapter=new ImgAdapter(reorderedList,imageResId -> {
                big.setImageResource(imageResId);
            });
            imgRecycler.setAdapter(adapter);

            RecyclerView recyclerView = findViewById(R.id.sizeRecycler);
            recyclerView.setLayoutManager(new LinearLayoutManager(ThirdActivity.this, LinearLayoutManager.HORIZONTAL, false));

            List<String> sizeList = Arrays.asList("S", "M", "L", "XL");
            SizeAdapter sizeAdapter = new SizeAdapter(sizeList, selectedSize -> {});

            recyclerView.setAdapter(sizeAdapter);




        }


    }
}