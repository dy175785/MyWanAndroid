package com.dy.mywanandroid.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dy.mywanandroid.R;
import com.dy.mywanandroid.app.base.BaseSupportActivity;
import com.dy.mywanandroid.di.component.DaggerMyComponent;
import com.dy.mywanandroid.mvp.contract.MyContract;
import com.dy.mywanandroid.mvp.http.entity.result.RankResultt;
import com.dy.mywanandroid.mvp.presenter.MyPresenter;
import com.dy.mywanandroid.mvp.ui.adapter.IntergralItemAdapter;
import com.dy.mywanandroid.mvp.ui.adapter.RankingItemAdapter;
import com.dy.mywanandroid.utils.AppHelper;
import com.haife.android.mcas.di.component.AppComponent;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RankingActivity extends BaseSupportActivity<MyPresenter> implements MyContract.View {
    @BindView(R.id.rv_ranking)
    RecyclerView rvRanking;
    @BindView(R.id.srl_ranking)
    SmartRefreshLayout srlRanking;
    @BindView(R.id.qtb_ranking)
    QMUITopBar qtbRanking;
    private List<RankResultt.DataBean.DatasBean> list = new ArrayList<>();
    private int page = 1;
    private RankingItemAdapter adapter;
    private QMUITipDialog qmuiTipDialog ;
    private IntergralItemAdapter adapter1;
    private List<RankResultt.DataBean.DatasBean1> list1 = new ArrayList<>();
    @Override
    public void getRanking(RankResultt resultt) {
        if (resultt != null) {
            if (page == 0) {
                list.clear();
            }
            if (page != 1 && resultt.getData().getDatas().size() == 0) {
                page--;
            }
            list.addAll(resultt.getData().getDatas());
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getIntegral(RankResultt resultt) {
        if (resultt != null) {
            if (page == 0) {
                list.clear();
            }
            if (page != 1 && resultt.getData().getDatas().size() == 0) {
                page--;
            }
            list1.addAll(resultt.getData().getDatasBean1s());
            adapter1.notifyDataSetChanged();
        }
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMyComponent.builder()
                .view(this)
                .appComponent(appComponent)
                .build().inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_ranking;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        QMUIStatusBarHelper.translucent(this);
        QMUIStatusBarHelper.setStatusBarDarkMode(this);
        qtbRanking.addLeftImageButton(R.mipmap.icon_back,R.id.qtb_ranking).setOnClickListener(v -> finish());
        Intent intent = getIntent();
        showLoading();
        rvRanking.setLayoutManager(new LinearLayoutManager(this));
        if (intent.getIntExtra(AppHelper.MY_INTENT_DATA,-1)==0){
            qtbRanking.setTitle("排行榜");
            adapter = new RankingItemAdapter(R.layout.item_ranking_list,list,0);
            mPresenter.getRanking(page);
            adapter.bindToRecyclerView(rvRanking);
            srlRanking.setOnRefreshListener(refreshLayout -> {
                page = 0;
                srlRanking.setEnableLoadMore(false);
                mPresenter.getRanking(page);
                srlRanking.finishRefresh();
                srlRanking.setEnableLoadMore(true);
            });
            srlRanking.setOnLoadMoreListener(refreshLayout -> {
                page++;
                srlRanking.setEnableRefresh(false);
                mPresenter.getRanking(page);
                srlRanking.finishLoadMore();
                srlRanking.setEnableRefresh(true);
            });
        }

        if (intent.getIntExtra(AppHelper.MY_INTENT_DATA,-1)==1){
            qtbRanking.setTitle("我的积分");
            adapter1 = new IntergralItemAdapter(R.layout.item_ranking_list,list1,1);
            mPresenter.getIntegral(page);
            adapter.bindToRecyclerView(rvRanking);
            srlRanking.setOnRefreshListener(refreshLayout -> {
                page = 0;
                srlRanking.setEnableLoadMore(false);
                mPresenter.getIntegral(page);
                srlRanking.finishRefresh();
                srlRanking.setEnableLoadMore(true);
            });
            srlRanking.setOnLoadMoreListener(refreshLayout -> {
                page++;
                srlRanking.setEnableRefresh(false);
                mPresenter.getIntegral(page);
                srlRanking.finishLoadMore();
                srlRanking.setEnableRefresh(true);
            });
        }


    }

    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public void showQMUITipDialog(String msg, int iconType) {

    }

    @Override
    public void post(Runnable runnable) {

    }

    @Override
    public void showLoading() {
        QMUITipDialog.Builder builder = new QMUITipDialog.Builder(this);
        builder.setTipWord("加载中");
        qmuiTipDialog = builder.setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING).create();
        qmuiTipDialog.show();
    }

    @Override
    public void hideLoading() {
        qmuiTipDialog.dismiss();
    }
}