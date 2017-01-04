package com.example.apple.imageloader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.example.apple.imageloader.adapter.ImageLoaderGridviewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageLoaderGridViewActivity extends AppCompatActivity {

    @BindView(R.id.gridView)
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_loader_grid_view);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {

        ImageLoaderGridviewAdapter imageLoaderGridviewAdapter = new  ImageLoaderGridviewAdapter(this);
        gridView.setAdapter(imageLoaderGridviewAdapter);
    }
}
