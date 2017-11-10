package com.example.aarproguardtest.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.aarproguardtest.R;
import com.example.aarproguardtest.bean.TransferInfo;

import java.util.List;


/**
 * 彩票回购adapter
 * Created by WangKai on 2017/10/24.
 */
public class BuyBackListAdapter extends BaseAdapter {
    private final Context mContext;
    private List<TransferInfo> mList;

    public BuyBackListAdapter(@Nullable List<TransferInfo> data, Context context) {
//        super(R.layout.buy_back_info_item, data, );
        mContext = context;
        mList = data;
    }

//    @Override
//    protected void convert(BaseViewHolder helper, final TransferInfo item) {
//        RecyclerView recyclerView = helper.getView(R.id.recyclerview);
//        List<TransferInfo.TransferMatch> list = item.getMatchList();
//
////        final LinearLayout linearLayout = helper.getView(R.id.ll_sub_items);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false);
//
//        layoutManager.setInitialPrefetchItemCount(1);
//        recyclerView.setLayoutManager(layoutManager);
////        recyclerView.setRecycledViewPool(getRecyclerView().getRecycledViewPool());
//        final BuyBackSubAdapter subAdapter;
//        if (recyclerView.getTag() != null) {
//            subAdapter = (BuyBackSubAdapter) recyclerView.getTag();
//        } else {
//            subAdapter = new BuyBackSubAdapter(list);
//            helper.setTag(R.id.recyclerview, subAdapter);
//            subAdapter.bindToRecyclerView(recyclerView);
//        }
//
//        subAdapter.setAllData(item.getMatchList());
//        subAdapter.expand(item.isExpand());
//
//
//        ImageView ivJiajiang = helper.getView(R.id.iv_jiajiang);
//        ivJiajiang.setVisibility(View.VISIBLE);
//        helper.setText(R.id.tv_play_name, "胜平负 5串1");
//
//        helper.setText(R.id.tv_bet_money, "￥300");
//
//        helper.setText(R.id.tv_bonus, "￥50000000000.12");
//        helper.setText(R.id.tv_play_name, "胜平负");
//
//        helper.setText(R.id.tv_date, "2017-10-11 17:26:03");
//
//        Button btnTransfer = helper.getView(R.id.btn_transfer);
//        btnTransfer.setText("转让 ￥150");
//
//        helper.setGone(R.id.tv_prompt, false);
////        fillLayout(linearLayout, list);
////        expand(linearLayout, item.isExpand());
//        helper.setGone(R.id.iv_arrow, list.size() > 1 ? true : false);
//        helper.getView(R.id.iv_arrow).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                v.setSelected(!v.isSelected());
//                subAdapter.expand(v.isSelected());
////                expand(linearLayout, v.isSelected());
//                item.setExpand(v.isSelected());
//
//
//            }
//        });
//
//        helper.setTag(R.id.btn_transfer, item);
//        helper.addOnClickListener(R.id.btn_transfer);
//    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final TransferInfo item = mList.get(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.buy_back_info_item, null);
            viewHolder = new ViewHolder();
            viewHolder.ivJiajiang = (ImageView) convertView.findViewById(R.id.iv_jiajiang);
            viewHolder.tvPlayName = (TextView) convertView.findViewById(R.id.tv_play_name);
            viewHolder.tvDate = (TextView) convertView.findViewById(R.id.tv_date);
            viewHolder.recyclerview = (RecyclerView) convertView.findViewById(R.id.recyclerview);
            viewHolder.ivArrow = (ImageView) convertView.findViewById(R.id.iv_arrow);
            viewHolder.tvA = (TextView) convertView.findViewById(R.id.tv_a);
            viewHolder.tvBetMoney = (TextView) convertView.findViewById(R.id.tv_bet_money);
            viewHolder.tvB = (TextView) convertView.findViewById(R.id.tv_b);
            viewHolder.tvBonus = (TextView) convertView.findViewById(R.id.tv_bonus);
            viewHolder.tvPrompt = (TextView) convertView.findViewById(R.id.tv_prompt);
            viewHolder.btnTransfer = (Button) convertView.findViewById(R.id.btn_transfer);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.ivJiajiang.setVisibility(View.VISIBLE);
        viewHolder.tvPlayName.setText("胜平负 5串1");
        viewHolder.tvBetMoney.setText("￥300");
        viewHolder.tvBonus.setText("￥50000000000.12");
        viewHolder.tvDate.setText("2017-10-11 17:26:03");
        viewHolder.btnTransfer.setText("转让 ￥150");

        RecyclerView recyclerView = viewHolder.recyclerview;
        List<TransferInfo.TransferMatch> list = item.getMatchList();

        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);
        final BuyBackSubAdapter subAdapter = new BuyBackSubAdapter(list);
        recyclerView.setAdapter(subAdapter);

        subAdapter.expand(item.isExpand());
        viewHolder.ivArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setSelected(!v.isSelected());
                subAdapter.expand(v.isSelected());
                item.setExpand(v.isSelected());


            }
        });

        viewHolder.tvPrompt.setVisibility(View.GONE);
        return convertView;
    }

    public static class ViewHolder {
        ImageView ivJiajiang;
        TextView tvPlayName;
        TextView tvDate;
        RecyclerView recyclerview;
        ImageView ivArrow;
        TextView tvA;
        TextView tvBetMoney;
        TextView tvB;
        TextView tvBonus;
        TextView tvPrompt;
        Button btnTransfer;

    }

}

