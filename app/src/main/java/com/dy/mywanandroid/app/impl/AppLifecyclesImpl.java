package com.dy.mywanandroid.app.impl;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import androidx.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;
import com.dy.mywanandroid.BuildConfig;
import com.haife.android.mcas.base.delegate.AppLifecycles;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import java.lang.reflect.Field;

import me.jessyan.autosize.AutoSizeConfig;
import me.jessyan.autosize.unit.Subunits;
import timber.log.Timber;

import static me.jessyan.autosize.utils.LogUtils.isDebug;

/**
 * @author dengyong
 * @Date 2020-05-19
 * @dec  初始化各种组件
 */
public class AppLifecyclesImpl implements AppLifecycles {
    @Override
    public void attachBaseContext(@NonNull Context base) {

    }

    @Override
    public void onCreate(@NonNull Application application) {
        initTimber();
        initTextFaceType(application);
        //qmui arch 初始化
        //QMUISwipeBackActivityManager.init(application);
        //AutoSize
        AutoSizeConfig.getInstance().getUnitsManager().setSupportDP(true).setSupportSubunits(Subunits.PT);
        //ARouter组件配置
        // 这两行必须写在init之前，否则这些配置在init过程中将无效
        if (isDebug()) {
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(application);
    }

    @Override
    public void onTerminate(@NonNull Application application) {

    }
    private void initTimber() {
        if (BuildConfig.LOG_DEBUG) {
            //Timber日志打印
            Timber.plant(new Timber.DebugTree());
        }
    }
    /**
     * 配置全局字体
     */
    private void initTextFaceType(Application application) {
        Typeface typeface = Typeface.createFromAsset(application.getAssets(), "PingFangSC-Regular.ttf");
        try {
            Field field = Typeface.class.getDeclaredField("MONOSPACE");
            field.setAccessible(true);
            field.set(null, typeface);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> new ClassicsHeader(context));
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator((context, layout) -> {
            //指定为经典Footer，默认是 BallPulseFooter
            return new ClassicsFooter(context);
        });
    }
}
