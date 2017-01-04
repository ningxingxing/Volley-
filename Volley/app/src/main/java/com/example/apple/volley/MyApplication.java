package com.example.apple.volley;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by apple on 16/12/29.
 */

public class MyApplication extends Application {
    public MyApplication() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //Fresco初始化
        Fresco.initialize(getApplicationContext());
    }
}
