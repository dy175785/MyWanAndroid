package com.dy.mywanandroid.mvp.ui.adapter;

import android.app.Activity;
import android.view.View;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.utils.TextUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dy.mywanandroid.R;
import com.dy.mywanandroid.mvp.http.entity.result.MainBlogList;
import com.dy.mywanandroid.utils.AppHelper;
import com.sackcentury.shinebuttonlib.ShineButton;

import java.util.List;

public class MainRvAdapter extends BaseQuickAdapter<MainBlogList.DataBean.DatasBean, BaseViewHolder> {
    public MainRvAdapter(int layoutResId, @Nullable List<MainBlogList.DataBean.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainBlogList.DataBean.DatasBean item) {
        if (TextUtils.isEmpty(item.getAuthor())){
            helper.setText(R.id.tv_main_author,item.getShareUser());
        }else {
            helper.setText(R.id.tv_main_author,item.getAuthor());
        }
        if (!TextUtils.isEmpty(item.getSuperChapterName())){
            helper.setText(R.id.tv_main_type_1,item.getSuperChapterName());
        }else {
            helper.setText(R.id.tv_main_type_1,"");
        }
        if (!TextUtils.isEmpty(item.getNiceShareDate())){
            helper.setText(R.id.tv_main_time,item.getNiceShareDate());
        }else {
            helper.setText(R.id.tv_main_time,item.getNiceDate());
        }
        helper.setText(R.id.tv_main_cntent,item.getTitle());

        helper.addOnClickListener(R.id.sb_main);
    }
}
