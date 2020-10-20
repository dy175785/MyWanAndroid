package com.dy.mywanandroid.mvp.ui.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dy.mywanandroid.R;
import com.dy.mywanandroid.mvp.http.entity.result.RankResultt;

import java.util.List;

public class RankingItemAdapter extends BaseQuickAdapter<RankResultt.DataBean.DatasBean, BaseViewHolder> {
    private int type = 0;
    public RankingItemAdapter(int layoutResId, @Nullable List<RankResultt.DataBean.DatasBean> data,int type) {
        super(layoutResId, data);
        this.type = type;
    }

    @Override
    protected void convert(BaseViewHolder helper, RankResultt.DataBean.DatasBean item) {
        if (type == 0){
            helper.setText(R.id.tv_ranking_name,item.getUsername());
            helper.setText(R.id.tv_ranking_noun,"第"+item.getRank()+"名");
            helper.setText(R.id.tv_ranking_integral,item.getCoinCount()+"分");
            helper.setText(R.id.tv_ranking_grade,item.getLevel()+"级");
        }
//        if (type == 1){
//            helper.setText(R.id.tv_ranking_name,item.getDatasBean1s().get(helper.getLayoutPosition()).getUserName());
//            helper.setText(R.id.tv_ranking_noun,"增减原因："+item.getDatasBean1s().get(helper.getLayoutPosition()).getReason());
//            helper.setText(R.id.tv_ranking_integral,"积分："+item.getDatasBean1s().get(helper.getLayoutPosition()).getCoinCount()+"分");
//            helper.setText(R.id.tv_ranking_grade,item.getDatasBean1s().get(helper.getLayoutPosition()).getDesc());
//        }

    }
}
