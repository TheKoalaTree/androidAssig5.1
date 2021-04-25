package com.example.travel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends Activity {

    private ImageView propertyImageView;
    private TextView headlineTextView;
    private TextView subtitleTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();


    }

    private void initView() {
        propertyImageView = (ImageView) findViewById(R.id.propertyImageView);
        headlineTextView = (TextView) findViewById(R.id.headlineTextView);
        subtitleTextView = (TextView) findViewById(R.id.subtitleTextView);


        Intent intent = getIntent();
        Property property = (Property) intent.getSerializableExtra("Property");

        propertyImageView.setImageResource(property.getImage());
        headlineTextView.setText(property.getHeadline());
        subtitleTextView.setText(property.getSubtitle());
    }
}
