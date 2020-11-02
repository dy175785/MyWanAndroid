package com.dy.mywanandroid.app.base;

import com.haife.android.mcas.base.BaseApplication;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

public class MyApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化SDK
        UMConfigure.init(this, "5f9692611c520d3073988007", "玩Android", UMConfigure.DEVICE_TYPE_PHONE, null);
        // 选用AUTO页面采集模式
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);
    }
}
