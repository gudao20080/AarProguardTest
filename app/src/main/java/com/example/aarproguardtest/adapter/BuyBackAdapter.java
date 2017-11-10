package com.example.aarproguardtest.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.aarproguardtest.R;
import com.example.aarproguardtest.bean.TransferInfo;

import java.util.List;


/**
 * 彩票回购adapter
 * Created by WangKai on 2017/10/24.
 */
public class BuyBackAdapter extends BaseQuickAdapter<TransferInfo, BaseViewHolder> {
    private RecyclerView.RecycledViewPool mRecycledViewPool;
    public BuyBackAdapter(@Nullable List<TransferInfo> data) {
        super(R.layout.buy_back_info_item, data);

    }

    public void setRecycledViewPool(RecyclerView.RecycledViewPool recycledViewPool) {
        mRecycledViewPool = recycledViewPool;
    }

    @Override
    protected void convert(BaseViewHolder helper, final TransferInfo item) {
        RecyclerView recyclerView = helper.getView(R.id.recyclerview);
        recyclerView.setRecycledViewPool(mRecycledViewPool);
        final List<TransferInfo.TransferMatch> list = item.getMatchList();

//        final LinearLayout linearLayout = helper.getView(R.id.ll_sub_items);
        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false);

        layoutManager.setInitialPrefetchItemCount(1);
        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setRecycledViewPool(getRecyclerView().getRecycledViewPool());
        final BuyBackSubAdapter subAdapter = new BuyBackSubAdapter(list);

        subAdapter.setAllData(item.getMatchList());
        subAdapter.expand(item.isExpand());
//        recyclerView.setAdapter(subAdapter);


        ImageView ivJiajiang = helper.getView(R.id.iv_jiajiang);
        ivJiajiang.setVisibility(View.VISIBLE);
        helper.setText(R.id.tv_play_name, "胜平负 5串1");

        helper.setText(R.id.tv_bet_money, "￥300");

        helper.setText(R.id.tv_bonus, "￥50000000000.12");
        helper.setText(R.id.tv_play_name, "胜平负");

        helper.setText(R.id.tv_date, "2017-10-11 17:26:03");

        Button btnTransfer = helper.getView(R.id.btn_transfer);
        btnTransfer.setText("转让 ￥150");

        helper.setGone(R.id.tv_prompt, false);
//        fillLayout(linearLayout, list);
//        expand(linearLayout, item.isExpand());
        helper.setGone(R.id.iv_arrow, list.size() > 1 ? true : false);
        helper.getView(R.id.iv_arrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setSelected(!v.isSelected());
                item.setExpand(v.isSelected());
                subAdapter.expand(v.isSelected());
//                expand(linearLayout, v.isSelected());


            }
        });

        helper.setTag(R.id.btn_transfer, item);
        helper.addOnClickListener(R.id.btn_transfer);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);

    }
}

