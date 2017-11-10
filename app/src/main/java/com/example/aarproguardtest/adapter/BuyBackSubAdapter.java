package com.example.aarproguardtest.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aarproguardtest.R;
import com.example.aarproguardtest.bean.TransferInfo;

import java.util.List;

/**
 * Created by WangKai on 2017/10/24.
 */

public class BuyBackSubAdapter extends RecyclerView.Adapter<BuyBackSubAdapter.ViewHolder> {
    private RecyclerView.RecycledViewPool mRecycledViewPool;
    private List<TransferInfo.TransferMatch> mlist;
    private boolean expand = true;

    public BuyBackSubAdapter(@Nullable List<TransferInfo.TransferMatch> data) {
        mlist = data;
        expand(false);
    }

    public void setAllData(List<TransferInfo.TransferMatch> data) {
        mlist = data;
    }

    public void setRecycledViewPool(RecyclerView.RecycledViewPool recycledViewPool) {
        mRecycledViewPool = recycledViewPool;
    }

    /**
     * 是否全部展示列表
     *
     * @param expand
     */
    public void expand(boolean expand) {
        this.expand = expand;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.buy_back_item_sub, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TransferInfo.TransferMatch item = mlist.get(position);
        holder.tvDate.setText(item.getMatchNo() + " " + item.getLeague());
        holder.tvVs.setText(item.getHome() + "" + item.getAway());
        holder.tvStatus.setText(item.getMatchStatus());

//        ArrayList<TransferInfo.TransferSp> sps = item.getSpList();
//        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//        holder.rv.setLayoutManager(layoutManager);
//        BuyBackBetAdapter adapter = new BuyBackBetAdapter(sps);
//        adapter.bindToRecyclerView(holder.rv);
    }

    @Override
    public int getItemCount() {
        if (mlist == null) {
            return 0;
        }

        int size = mlist.size();
        if (expand && size > 1) {
            return size;
        } else {
            return 1;
        }
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDate;
        TextView tvVs;
        TextView tvStatus;
        RecyclerView rv;

        public ViewHolder(View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvVs = itemView.findViewById(R.id.tv_vs);
            tvStatus = itemView.findViewById(R.id.tv_status);
            rv = itemView.findViewById(R.id.rv);

        }
    }
}
