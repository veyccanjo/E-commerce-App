package com.example.sample_exercise;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        tabLayout=findViewById(R.id.tablay);
        viewPager=findViewById(R.id.viewPager);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView tabRecyclerView = findViewById(R.id.tabRecyclerView);
        tabRecyclerView.setLayoutManager(
                new LinearLayoutManager(SecondActivity.this, LinearLayoutManager.HORIZONTAL, false)
        );

        List<TabItem> tabs = new ArrayList<>();
        tabs.add(new TabItem("New", true));
        tabs.add(new TabItem("Arrives", false));
        tabs.add(new TabItem("Kichens", false));
        tabs.add(new TabItem("Baby Care", false));
        tabs.add(new TabItem("Men", false));
        tabs.add(new TabItem("Women", false));
        tabs.add(new TabItem("Kids", false));
        tabs.add(new TabItem("Genz", false));

        tabAdapter adapter = new tabAdapter(tabs);
        tabRecyclerView.setAdapter(adapter);

        RecyclerView productRecyclerView = findViewById(R.id.productRecyclerView);
        productRecyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        );

        List<ProductItem> productList = new ArrayList<>();
        productList.add(new ProductItem("AllenSolly", "$1200", R.drawable.img_4, R.drawable.product_search_icon));
        productList.add(new ProductItem("Nike", "$2000", R.drawable.img_1, R.drawable.product_heart_icon));
        productList.add(new ProductItem("PEPE Jeans", "$1500", R.drawable.img_3, R.drawable.product_heart_icon));
        productList.add(new ProductItem("U.S.Polo Assn", "$3000", R.drawable.img, R.drawable.product_heart_icon));


        ProductAdapter productAdapter = new ProductAdapter(productList,SecondActivity.this);
        productRecyclerView.setAdapter(productAdapter);

        RecyclerView productRecyclerView1 = findViewById(R.id.productRecyclerView1);
        productRecyclerView1.setLayoutManager(
                new LinearLayoutManager(SecondActivity.this, LinearLayoutManager.HORIZONTAL, false)
        );
        List<ProductItem> productList1 = new ArrayList<>();
        productList1.add(new ProductItem("Zara", "$2500", R.drawable.img_5, R.drawable.product_heart_icon));
        productList1.add(new ProductItem("Brooklyn", "$600", R.drawable.img_2, R.drawable.product_heart_icon));
        productList1.add(new ProductItem("Adidas", "$1999", R.drawable.img_6, R.drawable.product_heart_icon));
        productList1.add(new ProductItem("Gucci", "$4000", R.drawable.img_7, R.drawable.product_heart_icon));
        ProductAdapter productAdapter1 = new ProductAdapter(productList1,SecondActivity.this);
        productRecyclerView1.setAdapter(productAdapter1);

        //bottom bar
        BottomAdapter bottomAdapter=new BottomAdapter(this);
        viewPager.setAdapter(bottomAdapter);
        new TabLayoutMediator(tabLayout,viewPager,(tab, position)->{
            switch (position){
                case 0:
                    tab.setText("Home");
                    break;
                case 1:
                    tab.setText("Cart");
                    break;
                case 2:
                    tab.setText("Profile");
                    break;
                case 3:
                    tab.setText("Search");
                    break;
            }
        }).attach();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem searchItem=menu.findItem(R.id.find);
        Drawable icon=searchItem.getIcon();
        if(icon!=null){
            icon.setTint(ContextCompat.getColor(SecondActivity.this,R.color.black));
        }
        Context themedContext=new ContextThemeWrapper(SecondActivity.this,R.style.MySearchViewTheme);
        SearchView searchView=new SearchView(themedContext);
        searchItem.setActionView(searchView);


        searchView.setQueryHint("Search products");
        EditText searchEditText=searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(Color.BLACK);
        searchEditText.setHintTextColor(Color.GRAY);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        int id= menuItem.getItemId();
        if(id==R.id.bell){
            Toast.makeText(this,"Notification Clicked",Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }



}