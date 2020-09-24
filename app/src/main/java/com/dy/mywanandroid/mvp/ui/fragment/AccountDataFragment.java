package com.dy.mywanandroid.mvp.ui.fragment;

import android.content.Intent;
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
import com.dy.mywanandroid.di.component.DaggerManaggerComponent;
import com.dy.mywanandroid.mvp.contract.ManaggerContract;
import com.dy.mywanandroid.mvp.http.entity.result.MainBlogList;
import com.dy.mywanandroid.mvp.http.entity.result.ProjectTypeList;
import com.dy.mywanandroid.mvp.presenter.ManaggerPresenter;
import com.dy.mywanandroid.mvp.ui.activity.WebActivity;
import com.dy.mywanandroid.mvp.ui.adapter.MainRvAdapter;
import com.dy.mywanandroid.utils.AppHelper;
import com.haife.android.mcas.di.component.AppComponent;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AccountDataFragment extends BaseSupportFragment<ManaggerPresenter> implements ManaggerContract.View {
    @BindView(R.id.rv_project_data)
    RecyclerView rvProjectData;
    @BindView(R.id.srl_project_data)
    SmartRefreshLayout srlProjectData;
    private ProjectTypeList.DataBean datasBean;
    private List<MainBlogList.DataBean.DatasBean> datasBeans = new ArrayList<>();
    private int page = 0;
    private MainRvAdapter adapter;

    public AccountDataFragment(ProjectTypeList.DataBean datasBean) {
        this.datasBean = datasBean;
    }

    public static AccountDataFragment newInstance(ProjectTypeList.DataBean datasBean) {
        AccountDataFragment fragment = new AccountDataFragment(datasBean);

        return fragment;
    }


    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerManaggerComponent.builder().view(this).appComponent(appComponent).build().inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account_data, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        adapter = new MainRvAdapter(R.layout.item_account_data_list, datasBeans);
        rvProjectData.setLayoutManager(new LinearLayoutManager(mContext));
        adapter.bindToRecyclerView(rvProjectData);
        mPresenter.getaccountData(datasBean.getId(), 0);
        mPresenter.getProjectData(0, datasBean.getId());
        srlProjectData.setOnRefreshListener(refreshLayout -> {
            srlProjectData.setEnableLoadMore(false);
            page = 0;
            mPresenter.getProjectData(page, datasBean.getId());
            srlProjectData.finishRefresh();
            srlProjectData.setEnableLoadMore(true);
        });
        srlProjectData.setOnLoadMoreListener(refreshLayout -> {
            srlProjectData.setEnableRefresh(false);
            page++;
            mPresenter.getProjectData(page, datasBean.getId());
            srlProjectData.finishLoadMore();
            srlProjectData.setEnableRefresh(true);
        });
        adapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent();
            intent.putExtra(AppHelper.MAIN_WEB_DATA, datasBeans.get(position));
            intent.setClass(mContext, WebActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void setData(@Nullable Object data) {

    }

    @Override
    public void post(Runnable runnable) {

    }

    @Override
    public void getProjectType(ProjectTypeList list) {

    }

    @Override
    public void getProjectData(MainBlogList list) {
        if (list != null) {
            if (page == 0) {
                datasBeans.clear();
            }
            if (list.getData().getDatas().size() == 0 | page > 0) {
                page--;
            }
            datasBeans.addAll(list.getData().getDatas());
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public void showQMUITipDialog(String msg, int iconType) {

    }
}