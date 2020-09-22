package com.dy.mywanandroid.mvp.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dy.mywanandroid.mvp.http.entity.result.BannerList;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;
/**
 *  Administrator
 *  @author dy
 *  created at 2020/9/21 0021 16:58
 */
public class BannerImageAdapter extends BannerAdapter<BannerList.DataBean, BannerImageAdapter.BannerViewHolder> {
    private Context context;
    public BannerImageAdapter(List<BannerList.DataBean> datas,Context context) {
        super(datas);
        this.context = context;
    }

    @Override
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new BannerViewHolder(imageView);
    }

    @Override
    public void onBindView(BannerViewHolder holder, BannerList.DataBean data, int position, int size) {
        Glide.with(context).load(data.getImagePath()).into(holder.imageView);
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public BannerViewHolder(@NonNull ImageView view) {
            super(view);
            this.imageView = view;
        }
    }
}
