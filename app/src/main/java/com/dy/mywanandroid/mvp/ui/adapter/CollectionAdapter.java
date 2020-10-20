package com.dy.mywanandroid.mvp.ui.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dy.mywanandroid.R;
import com.dy.mywanandroid.mvp.http.entity.result.CollectionResult;
import com.dy.mywanandroid.mvp.http.entity.result.MainBlogList;

import java.util.List;

public class CollectionAdapter extends BaseQuickAdapter<CollectionResult.DataBean.DatasBean, BaseViewHolder>  {
    public CollectionAdapter(int layoutResId, @Nullable List<CollectionResult.DataBean.DatasBean> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, CollectionResult.DataBean.DatasBean item) {
        helper.setText(R.id.tv_collection_title,item.getTitle());
        helper.setText(R.id.tv_collection_time,"收藏时间："+item.getNiceDate());
        helper.addOnClickListener(R.id.tv_collection_canle);
    }
}
