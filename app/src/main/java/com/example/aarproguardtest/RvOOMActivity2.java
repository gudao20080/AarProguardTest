package com.example.aarproguardtest;

import android.os.Bundle;
import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.aarproguardtest.adapter.ImageLoadAdapter;
import com.example.aarproguardtest.bean.Info;
import com.example.aarproguardtest.netServer.ApiService;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class RvOOMActivity2 extends AppCompatActivity {

    RecyclerView mRv;
    SmartRefreshLayout mSmartRefreshLayout;
    private ImageLoadAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_oom2);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        mSmartRefreshLayout = findViewById(R.id.smartRefreshLayout);
        mRv = findViewById(R.id.rv);
        mRv.setItemViewCacheSize(2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRv.setLayoutManager(layoutManager);
        mAdapter = new ImageLoadAdapter(this, new ArrayList<Info.ResultBean.WareInfo>());
        mRv.setAdapter(mAdapter);

        mSmartRefreshLayout.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                loadData(true);

            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                loadData(false);
            }
        });
    }


    private int page = 1;
    private int defaultSize = 20;

    private void loadData(final boolean isLoadMore) {
        if (isLoadMore) {
            page++;
        } else {
            page = 1;
        }

        try {
            ApiService.getList(page, defaultSize, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, final Response response) throws IOException {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ResponseBody responseBody = response.body();
                            String str = null;
                            try {
                                str = responseBody.string();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Gson gson = new Gson();
                            Info info = gson.fromJson(str, Info.class);
                            List<Info.ResultBean.WareInfo> wareInfos = info.getResult().getWareInfo();

                            if (wareInfos != null && wareInfos.size() > 0) {

                                if (isLoadMore) {
                                    mAdapter.getList().addAll(wareInfos);
                                    mSmartRefreshLayout.finishLoadmore();

                                } else {
                                    mAdapter.getList().clear();
                                    mAdapter.getList().addAll(wareInfos);
                                    mSmartRefreshLayout.finishRefresh();
                                }
                            }else {
                                Toast.makeText(RvOOMActivity2.this, "没有更多数据了", Toast.LENGTH_SHORT).show();
                            }
                            mAdapter.notifyDataSetChanged();
                        }
                    });

                }
            });
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
