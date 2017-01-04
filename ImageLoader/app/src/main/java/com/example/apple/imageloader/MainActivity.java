package com.example.apple.imageloader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    Button listView;
    @BindView(R.id.gridView)
    Button gridView;
    @BindView(R.id.viewPager)
    Button viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {

    }

    @OnClick({R.id.listView, R.id.gridView, R.id.viewPager})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.listView:
                Intent intent = new Intent(MainActivity.this,ImageLoaderListViewActivity.class);
                startActivity(intent);

                Toast.makeText(getApplication(), "button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.gridView:
                Intent intent1 = new Intent(MainActivity.this,ImageLoaderGridViewActivity.class);
                startActivity(intent1);

                Toast.makeText(getApplication(), "button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.viewPager:
                Intent intent2 = new Intent(MainActivity.this,ImageLoaderViewPagerActivity.class);
                startActivity(intent2);

                Toast.makeText(getApplication(), "button", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
