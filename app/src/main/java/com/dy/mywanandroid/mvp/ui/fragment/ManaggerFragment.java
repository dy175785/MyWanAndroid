package com.dy.mywanandroid.mvp.ui.fragment;

import android.os.Bundle;
import android.util.Log;
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
import com.dy.mywanandroid.mvp.http.entity.result.ProjectDataList;
import com.dy.mywanandroid.mvp.http.entity.result.ProjectTypeList;
import com.dy.mywanandroid.mvp.presenter.ManaggerPresenter;
import com.dy.mywanandroid.mvp.ui.adapter.ManggerFragmentPageAdapter;
import com.google.android.material.tabs.TabLayout;
import com.haife.android.mcas.di.component.AppComponent;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 项目
 *
 * @author dy
 * created at 2020/9/21 0021 14:21
 */
public class ManaggerFragment extends BaseSupportFragment<ManaggerPresenter> implements ManaggerContract.View {

    @BindView(R.id.tl_managger)
    TabLayout tlManagger;
    @BindView(R.id.vp_managger)
    ViewPager vpManagger;
    private List<Fragment> fragmentList = new ArrayList<>();
    private ManggerFragmentPageAdapter adapter;
    public static ManaggerFragment newInstance() {
        ManaggerFragment fragment = new ManaggerFragment();
        return fragment;
    }


    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerManaggerComponent
                .builder()
                .view(this)
                .appComponent(appComponent)
                .build().inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_managger, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        mPresenter.getProjectType();
    }

    @Override
    public void setData(@Nullable Object data) {

    }

    @Override
    public void post(Runnable runnable) {

    }

    @Override
    public void getProjectType(ProjectTypeList list) {
        if (list!=null){
            List<ProjectTypeList.DataBean> data = list.getData();
            for (int i = 0; i < data.size(); i++) {
                ProjectDataFragment fragment = ProjectDataFragment.newInstance(data.get(i));
                fragmentList.add(fragment);
                tlManagger.addTab(tlManagger.newTab().setText(data.get(i).getName()));
            }
            adapter = new ManggerFragmentPageAdapter(getChildFragmentManager(),fragmentList,list);
            vpManagger.setAdapter(adapter);
            tlManagger.setupWithViewPager(vpManagger);
        }
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