package com.example.aarproguardtest.bean;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.text.TextUtils;

import java.util.List;

/**
 * Created by WangKai on 2017/11/6.
 */

public class TransferDiffCallback extends DiffUtil.Callback {
    private List<TransferInfo> mOldList;
    private List<TransferInfo> mNewList;


    @Override
    public int getOldListSize() {
        return mOldList == null ? 0 : mOldList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewList == null ? 0 : mNewList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return TextUtils.equals(mOldList.get(oldItemPosition).getId(), mNewList.get(newItemPosition).getId());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        TransferInfo oldInfo = mOldList.get(oldItemPosition);
        TransferInfo newInfo = mNewList.get(newItemPosition);
        if (!newInfo.getAddPrizeAmount().equals(oldInfo.getAddPrizeAmount())) {
            return false;
        }

//                amount
//        multiple
//                lotteryType
//        lotteryTypeName
//                playType
//        playTypeName
//                phase
//        orderType
//                orderTypeName
//        orderCreateType
//                orderCreateTypeName
//        orderWinningStatus
//                orderWinningStatusName
//        orderTicketStatus
//                orderTicketStatusName
//        orderPrizeStatus
//                orderPrizeStatusName
//        pretaxPrizeAmount
//                posttaxPrizeAmount
//        theoreticalMaxPrize
//                orderAddPrizeType
//        orderAddPrizeTypeName
//                addPrizeAmount
//        prizeTime
//                expectedPrizeTime
//        matchNums
//                createdTime
//        transStatus
//                transAmount

        Bundle bundle = new Bundle();

        return false;
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {

        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
