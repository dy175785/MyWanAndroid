package com.dy.mywanandroid.mvp.ui.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dy.mywanandroid.R;
import com.dy.mywanandroid.app.base.BaseSupportActivity;
import com.dy.mywanandroid.mvp.ui.fragment.LoginFragment;
import com.haife.android.mcas.di.component.AppComponent;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

public class LoginActivity extends BaseSupportActivity {


    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_login;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        QMUIStatusBarHelper.translucent(this);
        QMUIStatusBarHelper.setStatusBarDarkMode(this);
        loadRootFragment(R.id.fl_login, LoginFragment.newInstance());
    }

    @Override
    public void post(Runnable runnable) {

    }
}