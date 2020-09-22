package com.dy.mywanandroid;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dy.mywanandroid.app.base.BaseSupportActivity;
import com.dy.mywanandroid.mvp.ui.fragment.AccountFragment;
import com.dy.mywanandroid.mvp.ui.fragment.MainFragment;
import com.dy.mywanandroid.mvp.ui.fragment.ManaggerFragment;
import com.dy.mywanandroid.mvp.ui.fragment.MyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.haife.android.mcas.di.component.AppComponent;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Administrator
 *
 * @author dy
 * created at 2020/9/21 0021 10:42
 */
public class MainActivity extends BaseSupportActivity {
    @BindView(R.id.bnv_main)
    BottomNavigationView bnvMain;
    @BindView(R.id.fl_main)
    FrameLayout flMain;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        QMUIStatusBarHelper.translucent(this);
        QMUIStatusBarHelper.setStatusBarDarkMode(this);
        bnvMain.setItemIconTintList(null);
        MainFragment mainFragment = MainFragment.newInstance();
        ManaggerFragment managgerFragment =  ManaggerFragment.newInstance();
        AccountFragment accountFragment = AccountFragment.newInstance();
        MyFragment myFragment =  MyFragment.newInstance();
        loadMultipleRootFragment(R.id.fl_main,0,mainFragment, managgerFragment, accountFragment, myFragment);
        bnvMain.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_main:
                        showHideFragment(mainFragment);
                        return true;
                    case R.id.menu_managger:
                        showHideFragment(managgerFragment);
                        return true;
                    case R.id.menu_account:
                        showHideFragment(accountFragment);
                        return true;
                    case R.id.menu_my:
                        showHideFragment(myFragment);
                        return true;
                    default:
                        return true;
                }
            }
        });
    }

    @Override
    public void post(Runnable runnable) {

    }

}