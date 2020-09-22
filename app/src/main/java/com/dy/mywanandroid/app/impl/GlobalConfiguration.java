package com.dy.mywanandroid.app.impl;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.dy.mywanandroid.BuildConfig;
import com.dy.mywanandroid.mvp.http.api.Api;
import com.haife.android.mcas.base.delegate.AppLifecycles;
import com.haife.android.mcas.di.module.GlobalConfigModule;
import com.haife.android.mcas.http.imageloader.GlideImageLoaderStrategy;
import com.haife.android.mcas.http.log.RequestInterceptor;
import com.haife.android.mcas.integration.ConfigModule;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author dengyong
 * @Date 2020-05-19
 * @dec
 */
public class GlobalConfiguration implements ConfigModule {
    private static final int DEFAULT_TIME_OUT = 10;

    @Override
    public void applyOptions(Context context, GlobalConfigModule.Builder builder) {
        if (!BuildConfig.LOG_DEBUG) {
            //Release 时,让框架不再打印 Http 请求和响应的信息
            builder.printHttpLogLevel(RequestInterceptor.Level.NONE);
        }
//        Api.APP_DOMAIN  = BuildConfig.API_HOST; public static final String API_HOST = "http://120.76.29.181:8899/lly-ylapp/";
        builder.baseurl(Api.APP_DOMAIN)
                .retrofitConfiguration((context1, retrofitBuilder) -> {
                    retrofitBuilder.addConverterFactory(FastJsonConverterFactory.create());
                })
                .globalHttpHandler(new GlobalHttpHandleImpl(context))
                .imageLoaderStrategy(new GlideImageLoaderStrategy())
                .okhttpConfiguration((context1, okhttpBuilder) -> {
                    okhttpBuilder.writeTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);
                })
                .responseErrorListener(new ResponseErrorListenerImpl())
                .rxCacheConfiguration((context1, rxCacheBulider) -> {
                    rxCacheBulider.useExpiredDataIfLoaderNotAvailable(true);
                    // 想自定义 RxCache 的缓存文件夹或者解析方式, 如改成 fastjson, 请 return rxCacheBuilder.persistence(cacheDirectory, new FastJsonSpeaker());
                    // 否则请 return null;
                    return null;
                });

    }


    @Override
    public void injectAppLifecycle(Context context, List<AppLifecycles> lifecycles) {
        // AppLifecycles 的所有方法都会在基类 Application 的对应的生命周期中被调用,所以在对应的方法中可以扩展一些自己需要的逻辑
        // 可以根据不同的逻辑添加多个实现类
        lifecycles.add(new AppLifecyclesImpl());
    }

    @Override
    public void injectActivityLifecycle(Context context, List<Application.ActivityLifecycleCallbacks> lifecycles) {
        // ActivityLifecycleCallbacks 的所有方法都会在 Activity (包括三方库) 的对应的生命周期中被调用,所以在对应的方法中可以扩展一些自己需要的逻辑
        // 可以根据不同的逻辑添加多个实现类
        lifecycles.add(new ActivityLifecycleCallbacksImpl());
    }

    @Override
    public void injectFragmentLifecycle(Context context, List<FragmentManager.FragmentLifecycleCallbacks> lifecycles) {
        lifecycles.add(new FragmentLifecycleCallbacksImpl());
    }

}
