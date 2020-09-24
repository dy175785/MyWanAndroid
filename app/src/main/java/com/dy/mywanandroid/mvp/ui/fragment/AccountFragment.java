package com.dy.mywanandroid.mvp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.dy.mywanandroid.R;
import com.dy.mywanandroid.app.base.BaseSupportFragment;
import com.dy.mywanandroid.di.component.DaggerManaggerComponent;
import com.dy.mywanandroid.mvp.contract.ManaggerContract;
import com.dy.mywanandroid.mvp.http.entity.result.MainBlogList;
import com.dy.mywanandroid.mvp.http.entity.result.ProjectTypeList;
import com.dy.mywanandroid.mvp.presenter.ManaggerPresenter;
import com.dy.mywanandroid.mvp.ui.adapter.ManggerFragmentPageAdapter;
import com.dy.mywanandroid.mvp.ui.adapter.ProjectDataAdapter;
import com.google.android.material.tabs.TabLayout;
import com.haife.android.mcas.di.component.AppComponent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 公众号
 *
 * @author dy
 * created at 2020/9/21 0021 14:23
 */
public class AccountFragment extends BaseSupportFragment<ManaggerPresenter> implements ManaggerContract.View {

    @BindView(R.id.tab_account)
    TabLayout tabAccount;
    @BindView(R.id.vp_account)
    ViewPager vpAccount;
    private List<Fragment> list = new ArrayList<>();
    private ManggerFragmentPageAdapter adapter;
    public static AccountFragment newInstance() {
        AccountFragment fragment = new AccountFragment();

        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerManaggerComponent.builder().view(this).appComponent(appComponent).build().inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        mPresenter.getAccountType();
    }

    @Override
    public void setData(@Nullable Object data) {

    }

    @Override
    public void post(Runnable runnable) {

    }

    @Override
    public void getProjectType(ProjectTypeList list) {

        List<ProjectTypeList.DataBean> data = list.getData();
        for (int i = 0; i < data.size(); i++) {
            tabAccount.addTab(tabAccount.newTab().setText(data.get(i).getName()));
            AccountDataFragment fragment = new AccountDataFragment(list.getData().get(i));
            this.list.add(fragment);
        }
        adapter = new ManggerFragmentPageAdapter(getChildFragmentManager(),this.list,list);
        vpAccount.setAdapter(adapter);
        tabAccount.setupWithViewPager(vpAccount);
    }

    @Override
    public void getProjectData(MainBlogList list) {

    }

    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public void showQMUITipDialog(String msg, int iconType) {

    }
}