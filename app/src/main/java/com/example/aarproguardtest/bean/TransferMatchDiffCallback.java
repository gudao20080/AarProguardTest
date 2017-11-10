package com.example.aarproguardtest.bean;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.text.TextUtils;

import java.util.List;

/**
 * Created by WangKai on 2017/11/6.
 */

public class TransferMatchDiffCallback extends DiffUtil.Callback {
    private List<TransferInfo.TransferMatch> mOldList;
    private List<TransferInfo.TransferMatch> mNewList;


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
        return TextUtils.equals(mOldList.get(oldItemPosition).getMatchId(), mNewList.get(newItemPosition).getMatchId());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        TransferInfo.TransferMatch oldInfo = mOldList.get(oldItemPosition);
        TransferInfo.TransferMatch newInfo = mNewList.get(newItemPosition);
        if (!newInfo.getMatchNo().equals(oldInfo.getMatchNo())) {
            return false;
        }

        if (!newInfo.getLeague().equals(oldInfo.getLeague())) {
            return false;
        }

        if (!newInfo.getHome().equals(oldInfo.getHome())) {
            return false;
        }

        if (!newInfo.getAway().equals(oldInfo.getAway())) {
            return false;
        }

        if (!newInfo.getMatchStatus().equals(oldInfo.getMatchStatus())) {
            return false;
        }


        return false;
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        TransferInfo.TransferMatch oldInfo = mOldList.get(oldItemPosition);
        TransferInfo.TransferMatch newInfo = mNewList.get(newItemPosition);

        TransferInfo.TransferMatch transferMatch = new TransferInfo.TransferMatch();

        if (!newInfo.getMatchNo().equals(oldInfo.getMatchNo())) {
            return false;
        } else {
            transferMatch.setMatchNo(newInfo.getMatchNo());
        }

        if (!newInfo.getLeague().equals(oldInfo.getLeague())) {
            return false;
        }else {
            transferMatch.setLeague(newInfo.getLeague());
        }

        if (!newInfo.getHome().equals(oldInfo.getHome())) {
            return false;
        }else {
            transferMatch.setHome(newInfo.getHome());
        }

        if (!newInfo.getAway().equals(oldInfo.getAway())) {
            return false;
        }else {
            transferMatch.setAway(newInfo.getAway());
        }

        if (!newInfo.getMatchStatus().equals(oldInfo.getMatchStatus())) {
            return false;
        }else {
            transferMatch.setMatchStatus(newInfo.getMatchStatus());
        }

        return transferMatch;
    }
}
