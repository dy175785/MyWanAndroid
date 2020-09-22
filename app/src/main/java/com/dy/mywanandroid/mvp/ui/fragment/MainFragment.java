package com.dy.mywanandroid.mvp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dy.mywanandroid.R;
import com.dy.mywanandroid.app.base.BaseSupportFragment;
import com.dy.mywanandroid.di.component.DaggerMainComponent;
import com.dy.mywanandroid.mvp.contract.MianContract;
import com.dy.mywanandroid.mvp.http.entity.result.BannerList;
import com.dy.mywanandroid.mvp.http.entity.result.MainBlogList;
import com.dy.mywanandroid.mvp.presenter.MainPresenter;
import com.dy.mywanandroid.mvp.ui.adapter.BannerImageAdapter;
import com.dy.mywanandroid.mvp.ui.adapter.MainRvAdapter;
import com.haife.android.mcas.di.component.AppComponent;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Administrator
 *
 * @author dy
 * created at 2020/9/21 0021 14:18
 */
public class MainFragment extends BaseSupportFragment<MainPresenter> implements MianContract.View {

    @BindView(R.id.banner_main)
    Banner bannerMain;
    @BindView(R.id.rv_main)
    RecyclerView rvMain;
    @BindView(R.id.srl_main)
    SmartRefreshLayout srlMain;
    private List<MainBlogList.DataBean.DatasBean> blogList = new ArrayList<>();
    private int page = 0;
    private MainRvAdapter adapter;
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .view(this)
                .build().inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        mPresenter.getBanner();
        mPresenter.getBlog(page);
        adapter = new MainRvAdapter(R.layout.main_item_blog_list,blogList);
        rvMain.setLayoutManager(new LinearLayoutManager(mContext));
        adapter.bindToRecyclerView(rvMain);
        srlMain.setOnRefreshListener(refreshLayout -> {
            page = 0;
            srlMain.setEnableLoadMore(false);
            mPresenter.getBlog(page);
            srlMain.setEnableLoadMore(true);
            srlMain.finishRefresh();
        });
        srlMain.setOnLoadMoreListener(refreshLayout -> {
            page++;
            srlMain.setEnableRefresh(false);
            mPresenter.getBlog(page);
            srlMain.setEnableRefresh(true);
            srlMain.finishLoadMore();
        });

    }

    @Override
    public void setData(@Nullable Object data) {

    }

    @Override
    public void post(Runnable runnable) {

    }

    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public void showQMUITipDialog(String msg, int iconType) {

    }

    @Override
    public void getBanner(BannerList list) {
        BannerImageAdapter adapter = new BannerImageAdapter(list.getData(), mContext);
        bannerMain.addBannerLifecycleObserver(this).setAdapter(adapter).setIndicator(new CircleIndicator(mContext));

    }

    @Override
    public void getBlogList(MainBlogList list) {
        if (list != null){
            if (page == 0){
                blogList.clear();
            }
            if (page != 0 && list.getData().getDatas().size() == 0){
                page--;
            }
            blogList.addAll(list.getData().getDatas());
            adapter.notifyDataSetChanged();
        }
    }
}