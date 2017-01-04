package com.example.apple.imageloader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.apple.imageloader.adapter.ImageLoaderListViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageLoaderListViewActivity extends AppCompatActivity {

    @BindView(R.id.lv_imageLoader)
    ListView lvImageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader_list_view);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {

        ImageLoaderListViewAdapter imageLoaderListViewAdapter = new ImageLoaderListViewAdapter(this);
        lvImageLoader.setAdapter(imageLoaderListViewAdapter);
    }
}
