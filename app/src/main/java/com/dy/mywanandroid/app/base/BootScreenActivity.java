package com.dy.mywanandroid.app.base;

import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;

/**
 * Copyright © LingLingYi Technology Company
 *
 * @author Haife
 * @job Android Development
 * 启动页
 */
public class BootScreenActivity extends AppCompatActivity {
    /**
     * 延迟时间
     */
    private static final int WAIT_TIME = 1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new Handler().postDelayed(() -> {

            finish();
        }, WAIT_TIME);
    }
}
