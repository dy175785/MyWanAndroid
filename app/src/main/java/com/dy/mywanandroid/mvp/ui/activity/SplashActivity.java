package com.dy.mywanandroid.mvp.ui.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.dy.mywanandroid.MainActivity;
import com.dy.mywanandroid.R;
import com.haife.android.mcas.base.BaseActivity;
import com.haife.android.mcas.di.component.AppComponent;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

public class SplashActivity extends BaseActivity {
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100){
                start();
            }
        }
    };
    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.splash;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        QMUIStatusBarHelper.translucent(this);
        QMUIStatusBarHelper.setStatusBarLightMode(this);
        handler.sendEmptyMessageDelayed(100,2000);
    }

    private void start(){
        startActivity(new Intent(this, MainActivity.class));
        this.finish();
    }
}