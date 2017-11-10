package com.example.aarproguardtest;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.aarproguardtest.bean.TabEntity;
import com.example.aarproguardtest.buyback.TransferableFragment;
import com.example.aarproguardtest.buyback.TransferredFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BuyBackActivity extends AppCompatActivity {

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.commonTabLayout)
    CommonTabLayout mCommonTabLayout;
    @BindView(R.id.fl_content)
    FrameLayout mFlContent;
    private TransferableFragment mTransferableFragment;
    private TransferredFragment mTransferredFragment;
    private FragmentManager mFm;

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private String[] mTitles = {"可转让", "已转让"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_back);
        ButterKnife.bind(this);

        initTitleBar();
        initViews();
        initDatas();
    }

    public void initTitleBar() {
        setSupportActionBar(mToolbar);
        mTvTitle.setText("彩票转让");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.back_icon);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void initViews() {

    }

    public void initDatas() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i]));
        }

        mCommonTabLayout.setTabData(mTabEntities);

        mTransferableFragment = TransferableFragment.newInstance("", "");
        mTransferredFragment = TransferredFragment.newInstance("", "");
        mFm = getSupportFragmentManager();
        mFm.beginTransaction()
                .add(R.id.fl_content, mTransferredFragment)
                .add(R.id.fl_content, mTransferableFragment)
                .hide(mTransferredFragment)
                .show(mTransferableFragment)
                .commitAllowingStateLoss();

        mCommonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                switchTab(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        mCommonTabLayout.setCurrentTab(0);
    }

    private void switchTab(int position) {
        switch (position) {
            case 0:
                mFm.beginTransaction()
                        .hide(mTransferredFragment)
                        .show(mTransferableFragment)
                        .commitAllowingStateLoss();
                break;
            case 1:
                mFm.beginTransaction()
                        .hide(mTransferableFragment)
                        .show(mTransferredFragment)
                        .commitAllowingStateLoss();
                break;
        }
    }

}
