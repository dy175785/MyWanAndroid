package com.dy.mywanandroid.mvp.ui.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.utils.TextUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dy.mywanandroid.R;
import com.dy.mywanandroid.mvp.http.entity.result.MainBlogList;
import com.dy.mywanandroid.mvp.http.entity.result.ProjectDataList;
import com.dy.mywanandroid.utils.AppHelper;
import com.sackcentury.shinebuttonlib.ShineButton;

import java.util.List;

/**
 *  Administrator
 *  @author dy
 *  created at 2020/9/24 0024 8:44
 */
public class ProjectDataAdapter extends BaseQuickAdapter<MainBlogList.DataBean.DatasBean, BaseViewHolder> {

    public ProjectDataAdapter(int layoutResId, @Nullable List<MainBlogList.DataBean.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainBlogList.DataBean.DatasBean item) {
        helper.setText(R.id.tv_main_author,item.getAuthor());
        helper.setText(R.id.tv_main_type_1,item.getSuperChapterName());
        helper.setText(R.id.tv_main_cntent,item.getTitle());
        helper.setText(R.id.tv_main_time,item.getNiceDate());
        Glide.with(mContext).load(item.getEnvelopePic()).into((ImageView) helper.getView(R.id.iv_project));
        helper.setText(R.id.tv_main_cntent,item.getTitle());
        helper.addOnClickListener(R.id.sb_main);
    }
}
