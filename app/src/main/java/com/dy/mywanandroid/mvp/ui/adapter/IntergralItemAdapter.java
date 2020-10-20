package com.dy.mywanandroid.mvp.ui.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dy.mywanandroid.R;
import com.dy.mywanandroid.mvp.http.entity.result.RankResultt;

import java.util.List;

public class IntergralItemAdapter extends BaseQuickAdapter<RankResultt.DataBean.DatasBean1, BaseViewHolder> {
    private int type = 0;
    public IntergralItemAdapter(int layoutResId, @Nullable List<RankResultt.DataBean.DatasBean1> data, int type) {
        super(layoutResId, data);
        this.type = type;
    }

    @Override
    protected void convert(BaseViewHolder helper, RankResultt.DataBean.DatasBean1 item) {
        if (type == 1){
            helper.setText(R.id.tv_ranking_name,item.getUserName());
            helper.setText(R.id.tv_ranking_noun,"增减原因："+item.getReason());
            helper.setText(R.id.tv_ranking_integral,"积分："+item.getCoinCount()+"分");
            helper.setText(R.id.tv_ranking_grade,item.getDesc());
        }

    }
}
