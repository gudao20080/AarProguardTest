package com.example.aarproguardtest.buyback;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.aarproguardtest.R;
import com.example.aarproguardtest.adapter.BuyBackAdapter;
import com.example.aarproguardtest.adapter.BuyBackListAdapter;
import com.example.aarproguardtest.bean.TransferInfo;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;

/**
 * 彩票转让：可转让
 *
 * @author WangKai
 */
public class TransferableFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private View mContentLayout;
//    private RecyclerView mRecyclerView;
    private View mLoadingView;
    private SmartRefreshLayout mSmartRefreshLayout;
    private ImageView mIvLoading;
    private ListView mListView;
    private BuyBackAdapter mBuyBackAdapter;


    public TransferableFragment() {
        // Required empty public constructor
    }

    public static TransferableFragment newInstance(String param1, String param2) {
        TransferableFragment fragment = new TransferableFragment();
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
        mContentLayout = inflater.inflate(R.layout.fragment_list, container, false);
        initViews();
        initData();
        return mContentLayout;
    }

    public void initViews() {
        mSmartRefreshLayout = (SmartRefreshLayout) mContentLayout.findViewById(R.id.smartRefreshLayout);
//        mRecyclerView = (RecyclerView) mContentLayout.findViewById(R.id.recyclerView);
        mListView = mContentLayout.findViewById(R.id.listView);
        mLoadingView = mContentLayout.findViewById(R.id.ll_loading);
        mIvLoading = (ImageView) mLoadingView.findViewById(R.id.iv_loading);
    }

    private void initData() {

        mSmartRefreshLayout.setEnableRefresh(false);
        mSmartRefreshLayout.setEnableLoadmore(true);
        mSmartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {

            }
        });

        ArrayList<TransferInfo> data = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
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

        BuyBackListAdapter adapter = new BuyBackListAdapter(data, getContext());
        mListView.setAdapter(adapter);
//        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
//        mBuyBackAdapter = new BuyBackAdapter(data);
//        mRecyclerView.setRecycledViewPool(recycledViewPool);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
////        mRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getContext())
////                .color(R.color.color_e5e5e5)
////                .size(DensityUtils.dip2px(getContext(), 0.5f))
////                .build());
//
//
//        mBuyBackAdapter.bindToRecyclerView(mRecyclerView);
//        mBuyBackAdapter.setEmptyView(R.layout.buy_back_empty);
//
//        mRecyclerView.setAdapter(mBuyBackAdapter);

//        mBuyBackAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
//            @Override
//            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                switch (view.getId()) {
//                    case R.id.btn_transfer:
//                        break;
//                }
//            }
//        });
    }

}
