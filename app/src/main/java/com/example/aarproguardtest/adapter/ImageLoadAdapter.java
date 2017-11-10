package com.example.aarproguardtest.adapter;

import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.aarproguardtest.R;

import java.util.List;

/**
 * Created by WangKai on 2017/11/10.
 */

public class ImageLoadAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public ImageLoadAdapter(@Nullable List<String> data) {
        super(R.layout.image_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        ImageView imageView = helper.getView(R.id.iv);
        if (imageView.getTag() != null) {
            imageView.setTag(item);
            Log.i("way", item);
        }else {
            Log.i("way", "tag is null");
        }

        Glide.with(imageView.getContext()).load(item).into(imageView);
    }
}
