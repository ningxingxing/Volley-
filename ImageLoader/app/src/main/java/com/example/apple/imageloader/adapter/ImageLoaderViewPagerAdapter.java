package com.example.apple.imageloader.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.apple.imageloader.Constants;
import com.example.apple.imageloader.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * Created by apple on 17/1/4.
 */

public class ImageLoaderViewPagerAdapter extends PagerAdapter{

    private Context mContext;
    private ImageLoader imageLoader;

    // 使用DisplayImageOptions.Builder()创建DisplayImageOptions
    private DisplayImageOptions options = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.mipmap.ic_launcher) // 设置图片下载期间显示的图片
            .showImageForEmptyUri(R.mipmap.ic_launcher) // 设置图片Uri为空或是错误的时候显示的图片
            .showImageOnFail(R.mipmap.ic_launcher) // 设置图片加载或解码过程中发生错误显示的图片
            .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
            .cacheOnDisk(true) // 设置下载的图片是否缓存在SD卡中
            .imageScaleType(ImageScaleType.EXACTLY)//设置图片解码类型
            .displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角图片
            .bitmapConfig(Bitmap.Config.RGB_565)
            .build(); // 构建完成


    public ImageLoaderViewPagerAdapter(Context context) {
        mContext = context;
        imageLoader = ImageLoader.getInstance();

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ((ViewPager)container).removeView((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = View.inflate(mContext, R.layout.item_imageloader_viewpager,null);

        ImageView iv = (ImageView) view.findViewById(R.id.iv_image);

        imageLoader.displayImage(Constants.IMAGES[position],iv,options);

        ((ViewPager)container).addView(view,0);

        return view;
    }

    @Override
    public int getCount() {
        return Constants.IMAGES.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {


        return view.equals(object);
    }
}
