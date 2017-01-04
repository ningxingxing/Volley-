package com.example.apple.imageloader;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.apple.imageloader.adapter.ImageLoaderViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageLoaderViewPagerActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader_view_pager);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {

        ImageLoaderViewPagerAdapter imageLoaderViewPagerAdapter = new ImageLoaderViewPagerAdapter(this);
        viewPager.setAdapter(imageLoaderViewPagerAdapter);
    }
}
