package com.dy.mywanandroid.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dy.mywanandroid.R;
import com.dy.mywanandroid.app.base.BaseSupportActivity;
import com.dy.mywanandroid.di.component.DaggerMyComponent;
import com.dy.mywanandroid.mvp.contract.MyContract;
import com.dy.mywanandroid.mvp.http.entity.base.BaseResponse;
import com.dy.mywanandroid.mvp.http.entity.result.CollectionResult;
import com.dy.mywanandroid.mvp.http.entity.result.MyIntegralResult;
import com.dy.mywanandroid.mvp.http.entity.result.RankResultt;
import com.dy.mywanandroid.mvp.presenter.MyPresenter;
import com.dy.mywanandroid.mvp.ui.adapter.CollectionAdapter;
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
    private int c_page = 0;
    private RankingItemAdapter adapter;
    private QMUITipDialog qmuiTipDialog ;
    private IntergralItemAdapter adapter1;
    private List<RankResultt.DataBean.DatasBean1> list1 = new ArrayList<>();
    private List<CollectionResult.DataBean.DatasBean> collLists = new ArrayList<>();
    private CollectionAdapter collectionAdapter;
    @Override
    public void getRanking(RankResultt resultt) {
        if (resultt != null) {
            if (page == 1) {
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
            if (page == 1) {
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
    public void getMyIntegral(MyIntegralResult result) {

    }

    @Override
    public void outLogin(BaseResponse response) {

    }

    @Override
    public void getColl(CollectionResult result) {
        if (result != null) {
            if (c_page == 0) {
                collLists.clear();
            }
            if (c_page != 1 && result.getData().getDatas().size() == 0) {
                c_page--;
            }
            collLists.addAll(result.getData().getDatas());
            collectionAdapter.notifyDataSetChanged();
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
        // TODO: 2020/10/20 我的界面右上角的排行榜
        if (intent.getIntExtra(AppHelper.MY_INTENT_DATA,-1)==0){
            qtbRanking.setTitle("排行榜");
            adapter = new RankingItemAdapter(R.layout.item_ranking_list,list,0);
            mPresenter.getRanking(page);
            adapter.bindToRecyclerView(rvRanking);
            srlRanking.setOnRefreshListener(refreshLayout -> {
                page = 1;
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
        // TODO: 2020/10/20  我的收藏
        if (intent.getIntExtra(AppHelper.MY_INTENT_DATA,-1)==2){
            qtbRanking.setTitle("我的收藏");
            collectionAdapter = new CollectionAdapter(R.layout.item_collection,collLists);
            mPresenter.getColl(c_page);
            collectionAdapter.bindToRecyclerView(rvRanking);
            srlRanking.setOnRefreshListener(refreshLayout -> {
                c_page = 0;
                srlRanking.setEnableLoadMore(false);
                mPresenter.getColl(c_page);
                srlRanking.finishRefresh();
                srlRanking.setEnableLoadMore(true);
            });
            srlRanking.setOnLoadMoreListener(refreshLayout -> {
                c_page++;
                srlRanking.setEnableRefresh(false);
                mPresenter.getColl(c_page);
                srlRanking.finishLoadMore();
                srlRanking.setEnableRefresh(true);
            });
            collectionAdapter.setOnItemChildClickListener((adapter, view, position) -> {
                switch (view.getId()){
                    case R.id.tv_collection_canle:
                        // TODO: 2020/10/20  取消收藏
                        mPresenter.unCollection(collLists.get(position).getOriginId());
                        break;
                    default:break;
                }
            });
            collectionAdapter.setOnItemClickListener((adapter, view, position) -> {
                Intent intent1 = new Intent();
                intent1.putExtra(AppHelper.MAIN_WEB_DATA, collLists.get(position));
                intent1.putExtra(AppHelper.MAIN_WEB_TYPE,AppHelper.MAIN_WEB_RANK);
                intent1.setClass(mContext, WebActivity.class);
                startActivity(intent1);
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