package com.example.apple.imageloader.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.apple.imageloader.Constants;
import com.example.apple.imageloader.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 17/1/4.
 */

public class ImageLoaderGridviewAdapter extends BaseAdapter {

    private Context mContext;
    ImageLoader imageLoader;

    // 使用DisplayImageOptions.Builder()创建DisplayImageOptions
    private DisplayImageOptions options = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.mipmap.ic_launcher) // 设置图片下载期间显示的图片
            .showImageForEmptyUri(R.mipmap.ic_launcher) // 设置图片Uri为空或是错误的时候显示的图片
            .showImageOnFail(R.mipmap.ic_launcher) // 设置图片加载或解码过程中发生错误显示的图片
            .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
            .cacheOnDisk(true) // 设置下载的图片是否缓存在SD卡中
            .displayer(new RoundedBitmapDisplayer(20)) // 设置成圆角图片
            .bitmapConfig(Bitmap.Config.RGB_565)
            .build(); // 构建完成


    public ImageLoaderGridviewAdapter(Context context) {
        mContext = context;

        imageLoader = ImageLoader.getInstance();
    }

    @Override
    public int getCount() {
        return Constants.IMAGES.length;
    }

    @Override
    public Object getItem(int position) {
        return Constants.IMAGES[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;

        if (convertView == null) {

            convertView = View.inflate(mContext, R.layout.item_imageloader_gridview, null);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        imageLoader.displayImage(Constants.IMAGES[position],viewHolder.image,options);

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.image)
        ImageView image;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
