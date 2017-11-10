package com.example.aarproguardtest.buyback;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aarproguardtest.R;
import com.example.aarproguardtest.adapter.BuyBackAdapter;
import com.example.aarproguardtest.bean.TransferInfo;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;

/**
 * 彩票转让：已转让
 *
 * @author WangKai
 */
public class TransferredFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private RecyclerView mRecyclerview;
    private BuyBackAdapter mBuyBackAdapter;
    private View mContentLayout;
    private View mLoadingView;
    private SmartRefreshLayout mSmartRefreshLayout;


    public TransferredFragment() {
        // Required empty public constructor
    }

    public static TransferredFragment newInstance(String param1, String param2) {
        TransferredFragment fragment = new TransferredFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContentLayout = inflater.inflate(R.layout.fragment_transferable, container, false);
        initViews();
        initData();
        return mContentLayout;
    }

    public void initViews() {
        mSmartRefreshLayout = (SmartRefreshLayout) mContentLayout.findViewById(R.id.smartRefreshLayout);
        mRecyclerview = (RecyclerView) mContentLayout.findViewById(R.id.recyclerView);
        mLoadingView = mContentLayout.findViewById(R.id.ll_loading);
    }

    private void initData() {
        mSmartRefreshLayout.setEnableRefresh(false);
        mSmartRefreshLayout.setEnableLoadmore(true);
        mSmartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

            }
        });

        mRecyclerview.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        ArrayList<TransferInfo> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TransferInfo e = new TransferInfo();
            ArrayList<TransferInfo.TransferMatch> subItems = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                TransferInfo.TransferMatch transferMatch = new TransferInfo.TransferMatch();
                transferMatch.setMatchNo("周三 001");
                transferMatch.setLeague("巴甲");
                transferMatch.setHome("巴竞技");
                transferMatch.setAway("戈竞技");
                transferMatch.setMatchStatus("未开赛");
                for (int k = 0; k < 3; k++) {
                    ArrayList<TransferInfo.TransferSp> sps = new ArrayList<>();
                    for (int M = 0; M < 5; M++) {

                        TransferInfo.TransferSp transferSp = new TransferInfo.TransferSp();
                        transferSp.setName("主胜");
                        transferSp.setJcSp("1.33");
                        transferSp.setAddPercent("0.039");
                        sps.add(transferSp);
                    }
                    transferMatch.setSpList(sps);
                }
                subItems.add(transferMatch);
            }
            e.setMatchList(subItems);
            data.add(e);
        }
        mBuyBackAdapter = new BuyBackAdapter(data);
        mBuyBackAdapter.bindToRecyclerView(mRecyclerview);
        mBuyBackAdapter.setEmptyView(R.layout.buy_back_empty);

    }


}
