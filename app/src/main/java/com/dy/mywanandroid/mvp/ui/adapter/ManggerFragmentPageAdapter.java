package com.dy.mywanandroid.mvp.ui.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.dy.mywanandroid.mvp.http.entity.result.ProjectTypeList;

import java.util.List;

/**
 * Administrator
 *
 * @author dy
 * created at 2020/9/24 0024 9:09
 */
public class ManggerFragmentPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private ProjectTypeList dataBean;
    public ManggerFragmentPageAdapter(@NonNull FragmentManager fm, List<Fragment> list,ProjectTypeList dataBean) {
        super(fm);
        this.list = list;
        this.dataBean = dataBean;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list != null ? list.get(position) : null;
    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return dataBean.getData().get(position).getName();
    }
}
