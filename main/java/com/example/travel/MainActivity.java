package com.example.travel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements PropertyAdapter.OnRowClickListener {
    RecyclerView propertyRecyclerView;
    PropertyAdapter propertyAdapter;
    List<Property> propertyList = new ArrayList<>();  // <com.example.realestate.Property>

    Integer[] imageList = {R.drawable.bimage, R.drawable.simage, R.drawable.bimage, R.drawable.simage, R.drawable.bimage, R.drawable.simage, R.drawable.bimage, R.drawable.simage};
    String[] headline = {"Tourist attractions 1", "Tourist attractions 2", "Tourist attractions 3", "Tourist attractions 4", "Tourist attractions 5", "Tourist attractions 6", "Tourist attractions 7", "tourist attractions 8"};
    String[] subtitle = {"This is a beautiful place!", "This is a beautiful place!", "This is a beautiful place!", "This is a beautiful place!", "This is a beautiful place!", "This is a beautiful place!", "This is a beautiful place!", "This is a beautiful place!"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        propertyRecyclerView = findViewById(R.id.propertyRecyclerView);
        propertyAdapter = new PropertyAdapter(propertyList, MainActivity.this, this);
        propertyRecyclerView.setAdapter(propertyAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        propertyRecyclerView.setLayoutManager(layoutManager);

        for (int i = 0; i < imageList.length; i++) {
            Property property = new Property(i, imageList[i], headline[i], subtitle[i]);
            propertyList.add(property);
        }

        RecyclerView rvBanner = findViewById(R.id.rvBanner);
        BannerAdapter bannerAdapter = new BannerAdapter(propertyList, MainActivity.this);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvBanner.setLayoutManager(layoutManager1);
        rvBanner.setAdapter(bannerAdapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("Property", propertyList.get(position));
        startActivity(intent);
    }
}