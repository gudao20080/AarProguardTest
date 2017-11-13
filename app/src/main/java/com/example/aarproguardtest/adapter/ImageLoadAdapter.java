package com.example.aarproguardtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.aarproguardtest.R;
import com.example.aarproguardtest.bean.Info;

import java.util.List;

/**
 * Created by WangKai on 2017/11/10.
 */

public class ImageLoadAdapter extends RecyclerView.Adapter<ImageLoadAdapter.ViewHolder> {
    private Context mContext;
    private List<Info.ResultBean.WareInfo> mList;

    public ImageLoadAdapter(Context context, List<Info.ResultBean.WareInfo> list) {
        mContext = context;
        mList = list;
    }

    public List<Info.ResultBean.WareInfo> getList() {
        return mList;
    }

    public void setList(List<Info.ResultBean.WareInfo> list) {
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        Info.ResultBean.WareInfo wareInfo = mList.get(position);
//        holder.setIsRecyclable(false);
        Log.i("way", "recycleable: " + holder.isRecyclable());
//        if (holder.tv.getTag() != null) {
//            holder.tv.setTag(url);
//            Log.i("way", url);
//        }else {
//            Log.i("way", "tag is null");
//        }

//        Log.i("way", "url-> " + url);
        Glide.with(mContext).load(wareInfo.getImageurl()).into(holder.iv);
        holder.tv.setText(wareInfo.getWname());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView iv;
        TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
