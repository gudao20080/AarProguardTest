package com.example.aarproguardtest.adapter;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.aarproguardtest.R;
import com.example.aarproguardtest.bean.TransferInfo;

import java.util.ArrayList;

/**
 * Created by WangKai on 2017/10/31.
 */
public class BuyBackBetAdapter extends BaseQuickAdapter<TransferInfo.TransferSp, BaseViewHolder> {
    public BuyBackBetAdapter(ArrayList<TransferInfo.TransferSp> list) {
        super(R.layout.buy_back_sub_bet, list);
    }


    @Override
    protected void convert(BaseViewHolder helper, TransferInfo.TransferSp item) {
        helper.setText(R.id.tv_spf, item.getName());
        String addPercent = item.getAddPercent();
        double percent;
        try {
            percent = Double.parseDouble(addPercent) * 100;

        } catch (NumberFormatException e) {
            e.printStackTrace();
            percent = 0.0;
        }

        helper.setText(R.id.tv_rate, item.getJcSp() + "+" + percent + "%");
    }
}
